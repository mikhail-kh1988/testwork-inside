package com.inside.service.impl;

import com.inside.dto.UserDto;
import com.inside.entity.User;
import com.inside.repository.UserRepository;
import com.inside.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username);
    }

    @Override
    public User findUserByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Long registerUser(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));

        return repository.save(user).getId();
    }
}
