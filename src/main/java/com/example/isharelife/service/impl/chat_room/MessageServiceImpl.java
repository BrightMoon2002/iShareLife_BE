package com.example.isharelife.service.impl.chat_room;

import com.example.isharelife.dto.response.mesage.IMessageByAccountId;
import com.example.isharelife.dto.response.mesage.IMessageDTO;
import com.example.isharelife.dto.response.mesage.MessageAccountShow;
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
    public Message save(Message message) {
        return messageSocketRepository.save(message);
    }

    @Override
    public void remove(Long id) {
        messageSocketRepository.deleteById(id);
    }

    @Override
    public Iterable<IMessageDTO> findAllMessageBySenderAndReceiver(Long id1, Long id2, Long id3, Long id4) {
        return messageSocketRepository.findAllMessageBySenderAndReceiver(id1, id2, id3, id4);
    }

    @Override
    public Iterable<IMessageByAccountId> findAllMessageByAccountId(Long id1, Long id2) {
        return messageSocketRepository.findAllMessageByAccountId(id1, id2);
    }

    @Override
    public Iterable<IMessageDTO> findMessage() {
        return messageSocketRepository.findMessage();
    }
}
