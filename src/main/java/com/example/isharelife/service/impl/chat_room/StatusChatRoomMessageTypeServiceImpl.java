package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessageType;
import com.example.isharelife.repository.chat_room.IStatusChatRoomMessageTypeRepository;
import com.example.isharelife.service.chat_room.IStatusChatRoomMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusChatRoomMessageTypeServiceImpl implements IStatusChatRoomMessageTypeService {

    @Autowired
    IStatusChatRoomMessageTypeRepository statusChatRoomMessageTypeRepository;

    @Override
    public Iterable<StatusChatRoomMessageType> findAll() {
        return statusChatRoomMessageTypeRepository.findAll();
    }

    @Override
    public Optional<StatusChatRoomMessageType> findById(Long id) {
        return statusChatRoomMessageTypeRepository.findById(id);
    }

    @Override
    public void save(StatusChatRoomMessageType statusChatRoomMessageType) {
        statusChatRoomMessageTypeRepository.save(statusChatRoomMessageType);
    }

    @Override
    public void remove(Long id) {
        statusChatRoomMessageTypeRepository.deleteById(id);
    }
}
