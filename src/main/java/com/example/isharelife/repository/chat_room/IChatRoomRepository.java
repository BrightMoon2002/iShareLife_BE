package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatRoomRepository extends JpaRepository<ChatRoom, Long> {

}
