package com.inside.service;

import com.inside.dto.MessageDto;
import java.util.List;

public interface IMessageService {

   void createNewMessage(MessageDto dto);
   List<MessageDto> getMessages(MessageDto dto);
}
