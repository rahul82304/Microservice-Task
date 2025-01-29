package com.example.sender.controller;

import com.example.sender.dto.NotificationDto;
import com.example.sender.service.NotificationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationService;

    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@Valid @RequestBody NotificationDto notificationRequest){

        logger.info("Received notification: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest.getMessage());
        logger.info("Message sent : "+ notificationRequest.getMessage());
        return ResponseEntity.ok("Notification sent to queue successfully");
    }
}
