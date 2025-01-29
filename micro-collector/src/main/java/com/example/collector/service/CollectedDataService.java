package com.example.collector.service;

import com.example.collector.entity.CollectedData;
import com.example.collector.repository.CollectedDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectedDataService {

    private static final Logger logger = LoggerFactory.getLogger(CollectedDataService.class);

    @Autowired
    private CollectedDataRepository collectedDataRepository;

    public void saveMessages(List<String> messages){
        List<CollectedData> collectedDataList = new ArrayList<>();
        for(String message : messages){
            CollectedData data = new CollectedData();
            data.setMessage(message);
            data.setCollectedAt(LocalDateTime.now());
            collectedDataList.add(data);
        }
        collectedDataRepository.saveAll(collectedDataList);
        logger.info("Collected messages are saved to collectorDb");

    }

    public void saveMessage(String message){

        CollectedData data = new CollectedData();
        data.setMessage(message);
        data.setCollectedAt(LocalDateTime.now());
        collectedDataRepository.save(data);
        logger.info("Collected message is saved to collectorDb");

    }
}
