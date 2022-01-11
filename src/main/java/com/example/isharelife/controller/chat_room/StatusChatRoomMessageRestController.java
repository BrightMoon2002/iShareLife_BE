package com.example.isharelife.controller.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessage;
import com.example.isharelife.service.chat_room.IStatusChatRoomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statusChatRoomMessage")
public class StatusChatRoomMessageRestController {

    @Autowired
    IStatusChatRoomMessageService statusChatRoomMessageService;

    @GetMapping
    public ResponseEntity<Iterable<StatusChatRoomMessage>> findAllStatusChatRoomMessage() {
        return new ResponseEntity<>(statusChatRoomMessageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessage> findStatusChatRoomMessageById(@PathVariable Long id) {
        return new ResponseEntity<>(statusChatRoomMessageService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusChatRoomMessage> save(@RequestBody StatusChatRoomMessage statusChatRoomMessage) {
        statusChatRoomMessageService.save(statusChatRoomMessage);
        return new ResponseEntity<>(statusChatRoomMessage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessage> updateStatusChatRoomMessage(@PathVariable Long id, @RequestBody StatusChatRoomMessage statusChatRoomMessage) {
        Optional<StatusChatRoomMessage> statusChatRoomMessageOptional = statusChatRoomMessageService.findById(id);
        if (!statusChatRoomMessageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusChatRoomMessage.setId(statusChatRoomMessageOptional.get().getId());
        statusChatRoomMessageService.save(statusChatRoomMessage);
        return new ResponseEntity<>(statusChatRoomMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessage> deleteStatusChatRoomMessage(@PathVariable Long id) {
        Optional<StatusChatRoomMessage> statusChatRoomMessageOptional = statusChatRoomMessageService.findById(id);
        if (!statusChatRoomMessageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusChatRoomMessageService.remove(id);
        return new ResponseEntity<>(statusChatRoomMessageOptional.get(), HttpStatus.NO_CONTENT);
    }

}
