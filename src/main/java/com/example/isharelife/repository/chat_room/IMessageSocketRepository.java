package com.example.isharelife.repository.chat_room;

import com.example.isharelife.dto.response.mesage.IMessageDTO;
import com.example.isharelife.model.chat_room.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageSocketRepository extends JpaRepository<Message, Long> {
    @Query(value = "select m.id as id, m.content as content, m.date_send as dateSend, r.name as nameReceiver, s.name as nameSender from messages as m join accounts as r on id_receiver = r.id join accounts as s on id_sender = s.id where (id_receiver = ?1 and id_sender = ?2) or (m.id_receiver = ?3 and m.id_sender = ?4);", nativeQuery = true)
    Iterable<IMessageDTO> findAllMessageBySenderAndReceiver(Long id1, Long id2, Long id3, Long id4);
}
