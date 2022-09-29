package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.GKTestDto;
import com.example.ITFairGameProject.Model.GKTest;
import com.example.ITFairGameProject.Repository.GKTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
