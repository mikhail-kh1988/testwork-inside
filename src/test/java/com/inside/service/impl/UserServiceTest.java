package com.inside.service.impl;

import com.inside.dto.UserDto;
import com.inside.entity.User;
import com.inside.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void createNewUserTest(){

        UserDto userDto = new UserDto();
        userDto.setName("user");
        userDto.setPassword("12345");

        User user = new User();
        user.setId(1);

        Mockito.doReturn(user.getId())
                .when(userService)
                .registerUser(userDto);

        Long id = userService.registerUser(userDto);

        assertEquals(1, userService.registerUser(userDto));

    }

    @Test
    void findUserByName(){

        User user = new User();
        user.setName("user");

        Mockito.doReturn(user)
                .when(userService)
                .findUserByName("user");

    }


}
