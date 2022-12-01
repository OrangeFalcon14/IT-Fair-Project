package com.example.ITFairGameProject.Repository;

import com.example.ITFairGameProject.Model.IqTestScores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IqTestScoresRepository extends JpaRepository<IqTestScores, Long> {

    IqTestScores findIqTestScoresByUserName(String userName);
}
