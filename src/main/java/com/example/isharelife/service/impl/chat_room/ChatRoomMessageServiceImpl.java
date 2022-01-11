package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.ChatRoomMessage;
import com.example.isharelife.repository.chat_room.IChatRoomMessageRepository;
import com.example.isharelife.service.chat_room.IChatRoomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomMessageServiceImpl implements IChatRoomMessageService {

    @Autowired
    IChatRoomMessageRepository chatRoomMessageRepository;

    @Override
    public Iterable<ChatRoomMessage> findAll() {
        return chatRoomMessageRepository.findAll();
    }

    @Override
    public Optional<ChatRoomMessage> findById(Long id) {
        return chatRoomMessageRepository.findById(id);
    }

    @Override
    public void save(ChatRoomMessage chatRoomMessage) {
        chatRoomMessageRepository.save(chatRoomMessage);
    }

    @Override
    public void remove(Long id) {
        chatRoomMessageRepository.deleteById(id);
    }
}
