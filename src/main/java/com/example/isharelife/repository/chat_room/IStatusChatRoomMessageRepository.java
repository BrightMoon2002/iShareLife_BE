package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusChatRoomMessageRepository extends JpaRepository<StatusChatRoomMessage, Long> {
}
