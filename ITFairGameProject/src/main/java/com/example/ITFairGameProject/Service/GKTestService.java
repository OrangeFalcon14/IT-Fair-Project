package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.GKTestDto;
import com.example.ITFairGameProject.Model.GKTest;
import com.example.ITFairGameProject.Repository.GKTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GKTestService {

    @Autowired
    private GKTestRepository gkTestRepository;

    public GKTestService(GKTestRepository gkTestRepository) {
        this.gkTestRepository = gkTestRepository;
    }

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

        System.err.println("\n" + toReturn);

        return toReturn;
    }
}
