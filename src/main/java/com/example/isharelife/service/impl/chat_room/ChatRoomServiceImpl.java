package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.ChatRoom;
import com.example.isharelife.repository.chat_room.IChatRoomRepository;
import com.example.isharelife.service.chat_room.IChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomServiceImpl implements IChatRoomService {

    @Autowired
    IChatRoomRepository chatRoomRepository;


    @Override
    public Iterable<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    @Override
    public Optional<ChatRoom> findById(Long id) {
        return chatRoomRepository.findById(id);
    }

    @Override
    public void save(ChatRoom chatRoom) {
        chatRoomRepository.save(chatRoom);
    }

    @Override
    public void remove(Long id) {
        chatRoomRepository.deleteById(id);
    }
}
