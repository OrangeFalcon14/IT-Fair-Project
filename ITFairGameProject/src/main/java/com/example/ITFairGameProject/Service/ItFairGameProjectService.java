package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.ItFairGameProjectDto;
import com.example.ITFairGameProject.Model.GKTestScores;
import com.example.ITFairGameProject.Model.ItFairGameProject;
import com.example.ITFairGameProject.Model.TypingTest;
import com.example.ITFairGameProject.Repository.GKTestScoresRepository;
import com.example.ITFairGameProject.Repository.ItFairGameProjectRepository;
import com.example.ITFairGameProject.Repository.TypingTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItFairGameProjectService {

    @Autowired
    private ItFairGameProjectRepository itFairGameProjectRepository;

    @Autowired
    private GKTestScoresRepository gkTestScoresRepository;

    @Autowired
    private TypingTestRepository typingTestRepository;

    //getScores
    public ResponseEntity calculateScores(ItFairGameProjectDto dto) {

        ItFairGameProject itFairGameProject = new ItFairGameProject();
        String userName = dto.getUserName();
        TypingTest typingTest = typingTestRepository.findTypingTestByUserName(userName);
        GKTestScores gkTestScores = gkTestScoresRepository.findGKTestScoresByUserName(userName);
        long totalScores = (gkTestScores.getTotalMarks() + typingTest.getUserScore());

        dto.setTotalPoints(totalScores);
        itFairGameProject.setUserName(dto.getUserName());
        itFairGameProject.setGKTestScores(gkTestScores.getTotalMarks());
        itFairGameProject.setTypingTestScores(typingTest.getUserScore());
        itFairGameProject.setTotalPoints(dto.getTotalPoints());

        itFairGameProjectRepository.save(itFairGameProject);

        return ResponseEntity.ok(dto);
    }
}
