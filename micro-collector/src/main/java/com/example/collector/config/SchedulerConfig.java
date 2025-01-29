package com.example.collector.config;

import com.example.collector.feign.RecipientClient;
import com.example.collector.service.CollectedDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import java.util.List;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);
    @Autowired
    RecipientClient recipientClient;

    @Autowired
    CollectedDataService collectedDataService;

    @Scheduled(fixedRate = 30000)
    public void fetchMessages(){
        logger.info("Collector service Scheduler running");
        List<String> messages = recipientClient.getAllMessages();
        if(messages != null && !messages.isEmpty()){
            logger.info("Fetched all messages: {}", messages);
            collectedDataService.saveMessages(messages);
        }else {
            logger.info("No messages received form Recipient.");
        }

    }

    @Scheduled(fixedRate = 25000) //5*N = 5*5 =25s
    public void fetchMessage(){
        logger.info("Collector service Scheduler running for one message per request");
        String message = recipientClient.getMessage();
        logger.info("Fetched message: {}", message);
        if(message != null && !message.isBlank()) {
            collectedDataService.saveMessage(message);
        }else {
            logger.info("No message received form Recipient.");
        }
    }
}
