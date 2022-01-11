package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.ChatRoomAccounts;
import com.example.isharelife.repository.chat_room.IChatRoomAccountsRepository;
import com.example.isharelife.service.chat_room.IChatRoomAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomAccountsServiceImpl implements IChatRoomAccountsService {

    @Autowired
    IChatRoomAccountsRepository chatRoomAccountsRepository;

    @Override
    public Iterable<ChatRoomAccounts> findAll() {
        return chatRoomAccountsRepository.findAll();
    }

    @Override
    public Optional<ChatRoomAccounts> findById(Long id) {
        return chatRoomAccountsRepository.findById(id);
    }

    @Override
    public void save(ChatRoomAccounts chatRoomAccounts) {
        chatRoomAccountsRepository.save(chatRoomAccounts);
    }

    @Override
    public void remove(Long id) {
        chatRoomAccountsRepository.deleteById(id);
    }
}
