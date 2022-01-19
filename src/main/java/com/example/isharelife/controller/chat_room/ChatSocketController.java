package com.example.isharelife.controller.chat_room;

import com.example.isharelife.model.chat_room.Message;
import com.example.isharelife.service.chat_room.IMessageService;
import com.example.isharelife.service.impl.chat_room.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class ChatSocketController {
    @Autowired
    private IMessageService messageService;

    @MessageMapping("/chats")
    @SendTo("/topic/chat")
    public Message createNewChatUsingSocket(Message message) {
        message.setDateSend(LocalDateTime.now());
         messageService.save(message);
         return message;
    }
}
