package com.inside.service;

import com.inside.dto.MessageDto;

import java.util.List;

public interface IMessageLoader {

    List<MessageDto> getMessages(String name);

}
