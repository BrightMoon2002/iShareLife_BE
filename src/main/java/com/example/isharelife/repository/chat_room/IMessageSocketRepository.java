package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageSocketRepository extends JpaRepository<Message, Long> {
}
