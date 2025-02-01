package com.example.sender.service;

import com.example.sender.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendNotification(String message){
        rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME, message);
    }
}
