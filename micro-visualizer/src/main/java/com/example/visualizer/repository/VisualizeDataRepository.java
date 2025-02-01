package com.example.visualizer.repository;

import com.example.visualizer.entity.VisualizeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizeDataRepository extends JpaRepository<VisualizeData, Long> {
}
