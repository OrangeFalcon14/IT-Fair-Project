package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.IqQuestionAnswersDto;
import com.example.ITFairGameProject.Dto.IqTestDto;
import com.example.ITFairGameProject.Model.IqTest;
import com.example.ITFairGameProject.Model.IqTestScores;
import com.example.ITFairGameProject.Model.ItFairGameProject;
import com.example.ITFairGameProject.Repository.IqTestRepository;
import com.example.ITFairGameProject.Repository.IqTestScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IqTestService {

    @Autowired
    private IqTestRepository iqTestRepository;

    @Autowired
    private IqTestScoresRepository iqTestScoresRepository;

    public List<IqTestDto> get2Questions() {

        int firstId = 8, lastId = 18;

        List<IqTestDto> toReturn = new ArrayList<>();

        List<Long> usedId = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {

            IqTestDto dto = new IqTestDto();

            long randomId = 0;

            while (1==1) {

                randomId = (long) (Math.random()*(lastId-firstId))+firstId;

                IqTest iqTest = iqTestRepository.findById(randomId);

                if (usedId.contains(randomId)) {
                    continue;
                }

                else {

                    iqTest.setId(randomId);
                    dto.setId(iqTest.getId());
                    dto.setQuestion(iqTest.getQuestion());
                    dto.setOptionA(iqTest.getOptionA());
                    dto.setOptionB(iqTest.getOptionB());
                    dto.setOptionC(iqTest.getOptionC());
                    dto.setOptionD(iqTest.getOptionD());

                    usedId.add(dto.getId());

                    break;
                }
            }

            toReturn.add(dto);
        }

        return toReturn;
    }

    public ResponseEntity saveQuestion(IqTestDto dto) {

        IqTest iqTest = new IqTest();

        iqTest.setQuestion(dto.getQuestion());
        iqTest.setOptionA(dto.getOptionA());
        iqTest.setOptionB(dto.getOptionB());
        iqTest.setOptionC(dto.getOptionC());
        iqTest.setOptionD(dto.getOptionD());
        iqTest.setAnswer(dto.getAnswer());

        iqTestRepository.save(iqTest);

        return ResponseEntity.ok(dto);
    }

    public ResponseEntity calculateIQMarks(IqQuestionAnswersDto dto) {

        IqTestScores iqTestScores = new IqTestScores();

        long totalMarks = 0;
        long correctAnswers = 0;
        long wrongAnswers = 0;

        //question1
        IqTest iqTest = iqTestRepository.findById(dto.getQuestion1());
        if (iqTest.getAnswer().equalsIgnoreCase(dto.getAnswer1())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question2
        iqTest = iqTestRepository.findById(dto.getQuestion2());
        if (iqTest.getAnswer().equalsIgnoreCase(dto.getAnswer2())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question3
        iqTest = iqTestRepository.findById(dto.getQuestion3());
        if (iqTest.getAnswer().equalsIgnoreCase(dto.getAnswer3())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question4
        iqTest = iqTestRepository.findById(dto.getQuestion4());
        if (iqTest.getAnswer().equalsIgnoreCase(dto.getAnswer4())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        //question5
        iqTest = iqTestRepository.findById(dto.getQuestion5());
        if (iqTest.getAnswer().equalsIgnoreCase(dto.getAnswer5())) {

            totalMarks += 4;
            correctAnswers += 1;
        }

        else {
            wrongAnswers += 1;
        }

        iqTestScores.setUserName(dto.getUserName());
        iqTestScores.setCorrectAnswers(correctAnswers);
        iqTestScores.setWrongAnswers(wrongAnswers);
        iqTestScores.setTotalMarks(totalMarks);

        iqTestScoresRepository.save(iqTestScores);

        return ResponseEntity.ok(dto);
    }
}
