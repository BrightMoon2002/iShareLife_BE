package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessage;
import com.example.isharelife.repository.chat_room.IStatusChatRoomMessageRepository;
import com.example.isharelife.service.chat_room.IStatusChatRoomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusChatRoomMessageServiceImpl implements IStatusChatRoomMessageService {

    @Autowired
    IStatusChatRoomMessageRepository statusChatRoomMessageRepository;

    @Override
    public Iterable<StatusChatRoomMessage> findAll() {
        return statusChatRoomMessageRepository.findAll();
    }

    @Override
    public Optional<StatusChatRoomMessage> findById(Long id) {
        return statusChatRoomMessageRepository.findById(id);
    }

    @Override
    public void save(StatusChatRoomMessage statusChatRoomMessage) {
        statusChatRoomMessageRepository.save(statusChatRoomMessage);
    }

    @Override
    public void remove(Long id) {
        statusChatRoomMessageRepository.deleteById(id);
    }
}
