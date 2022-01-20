package com.example.isharelife.service.chat_room;

import com.example.isharelife.dto.response.mesage.IMessageByAccountId;
import com.example.isharelife.dto.response.mesage.IMessageDTO;
import com.example.isharelife.dto.response.mesage.MessageAccountShow;
import com.example.isharelife.model.chat_room.Message;
import com.example.isharelife.service.IGeneralService;


public interface IMessageService extends IGeneralService<Message> {
    Iterable<IMessageDTO> findAllMessageBySenderAndReceiver(Long id1, Long id2, Long id3, Long id4);
    Iterable<IMessageByAccountId> findAllMessageByAccountId(Long id1, Long id2);
    Iterable<IMessageDTO> findMessage();
}
