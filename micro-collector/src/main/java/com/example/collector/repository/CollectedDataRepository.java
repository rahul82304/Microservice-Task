package com.example.collector.repository;

import com.example.collector.entity.CollectedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectedDataRepository extends JpaRepository<CollectedData, Long> {
}
