package com.inside.service.impl;

import com.inside.dto.MessageDto;
import com.inside.entity.Message;
import com.inside.entity.User;
import com.inside.repository.MessageRepository;
import com.inside.repository.UserRepository;
import com.inside.service.IMessageLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageLoaderAll implements IMessageLoader {

    private UserRepository userRepository;
    private MessageRepository repository;


    public MessageLoaderAll(){}
    public MessageLoaderAll(UserRepository userRepository, MessageRepository messageRepository){
        this.userRepository = userRepository;
        this.repository = messageRepository;
    }

    @Override
    public List<MessageDto> getMessages(String name) {
        List<MessageDto> list = new ArrayList<>();
        User user = userRepository.findByName(name);
        long urserId = user.getId();

        for (Message message:repository.findByUserId(urserId)) {
            MessageDto messageDto = new MessageDto();
            messageDto.setName(message.getUser().getName());
            messageDto.setMessage(message.getMessage());
            list.add(messageDto);
        }

        return list;
    }
}
