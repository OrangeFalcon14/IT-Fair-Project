package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.IqTestDto;
import com.example.ITFairGameProject.Model.IqTest;
import com.example.ITFairGameProject.Repository.IqTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IqTestService {

    @Autowired
    private IqTestRepository iqTestRepository;

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

    public List<IqTestDto> get2Questions() {

        int firstId = 78, lastId = 81;

        List<IqTestDto> toReturn = new ArrayList<>();

//        for (int i = 0; i <= 1; i++) {

            IqTestDto dto = new IqTestDto();

            long randomId = (long) (Math.random()*(lastId-firstId))+firstId;

            IqTest iqTest = iqTestRepository.findById(randomId);

            iqTest.setId(randomId);
            dto.setId(iqTest.getId());
            dto.setQuestion(iqTest.getQuestion());
            dto.setOptionA(iqTest.getOptionA());
            dto.setOptionB(iqTest.getOptionB());
            dto.setOptionC(iqTest.getOptionC());
            dto.setOptionD(iqTest.getOptionD());

            toReturn.add(dto);
//        }

        while(1==1) {

            long randomId2 = (long) (Math.random()*(lastId-firstId))+firstId;
            dto = new IqTestDto();
            iqTest = iqTestRepository.findById(randomId2);

            if (randomId2 == randomId) {
                continue;
            }

            else {

                iqTest.setId(randomId2);
                dto.setId(iqTest.getId());
                dto.setQuestion(iqTest.getQuestion());
                dto.setOptionA(iqTest.getOptionA());
                dto.setOptionB(iqTest.getOptionB());
                dto.setOptionC(iqTest.getOptionC());
                dto.setOptionD(iqTest.getOptionD());

                toReturn.add(dto);

                break;
            }

        }

        return toReturn;
    }
}