package com.example.isharelife.controller.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessageType;
import com.example.isharelife.service.chat_room.IStatusChatRoomMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statusChatRoomMessageType")
public class StatusChatRoomMessageTypeRestController {

    @Autowired
    IStatusChatRoomMessageTypeService statusChatRoomMessageTypeService;

    @GetMapping
    public ResponseEntity<Iterable<StatusChatRoomMessageType>> findAllStatusChatRoomMessageType() {
        return new ResponseEntity<>(statusChatRoomMessageTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessageType> findStatusChatRoomMessageTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(statusChatRoomMessageTypeService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusChatRoomMessageType> save(@RequestBody StatusChatRoomMessageType statusChatRoomMessageType) {
        statusChatRoomMessageTypeService.save(statusChatRoomMessageType);
        return new ResponseEntity<>(statusChatRoomMessageType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessageType> updateStatusChatRoomMessageType(@PathVariable Long id, @RequestBody StatusChatRoomMessageType statusChatRoomMessageType) {
        Optional<StatusChatRoomMessageType> statusChatRoomMessageTypeOptional = statusChatRoomMessageTypeService.findById(id);
        if (!statusChatRoomMessageTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusChatRoomMessageType.setId(statusChatRoomMessageTypeOptional.get().getId());
        statusChatRoomMessageTypeService.save(statusChatRoomMessageType);
        return new ResponseEntity<>(statusChatRoomMessageType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusChatRoomMessageType> deleteStatusChatRoomMessageType(@PathVariable Long id) {
        Optional<StatusChatRoomMessageType> statusChatRoomMessageTypeOptional = statusChatRoomMessageTypeService.findById(id);
        if (!statusChatRoomMessageTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusChatRoomMessageTypeService.remove(id);
        return new ResponseEntity<>(statusChatRoomMessageTypeOptional.get(), HttpStatus.NO_CONTENT);
    }

}
