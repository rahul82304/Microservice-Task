package com.example.recipient.config;

import com.example.recipient.receiver.MessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

    @Autowired
    private MessageReceiver messageReceiver;

//    @Scheduled(fixedRate = 5000)
//    public void logMessages(){
//        logger.info("Receiver service Scheduler task running");
//        List<String> messages = messageReceiver.getAllMessages();
//        logger.info("Received messages: {}", messages);
//    }

    @Scheduled(fixedRate = 5000)
    public void logMessages(){
        logger.info("Receiver service Scheduler task running");
        String messages = messageReceiver.getMessage();
        logger.info("Received messages: {}", messages);
    }

}
