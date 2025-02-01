package com.example.visualizer.service;

import com.example.visualizer.entity.VisualizeData;
import com.example.visualizer.repository.VisualizeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizeDataService {

    @Autowired
    private VisualizeDataRepository visualizeDataRepository;

    public List<VisualizeData> getSavedMessages(){
        return visualizeDataRepository.findAll();
    }

}
