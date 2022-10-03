package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.GKTestDto;
import com.example.ITFairGameProject.Dto.QuestionAnswerDto;
import com.example.ITFairGameProject.Model.GKTest;
import com.example.ITFairGameProject.Model.ItFairGameProject;
import com.example.ITFairGameProject.Repository.GKTestRepository;
import com.example.ITFairGameProject.Repository.ItFairGameProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GKTestService {

    @Autowired
    private GKTestRepository gkTestRepository;

    @Autowired
    private ItFairGameProjectRepository itFairGameProjectRepository;

    //save question info
    public ResponseEntity saveQuestion(GKTestDto dto) {

        GKTest gkTest = new GKTest();

        gkTest.setQuestion(dto.getQuestion());
        gkTest.setOptionA(dto.getOptionA());
        gkTest.setOptionB(dto.getOptionB());
        gkTest.setOptionC(dto.getOptionC());
        gkTest.setOptionD(dto.getOptionD());
        gkTest.setAnswer(dto.getAnswer());

        gkTestRepository.save(gkTest);

        return ResponseEntity.ok(dto);
    }

    //get5Questions
    public List<GKTestDto> get5Questions() {

        int firstId = 44, lastId = 63;

        List<GKTestDto> toReturn = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {

            GKTestDto dto = new GKTestDto();

            long randomId = (long) (Math.random()*(lastId-firstId))+firstId;

            GKTest gkTest = gkTestRepository.findById(randomId);

            gkTest.setId(randomId);

            dto.setId(gkTest.getId());
            dto.setQuestion(gkTest.getQuestion());
            dto.setOptionA(gkTest.getOptionA());
            dto.setOptionB(gkTest.getOptionB());
            dto.setOptionC(gkTest.getOptionC());
            dto.setOptionD(gkTest.getOptionD());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //calculate gk marks
    public ResponseEntity calculateGKMarks(QuestionAnswerDto dto) {

        ItFairGameProject itFairGameProject = new ItFairGameProject();

        long totalMarks = 0;
        long correctAnswers = 0;
        long wrongAnswers = 0;

        //question1
        GKTest gkTest = gkTestRepository.findById(dto.getQuestion1());
        if (gkTest.getAnswer().equalsIgnoreCase(dto.getAnswer1())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
              wrongAnswers += 1;
        }

        //question2
        gkTest = gkTestRepository.findById(dto.getQuestion2());
        if (gkTest.getAnswer().equalsIgnoreCase(dto.getAnswer2())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question3

        gkTest = gkTestRepository.findById(dto.getQuestion3());

        if (gkTest.getAnswer().equalsIgnoreCase(dto.getAnswer3())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question4

        gkTest = gkTestRepository.findById(dto.getQuestion4());

        if (gkTest.getAnswer().equalsIgnoreCase(dto.getAnswer4())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {

            wrongAnswers += 1;
        }

        //question5

        gkTest = gkTestRepository.findById(dto.getQuestion5());

        if (gkTest.getAnswer().equalsIgnoreCase(dto.getAnswer5())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {

            wrongAnswers += 1;
        }

        itFairGameProject.setGKTestScores(totalMarks);

        itFairGameProjectRepository.save(itFairGameProject);

        System.err.println(totalMarks);
        System.err.println(correctAnswers);
        System.err.println(wrongAnswers);

        return ResponseEntity.ok(dto);
    }
}
