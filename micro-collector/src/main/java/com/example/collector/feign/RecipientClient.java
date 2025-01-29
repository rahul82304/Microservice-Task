package com.example.collector.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "micro-recipient" , url = "http://micro-recipient:8082")
public interface RecipientClient {

    @GetMapping("/api/messages")
    List<String> getAllMessages();

    @GetMapping("/api/message")
    String getMessage();
}
