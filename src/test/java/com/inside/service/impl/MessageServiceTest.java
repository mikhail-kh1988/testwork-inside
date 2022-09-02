package com.inside.service.impl;

import com.inside.dto.MessageDto;
import com.inside.entity.Message;
import com.inside.entity.User;
import com.inside.repository.MessageRepository;
import com.inside.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
class MessageServiceTest {

    @Autowired
    private UserService  userService;

    @MockBean
    private MessageService messageService;

    @MockBean
    private MessageRepository messageRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private MessageLoaderAll messageLoaderAll;

    @Test
    void getMessagesTestWhenHistoryString() {

        MessageDto dto = new MessageDto();
        dto.setName("user");
        dto.setMessage("message");

        List<MessageDto> messageDtoList = new ArrayList<>();
        messageDtoList.add(dto);

        Message message = new Message();
        List<Message> messageList = new ArrayList<>();
        User user = new User();

        user.setId(1);
        user.setName("user");

        message.setCreateDate(LocalDateTime.now());
        message.setMessage("history 10");
        message.setUser(user);

        messageList.add(message);

        Mockito.doReturn(messageList)
                .when(messageRepository)
                .findOrderedUserByLimit(Mockito.anyLong(), Mockito.anyInt());

        messageDtoList = messageService.getMessages(dto);

        assertNotNull(messageDtoList);
    }

    @Test
    void getMessagesTestWhenAllMessages() {
        Message message = new Message();
        List<Message> messageList = new ArrayList<>();

        User user = new User();
        user.setName("user");
        user.setId(1);

        MessageDto dto = new MessageDto();
        dto.setName("user");
        dto.setMessage("message");

        List<MessageDto> messageDtoList = new ArrayList<>();
        messageDtoList.add(dto);


        message.setCreateDate(LocalDateTime.now());
        message.setMessage("");
        message.setUser(user);

        messageList.add(message);

        Mockito.doReturn(messageList)
                .when(messageRepository)
                .findAll();

        messageDtoList = messageService.getMessages(dto);

        assertNotNull(messageDtoList);
    }

}
