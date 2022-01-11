package com.example.isharelife.controller.chat_room;

import com.example.isharelife.model.chat_room.ChatRoomMessage;
import com.example.isharelife.service.chat_room.IChatRoomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/chatRoomMessage")
public class ChatRoomMessageRestController {

    @Autowired
    IChatRoomMessageService chatRoomMessageService;

    @GetMapping
    public ResponseEntity<Iterable<ChatRoomMessage>> findAllChatRoomMessage() {
        return new ResponseEntity<>(chatRoomMessageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoomMessage> findChatRoomMessageById(@PathVariable Long id) {
        return new ResponseEntity<>(chatRoomMessageService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatRoomMessage> save(@RequestBody ChatRoomMessage chatRoomMessage) {
        chatRoomMessageService.save(chatRoomMessage);
        return new ResponseEntity<>(chatRoomMessage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoomMessage> updateChatRoomMessage(@PathVariable Long id, @RequestBody ChatRoomMessage chatRoomMessage) {
        Optional<ChatRoomMessage> chatRoomMessageOptional = chatRoomMessageService.findById(id);
        if (!chatRoomMessageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoomMessage.setId(chatRoomMessageOptional.get().getId());
        chatRoomMessageService.save(chatRoomMessage);
        return new ResponseEntity<>(chatRoomMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChatRoomMessage> deleteChatRoomMessage(@PathVariable Long id) {
        Optional<ChatRoomMessage> chatRoomMessageOptional = chatRoomMessageService.findById(id);
        if (!chatRoomMessageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoomMessageService.remove(id);
        return new ResponseEntity<>(chatRoomMessageOptional.get(), HttpStatus.NO_CONTENT);
    }
}
