package com.example.isharelife.service.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.notification.Notification;
import com.example.isharelife.service.IGeneralService;

public interface INotificationService extends IGeneralService<Notification> {
    Iterable<Notification> findAllByAccountOrderByIdDesc(Account account);
}
