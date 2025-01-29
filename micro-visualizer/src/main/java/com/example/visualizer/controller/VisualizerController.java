package com.example.visualizer.controller;

import com.example.visualizer.entity.VisualizeData;
import com.example.visualizer.service.VisualizeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VisualizerController {

    @Autowired
    private VisualizeDataService visualizeDataService;

    @GetMapping("/saved-messages")
    public ResponseEntity<List<VisualizeData>> getSavedMessages(){
        List<VisualizeData> visualizeDataList = visualizeDataService.getSavedMessages();
        return ResponseEntity.ok(visualizeDataList);
    }

}
