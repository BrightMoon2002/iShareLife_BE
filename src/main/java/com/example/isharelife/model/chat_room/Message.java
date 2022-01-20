package com.example.isharelife.model.chat_room;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateSend;
    @Column(name = "id_sender")
    private Long idSender;
    @Column(name = "id_receiver")
    private Long idReceiver;

}
