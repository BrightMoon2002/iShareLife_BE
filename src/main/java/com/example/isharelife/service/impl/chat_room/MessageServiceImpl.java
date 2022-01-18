package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.model.chat_room.Message;
import com.example.isharelife.repository.chat_room.IMessageSocketRepository;
import com.example.isharelife.service.chat_room.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageSocketRepository messageSocketRepository;

    @Override
    public Iterable<Message> findAll() {
        return messageSocketRepository.findAll();
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageSocketRepository.findById(id);
    }

    @Override
    public void save(Message message) {
        messageSocketRepository.save(message);
    }

    @Override
    public void remove(Long id) {
        messageSocketRepository.deleteById(id);
    }
}
