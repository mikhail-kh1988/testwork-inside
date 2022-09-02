package com.inside.service.impl;

import com.inside.dto.MessageDto;
import com.inside.entity.Message;
import com.inside.entity.User;
import com.inside.repository.MessageRepository;
import com.inside.repository.UserRepository;
import com.inside.service.IMessageLoader;
import com.inside.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository repository;

    private IMessageLoader loader;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createNewMessage(MessageDto dto) {
        User user = userRepository.findByName(dto.getName());
        Message message = new Message();
        message.setMessage(dto.getMessage());
        message.setUser(user);
        message.setCreateDate(LocalDateTime.now());

        repository.save(message);
    }

    @Override
    public List<MessageDto> getMessages(MessageDto dto) {

        if (dto.getMessage().toLowerCase().contains("history")){
            loader = parseMessage(dto.getMessage());
        } else {
            loader = new MessageLoaderAll(userRepository, repository);
        }

        return loader.getMessages(dto.getName());
    }

    public IMessageLoader parseMessage(String message){

        String[] temp = message.split(" ");
        int count = Integer.parseInt(temp[1]);

        return new MessageLoaderHistory(count, userRepository, repository);
    }

}
