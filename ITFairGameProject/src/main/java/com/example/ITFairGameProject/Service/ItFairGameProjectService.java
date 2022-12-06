package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.ItFairGameProjectDto;
import com.example.ITFairGameProject.Dto.UserNameDto;
import com.example.ITFairGameProject.Model.*;
import com.example.ITFairGameProject.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItFairGameProjectService {

    @Autowired
    private ItFairGameProjectRepository itFairGameProjectRepository;

    @Autowired
    private GKTestScoresRepository gkTestScoresRepository;

    @Autowired
    private TypingTestRepository typingTestRepository;

    @Autowired
    private IqTestScoresRepository iqTestScoresRepository;

    @Autowired
    private OpticalIllusionScoresRepository opticalIllusionScoresRepository;

    public List<String> userNames = new ArrayList<>();

    //createUserName
    public ResponseEntity userName(UserNameDto userNameDto) {


        String userName = userNameDto.getUserName();
        Random random = new Random();

        if (userNames.contains(userName)) {

//            userName = userName+random.nextInt();
//            userNames.add(userName);
            userNameDto.setUserName(userName);
            userNameDto.setStatus("UNSUCCESSFUL, CHANGE USERNAME");
        }

        else {

            userNames.add(userName);
            userNameDto.setUserName(userName);
            userNameDto.setStatus("SUCCESSFUL");
        }

        System.err.println(userNames);

        return ResponseEntity.ok(userNameDto);
    }

    //getScores
    public ResponseEntity calculateScores(ItFairGameProjectDto dto) {

        ItFairGameProject itFairGameProject = new ItFairGameProject();
        String userName = dto.getUserName();

        TypingTest typingTest = typingTestRepository.findTypingTestByUserName(userName);
        GKTestScores gkTestScores = gkTestScoresRepository.findGKTestScoresByUserName(userName);
        IqTestScores iqTestScores = iqTestScoresRepository.findIqTestScoresByUserName(userName);
        OpticalIllusionScores opticalIllusionScores = opticalIllusionScoresRepository.findOpticalIllusionScoresByUserName(userName);
        long totalScores = (gkTestScores.getTotalMarks() + typingTest.getUserScore() + iqTestScores.getTotalMarks() + opticalIllusionScores.getTotalMarks());

        dto.setTotalPoints(totalScores);
        itFairGameProject.setUserName(dto.getUserName());
        itFairGameProject.setGKTestScores(gkTestScores.getTotalMarks());
        itFairGameProject.setTypingTestScores(typingTest.getUserScore());
        itFairGameProject.setIQTestScores(iqTestScores.getTotalMarks());
        itFairGameProject.setOpticalIllusionScores(opticalIllusionScores.getTotalMarks());
        itFairGameProject.setTotalPoints(dto.getTotalPoints());

        itFairGameProjectRepository.save(itFairGameProject);
        return ResponseEntity.ok(dto);
    }
}
