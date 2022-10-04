package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.GKTestScores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GKTestScoresRepository extends JpaRepository<GKTestScores, Long> {

    GKTestScores findGKTestScoresByUserName(String userName);
}