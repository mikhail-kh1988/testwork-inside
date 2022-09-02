package com.inside.service.impl;

import com.inside.dto.MessageDto;
import com.inside.entity.Message;
import com.inside.entity.User;
import com.inside.repository.MessageRepository;
import com.inside.repository.UserRepository;
import com.inside.service.IMessageLoader;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageLoaderHistory implements IMessageLoader {

    private int limit;
    private UserRepository userRepository;
    private MessageRepository repository;

    public MessageLoaderHistory(){}
    public MessageLoaderHistory(int limit, UserRepository userRepository, MessageRepository messageRepository){
        this.limit = limit;
        this.userRepository = userRepository;
        this.repository = messageRepository;
    }


    @Override
    public List<MessageDto> getMessages(String name) {
        List<MessageDto> list = new ArrayList<>();
        User user = userRepository.findByName(name);
        long urserId = user.getId();

        for (Message message:repository.findOrderedUserByLimit(urserId, limit)) {
            MessageDto messageDto = new MessageDto();
            messageDto.setName(message.getUser().getName());
            messageDto.setMessage(message.getMessage());
            list.add(messageDto);
        }

        return list;
    }
}
