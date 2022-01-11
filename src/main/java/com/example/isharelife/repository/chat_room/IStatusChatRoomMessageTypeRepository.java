package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.StatusChatRoomMessageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusChatRoomMessageTypeRepository extends JpaRepository<StatusChatRoomMessageType, Long> {
}
