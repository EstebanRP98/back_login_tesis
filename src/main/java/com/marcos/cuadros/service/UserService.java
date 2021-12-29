package com.marcos.cuadros.service;

import com.marcos.cuadros.exception.EmailExistsException;
import com.marcos.cuadros.model.entity.PostEntity;
import com.marcos.cuadros.model.entity.UserEntity;
import com.marcos.cuadros.model.response.UserRest;
import com.marcos.cuadros.repository.PostRepository;
import com.marcos.cuadros.repository.UserRepository;
import com.marcos.cuadros.shared.modelDto.PostDto;
import com.marcos.cuadros.shared.modelDto.UserDto;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDto createUser(UserDto user) {
        //logica pra crear el usuario

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new EmailExistsException("El correo electronico ya existe");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());
        UserEntity storeUser = userRepository.save(userEntity);
        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storeUser,userToReturn);
        return userToReturn;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new UsernameNotFoundException(email);
        }
        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(userEntity,userToReturn);

        return userToReturn;
    }

    public UserRest getUserRest(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        UserDto userDto = getUser(email);
        UserRest userToReturn = mapper.map(userDto,UserRest.class);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }


    @Override
    public List<PostDto> getUserPosts(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        List<PostEntity> posts = postRepository.getByUserIdOrderByCreatedAtDesc(userEntity.getId());
        List<PostDto> postsDto = mapper.map(posts, new TypeToken<List<PostDto>>(){}.getType());
        return  postsDto;
    }
}
