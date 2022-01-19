package com.example.isharelife.repository.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Long> {
    Iterable<Notification> findAllByAccountOrderByIdDesc(Account account);
}
