package com.example.isharelife.controller.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.notification.Notification;
import com.example.isharelife.model.post.Posting;
import com.example.isharelife.repository.post.IPostingRepository;
import com.example.isharelife.service.IAccountService;
import com.example.isharelife.service.notification.INotificationService;
import com.example.isharelife.service.post.IPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class NotificationSocketController {
    @Autowired
    INotificationService notificationService;

    @Autowired
    IAccountService accountService;

    @Autowired
    IPostingService postingService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notification")
    @SendTo("/topic/notification")
    public void newNotification(Notification notification){
        Posting posting = postingService.findById(notification.getPosting().getId()).get();
        Account account = accountService.findAccountById(notification.getSender().getId()).get();
        notification.setDate(LocalDateTime.now());
        notification.setSender(account);
        notification.setPosting(posting);
        notificationService.save(notification);
        messagingTemplate.convertAndSend("/topic/notification", notification);
    }
}
