package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.IllusionQuestionAnswerDto;
import com.example.ITFairGameProject.Dto.OpticalIllusionTestDto;
import com.example.ITFairGameProject.Dto.QuestionAnswerDto;
import com.example.ITFairGameProject.Model.OpticalIllusionScores;
import com.example.ITFairGameProject.Model.OpticalIllusionTest;
import com.example.ITFairGameProject.Repository.OpticalIllusionRepository;
import com.example.ITFairGameProject.Repository.OpticalIllusionScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpticalIllusionService {

    @Autowired
    private OpticalIllusionRepository opticalIllusionRepository;

    @Autowired
    private OpticalIllusionScoresRepository opticalIllusionScoresRepository;

    //save question
    public ResponseEntity saveQuestion(OpticalIllusionTestDto dto) {

        OpticalIllusionTest opticalIllusionTest = new OpticalIllusionTest();

        opticalIllusionTest.setImgUrl(dto.getImgUrl());
        opticalIllusionTest.setQuestion(dto.getQuestion());
        opticalIllusionTest.setOptionA(dto.getOptionA());
        opticalIllusionTest.setOptionB(dto.getOptionB());
        opticalIllusionTest.setOptionC(dto.getOptionC());
        opticalIllusionTest.setOptionD(dto.getOptionD());
        opticalIllusionTest.setAnswer(dto.getAnswer());

        opticalIllusionRepository.save(opticalIllusionTest);

        return ResponseEntity.ok(dto);
    }

    //get5Questions
    public List<OpticalIllusionTestDto> get5IllusionQuestions() {

        int firstId = 23, lastId = 28;

        List<OpticalIllusionTestDto> toReturn = new ArrayList<>();

        OpticalIllusionTestDto dto = new OpticalIllusionTestDto();

        long randomId = (long) (Math.random()*(lastId-firstId))+firstId;

        OpticalIllusionTest opticalIllusionTest = opticalIllusionRepository.findById(randomId);

        opticalIllusionTest.setId(randomId);
        dto.setId(opticalIllusionTest.getId());
        dto.setImgUrl(opticalIllusionTest.getImgUrl());
        dto.setQuestion(opticalIllusionTest.getQuestion());
        dto.setOptionA(opticalIllusionTest.getOptionA());
        dto.setOptionB(opticalIllusionTest.getOptionB());
        dto.setOptionC(opticalIllusionTest.getOptionC());
        dto.setOptionD(opticalIllusionTest.getOptionD());
        dto.setAnswer(opticalIllusionTest.getAnswer());

        toReturn.add(dto);

        while (1==1) {

            long randomId2 = (long) (Math.random()*(lastId-firstId))+firstId;
            dto = new OpticalIllusionTestDto();
            opticalIllusionTest = opticalIllusionRepository.findById(randomId2);

            if (randomId2 == randomId) {
                continue;
            }

            else {

                opticalIllusionTest.setId(randomId2);
                dto.setId(opticalIllusionTest.getId());
                dto.setImgUrl(opticalIllusionTest.getImgUrl());
                dto.setQuestion(opticalIllusionTest.getQuestion());
                dto.setOptionA(opticalIllusionTest.getOptionA());
                dto.setOptionB(opticalIllusionTest.getOptionB());
                dto.setOptionC(opticalIllusionTest.getOptionC());
                dto.setOptionD(opticalIllusionTest.getOptionD());
                dto.setAnswer(opticalIllusionTest.getAnswer());

                toReturn.add(dto);

                break;
            }
        }

        return toReturn;
    }

    //calculate the answers
    public ResponseEntity calculateOpticalIllusionMarks(IllusionQuestionAnswerDto dto) {

        OpticalIllusionScores opticalIllusionScores = new OpticalIllusionScores();

        long totalMarks = 0, correctAnswers = 0, wrongAnswers = 0;

        //question1
        OpticalIllusionTest opticalIllusionTest = opticalIllusionRepository.findById(dto.getQuestion1());

        if (opticalIllusionTest.getAnswer().equalsIgnoreCase(dto.getAnswer1())) {
            totalMarks += 5;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question2
        opticalIllusionTest = opticalIllusionRepository.findById(dto.getQuestion2());

        if (opticalIllusionTest.getAnswer().equalsIgnoreCase(dto.getAnswer2())) {
            totalMarks += 5;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        opticalIllusionScores.setUserName(dto.getUserName());
        opticalIllusionScores.setCorrectAnswers(correctAnswers);
        opticalIllusionScores.setTotalMarks(totalMarks);
        opticalIllusionScores.setWrongAnswers(wrongAnswers);

        opticalIllusionScoresRepository.save(opticalIllusionScores);

        return ResponseEntity.ok(dto);
    }
}
