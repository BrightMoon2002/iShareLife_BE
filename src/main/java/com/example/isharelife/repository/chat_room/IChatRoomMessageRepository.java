package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.ChatRoomMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatRoomMessageRepository extends JpaRepository<ChatRoomMessage, Long> {
}
