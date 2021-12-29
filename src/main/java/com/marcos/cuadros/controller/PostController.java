package com.marcos.cuadros.controller;

import com.marcos.cuadros.model.request.PostCreateRequestModel;
import com.marcos.cuadros.model.response.OperationStatusModel;
import com.marcos.cuadros.model.response.PostRest;
import com.marcos.cuadros.service.PostServiceInterface;
import com.marcos.cuadros.service.UserServiceInterface;
import com.marcos.cuadros.shared.modelDto.PostCreationDto;
import com.marcos.cuadros.shared.modelDto.PostDto;
import com.marcos.cuadros.shared.modelDto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostServiceInterface postService;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public PostRest createPost(@RequestBody PostCreateRequestModel createRequestModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        PostCreationDto postCreationDto= mapper.map(createRequestModel,PostCreationDto.class);
        postCreationDto.setUserEmail(email);
        PostDto postDto = postService.createPost(postCreationDto);
        PostRest postToReturn = mapper.map(postDto,PostRest.class);

        if(postToReturn.getExpiresAt().compareTo(new Date(System.currentTimeMillis()))<0){
            postToReturn.setExpired(true);
        }

        return postToReturn;
    }


    @GetMapping(path = "/last")
    public List<PostRest> lastsPost(){
        List<PostDto> posts = postService.getLastPosts();
        List<PostRest> postRests = mapper.map(posts, new TypeToken<List<PostRest>>(){}.getType());
        return postRests;
    }

    @GetMapping(path="/{id}")
    public PostRest getPost(@PathVariable String id){
        PostDto post = postService.getPost(id);
        PostRest postRest = mapper.map(post,PostRest.class);
        if(postRest.getExpiresAt().compareTo(new Date(System.currentTimeMillis()))<0){
            postRest.setExpired(true);
        }
        if(postRest.getExposure().getId() == 1 || postRest.getExpired()){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDto userDto = userServiceInterface.getUser(authentication.getPrincipal().toString());
            if(userDto.getId() != post.getUser().getId()){
                throw new RuntimeException("No tienes permisos para realizar esta accion");
            }

        }
        return postRest;
    }

    @DeleteMapping(path = "/{id}")
    public OperationStatusModel deletePost(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDto user = userServiceInterface.getUser(authentication.getPrincipal().toString());

        OperationStatusModel operationStatusModel = new OperationStatusModel();
        operationStatusModel.setName("DELETE");

        postService.deletePost(id, user.getId());
        operationStatusModel.setResult("SUCCESS");

        return operationStatusModel;
    }

    @PutMapping(path = "/{id}")
    public PostRest updatePost(@RequestBody PostCreateRequestModel postCreateRequestModel,
                               @PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDto user = userServiceInterface.getUser(authentication.getPrincipal().toString());

        PostCreationDto postUpdateDto = mapper.map(postCreateRequestModel, PostCreationDto.class);

        PostDto postDto = postService.updatePost(id, user.getId(), postUpdateDto);

        PostRest updatedPost = mapper.map(postDto, PostRest.class);

        return updatedPost;
    }

}
