package com.example.isharelife.repository.chat_room;

import com.example.isharelife.model.chat_room.ChatRoomAccounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatRoomAccountsRepository extends JpaRepository<ChatRoomAccounts, Long> {
}
