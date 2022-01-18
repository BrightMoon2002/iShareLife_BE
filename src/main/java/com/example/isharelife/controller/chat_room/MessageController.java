package com.example.isharelife.controller.chat_room;

import com.example.isharelife.dto.response.ResponseMessage;
import com.example.isharelife.dto.response.mesage.IMessageDTO;
import com.example.isharelife.model.chat_room.Message;
import com.example.isharelife.service.chat_room.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@CrossOrigin("*")
@RequestMapping("/chats")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @GetMapping("/{id1}/{id2}")
    public ResponseEntity<?> showAllMessageBySenderAndReceiver(@PathVariable(name = "id1") Long id1, @PathVariable(name = "id2") Long id2) {
        Iterable<IMessageDTO> messageDTOS = messageService.findAllMessageBySenderAndReceiver(id1, id2, id2, id1);
        return new ResponseEntity<>(messageDTOS, HttpStatus.OK);

    }
}
