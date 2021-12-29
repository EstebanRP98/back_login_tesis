package com.marcos.cuadros.service;

import com.marcos.cuadros.shared.modelDto.PostCreationDto;
import com.marcos.cuadros.shared.modelDto.PostDto;

import java.util.List;

public interface PostServiceInterface {
    public PostDto createPost(PostCreationDto post);

    public List<PostDto> getLastPosts();

    public PostDto getPost(String postId);

    public void deletePost(String postId, Long userId);

    public PostDto updatePost(String postId, long userId, PostCreationDto postUpdateDto);



}
