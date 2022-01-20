package com.example.isharelife.service.impl;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.notification.Notification;
import com.example.isharelife.repository.notification.INotificationRepository;
import com.example.isharelife.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceIml implements INotificationService {
    @Autowired
    INotificationRepository notificationRepository;

    @Override
    public Iterable<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification save(Notification notification) {
       return notificationRepository.save(notification);
    }

    @Override
    public void remove(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Iterable<Notification> findAllByAccountOrderByIdDesc(Account account) {
        return notificationRepository.findAllByAccountOrderByIdDesc(account);
    }

}
