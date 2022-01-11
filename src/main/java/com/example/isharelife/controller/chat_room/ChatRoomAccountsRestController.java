package com.example.isharelife.controller.chat_room;


import com.example.isharelife.model.chat_room.ChatRoomAccounts;
import com.example.isharelife.service.chat_room.IChatRoomAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/chatRoomAccounts")
public class ChatRoomAccountsRestController {

    @Autowired
    IChatRoomAccountsService chatRoomAccountsService;

    @GetMapping
    public ResponseEntity<Iterable<ChatRoomAccounts>> findAllChatRoomAccounts() {
        return new ResponseEntity<>(chatRoomAccountsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoomAccounts> findChatRoomAccountsById(@PathVariable Long id) {
        return new ResponseEntity<>(chatRoomAccountsService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatRoomAccounts> save(@RequestBody ChatRoomAccounts chatRoomAccounts) {
        chatRoomAccountsService.save(chatRoomAccounts);
        return new ResponseEntity<>(chatRoomAccounts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoomAccounts> updateChatRoomAccounts(@PathVariable Long id, @RequestBody ChatRoomAccounts chatRoomAccounts) {
        Optional<ChatRoomAccounts> chatRoomAccountsOptional=chatRoomAccountsService.findById(id);
        if (!chatRoomAccountsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoomAccounts.setId(chatRoomAccountsOptional.get().getId());
        chatRoomAccountsService.save(chatRoomAccounts);
        return new ResponseEntity<>(chatRoomAccounts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChatRoomAccounts> deleteChatRoomAccounts(@PathVariable Long id) {
        Optional<ChatRoomAccounts> chatRoomAccountsOptional = chatRoomAccountsService.findById(id);
        if (!chatRoomAccountsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        chatRoomAccountsService.remove(id);
        return new ResponseEntity<>(chatRoomAccountsOptional.get(), HttpStatus.NO_CONTENT);
    }

}
