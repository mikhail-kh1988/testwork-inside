package com.inside.service;

import com.inside.dto.UserDto;
import com.inside.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User findUserByName(String name);
    Long registerUser(UserDto dto);
}
