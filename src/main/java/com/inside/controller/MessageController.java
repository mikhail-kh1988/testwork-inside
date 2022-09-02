package com.inside.controller;

import com.inside.dto.MessageDto;
import com.inside.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/")
    public ResponseEntity<String> createNewMessage(@RequestBody MessageDto dto){
        messageService.createNewMessage(dto);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/get")
    public ResponseEntity<List<MessageDto>> getMessageByUser(@RequestBody MessageDto dto){
        return ResponseEntity.ok(messageService.getMessages(dto));
    }

}
