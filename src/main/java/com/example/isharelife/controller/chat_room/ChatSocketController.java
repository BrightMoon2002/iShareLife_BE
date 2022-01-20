package com.example.isharelife.controller.chat_room;

import com.example.isharelife.dto.response.mesage.MessageResponse;
import com.example.isharelife.dto.response.mesage.MessageResponseAfterCreate;
import com.example.isharelife.model.chat_room.Message;
import com.example.isharelife.service.chat_room.IMessageService;
import com.example.isharelife.service.impl.chat_room.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class ChatSocketController {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chats")
    @SendTo("/topic/chat")
    public void createNewChatUsingSocket(MessageResponse messageResponse) {
        Message message = new Message();
        message.setDateSend(LocalDateTime.now());
        message.setContent(messageResponse.getContent());
        message.setIdSender(messageResponse.getIdSender());
        message.setIdReceiver(messageResponse.getIdReceiver());
        Message message1 = messageService.save(message);
        MessageResponseAfterCreate newMessage = new MessageResponseAfterCreate();
        newMessage.setDateSend(LocalDateTime.now().toString());
        newMessage.setContent(messageResponse.getContent());
        newMessage.setIdGuest(messageResponse.getIdSender());
        newMessage.setId(message1.getId());
        messagingTemplate.convertAndSend("/topic/chat", newMessage);
    }
}
