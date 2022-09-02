package com.inside.controller;

import com.inside.dto.UserDto;
import com.inside.security.jwt.JwtProvider;
import com.inside.security.jwt.Request;
import com.inside.security.jwt.ResponseToken;
import com.inside.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtProvider provider;

    @PostMapping("/")
    public ResponseToken auth(@RequestBody Request request){
        UserDetails user = userService.findUserByName(request.getName());
        return new ResponseToken(provider.generateToken(user.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.registerUser(dto));
    }
}
