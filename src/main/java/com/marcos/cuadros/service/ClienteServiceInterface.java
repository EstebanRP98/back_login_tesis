package com.marcos.cuadros.service;

import com.marcos.cuadros.model.response.UserRest;
import com.marcos.cuadros.shared.modelDto.PostDto;
import com.marcos.cuadros.shared.modelDto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClienteServiceInterface extends UserDetailsService {

    public UserDto createUser(UserDto user);
    public UserDto getUser(String email);
    public UserRest getUserRest();

}
