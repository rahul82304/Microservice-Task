package com.example.recipient.controller;

import com.example.recipient.receiver.MessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageReceiver messageReceiver;

    @GetMapping("/messages")
    public ResponseEntity<List<String>> getMessages(){
        List<String> messages = new ArrayList<>(messageReceiver.getAllMessages());
        messageReceiver.clearMessages();
        logger.info("Returning and clearing all messages: {}", messages);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage(){
        String message = messageReceiver.getMessage();
        if(message != null){
            logger.info("Returing message from queue{}", message);
            return ResponseEntity.ok(message);
        }else {
            logger.info("No messages in the queue");
            return ResponseEntity.noContent().build();
        }
    }
}
