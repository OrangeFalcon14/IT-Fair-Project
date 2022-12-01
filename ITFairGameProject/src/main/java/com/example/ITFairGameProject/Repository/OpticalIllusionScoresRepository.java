package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.OpticalIllusionScores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpticalIllusionScoresRepository extends JpaRepository<OpticalIllusionScores, Long> {

    OpticalIllusionScores findOpticalIllusionScoresByUserName(String userName);
}
