package com.example.recipient.receiver;

import com.example.recipient.config.RabbitMqConfig;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageReceiver {
    public static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    private final List<String> messages;

    private final Counter messageCounter;

    public MessageReceiver(MeterRegistry meterRegistry) {
        this.messageCounter =  meterRegistry.counter("Total_Messages", "service", "micro-recipient");
        this.messages = new ArrayList<>();
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(String message){
        if (message != null) {
            this.messages.add(message);
            messageCounter.increment(); // Increment the custom metric
            logger.info("Received message: {}", message);
        }
    }

    public List<String> getAllMessages() {
        return this.messages;
    }

    public String getMessage() {
        String message = null;
        if(!messages.isEmpty()){
            message =  messages.removeFirst();
        }
        return message;
    }

    public void clearMessages(){
        logger.info("Messages are cleaned up");
        this.messages.clear();
    }
}
