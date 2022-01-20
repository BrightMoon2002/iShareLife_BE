package com.example.isharelife.controller.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.notification.Notification;
import com.example.isharelife.service.IAccountService;
import com.example.isharelife.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    INotificationService notificationService;

    @Autowired
    IAccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id){
        Account account = accountService.findAccountById(id).get();
        return new ResponseEntity<>(notificationService.findAllByAccountOrderByIdDesc(account), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Notification notification){
        notification.setDate(LocalDateTime.now());
        notificationService.save(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        notificationService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id){
        Notification notification = notificationService.findById(id).get();
        notification.setStatus(true);
        notificationService.save(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
