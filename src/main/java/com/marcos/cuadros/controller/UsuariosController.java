package com.marcos.cuadros.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.marcos.cuadros.model.request.UserDetailRequestModel;
import com.marcos.cuadros.model.response.PostRest;
import com.marcos.cuadros.model.response.UserRest;
import com.marcos.cuadros.repository.UserRepository;
import com.marcos.cuadros.service.UserServiceInterface;
import com.marcos.cuadros.shared.modelDto.PostDto;
import com.marcos.cuadros.shared.modelDto.UserDto;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuariosController {

    @Autowired
    UserServiceInterface userService;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    public UserRest getUsers(){
        return userService.getUserRest();
    }


    @PostMapping
    public UserRest createUser(
            @RequestBody UserDetailRequestModel userDetails
    ){
        UserRest userToReturn = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
        UserDto createUser = userService.createUser(userDto);

        BeanUtils.copyProperties(createUser,userToReturn);
        return userToReturn;
    }

    @GetMapping(path = "posts")
    public List<PostRest> getPost(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        List<PostDto> postDtos = userService.getUserPosts(email);
        List<PostRest> postRests = mapper.map(postDtos, new TypeToken<List<PostRest>>(){}.getType());
        for(PostRest postRest:postRests){
            if(postRest.getExpiresAt().compareTo(new Date(System.currentTimeMillis()))<0){
                postRest.setExpired(true);
            }
        }


        return postRests;
    }


}
