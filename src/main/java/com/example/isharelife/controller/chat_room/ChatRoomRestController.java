package com.example.isharelife.controller.chat_room;

import com.example.isharelife.model.chat_room.ChatRoom;
import com.example.isharelife.service.chat_room.IChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/chatRoom")
public class ChatRoomRestController {

    @Autowired
    IChatRoomService chatRoomService;

    @GetMapping
    public ResponseEntity<Iterable<ChatRoom>> findAllChatRoom() {
        return new ResponseEntity<>(chatRoomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> findChatRoomById(@PathVariable Long id) {
        return new ResponseEntity<>(chatRoomService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatRoom> save(@RequestBody ChatRoom chatRoom) {
        chatRoomService.save(chatRoom);
        return new ResponseEntity<>(chatRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Long id, @RequestBody ChatRoom chatRoom) {
        Optional<ChatRoom> chatRoomOptional = chatRoomService.findById(id);
        if (!chatRoomOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoom.setId(chatRoomOptional.get().getId());
        chatRoomService.save(chatRoom);
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChatRoom> deleteChatRoom(@PathVariable Long id) {
        Optional<ChatRoom> chatRoomOptional = chatRoomService.findById(id);
        if (!chatRoomOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoomService.remove(id);
        return new ResponseEntity<>(chatRoomOptional.get(), HttpStatus.NO_CONTENT);
    }
}
