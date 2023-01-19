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

    @Autowired
    private UserNamesRepository userNamesRepository;

    //createUserName
    public ResponseEntity userName(UserNameDto userNameDto) {

        UserNames user = new UserNames();
        List<UserNames> userNamesObj = userNamesRepository.findAll();

        List<String> userNames = new ArrayList<>();

        for (UserNames userName : userNamesObj) {

            userNames.add(userName.getUserName());
        }

        String userName = userNameDto.getUserName();

        if (userNames.contains(userName)) {

            userNameDto.setUserName(userName);
            userNameDto.setStatus("UNSUCCESSFUL, CHANGE USERNAME");
        }

        else {

            userNames.add(userName);
            userNameDto.setUserName(userName);
            userNameDto.setStatus("SUCCESSFUL");
            user.setUserName(userName);
            userNamesRepository.save(user);
        }

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
        itFairGameProject.setUserRank(0);

        dto.setGKTestScores(itFairGameProject.getGKTestScores());
        dto.setTypingTestScores(itFairGameProject.getTypingTestScores());
        dto.setIQTestScores(itFairGameProject.getIQTestScores());
        dto.setOpticalIllusionScores(itFairGameProject.getOpticalIllusionScores());

        itFairGameProjectRepository.save(itFairGameProject);
        return ResponseEntity.ok(dto);
    }

    public List<ItFairGameProjectDto> getScoresInDesc() {

        List<ItFairGameProject> itFairGameProjects = itFairGameProjectRepository.findAllByOrderByTotalPointsDesc();
        List<ItFairGameProjectDto> toReturn = new ArrayList<>();

        for (long i = 1; i <= itFairGameProjects.size();) {

            for (ItFairGameProject itFairGameProject : itFairGameProjects) {

                itFairGameProject.setUserRank(i);

                ItFairGameProjectDto dto = new ItFairGameProjectDto();

                dto.setUserName(itFairGameProject.getUserName());
                dto.setGKTestScores(itFairGameProject.getGKTestScores());
                dto.setTypingTestScores(itFairGameProject.getTypingTestScores());
                dto.setIQTestScores(itFairGameProject.getIQTestScores());
                dto.setOpticalIllusionScores(itFairGameProject.getOpticalIllusionScores());
                dto.setTotalPoints(itFairGameProject.getTotalPoints());
                dto.setUserRank(itFairGameProject.getUserRank());

                ItFairGameProject itFairGameProject1 = itFairGameProjectRepository.findItFairGameProjectByUserName(dto.getUserName());
                itFairGameProjectRepository.save(itFairGameProject1);

                i++;
                toReturn.add(dto);
            }
        }
        return toReturn;
    }

    //get specific users rank
    public ItFairGameProjectDto getUserRankByUserName(String userName) {

        ItFairGameProject itFairGameProject = itFairGameProjectRepository.findItFairGameProjectByUserName(userName);
        ItFairGameProjectDto toReturn = new ItFairGameProjectDto();

        toReturn.setUserName(itFairGameProject.getUserName());
        toReturn.setGKTestScores(itFairGameProject.getGKTestScores());
        toReturn.setTypingTestScores(itFairGameProject.getTypingTestScores());
        toReturn.setIQTestScores(itFairGameProject.getIQTestScores());
        toReturn.setOpticalIllusionScores(itFairGameProject.getOpticalIllusionScores());
        toReturn.setTotalPoints(itFairGameProject.getTotalPoints());
        toReturn.setUserRank(itFairGameProject.getUserRank());

        return toReturn;
    }
}
