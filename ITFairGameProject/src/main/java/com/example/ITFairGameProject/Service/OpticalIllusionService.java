package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Dto.OpticalIllusionTestDto;
import com.example.ITFairGameProject.Model.OpticalIllusionTest;
import com.example.ITFairGameProject.Repository.OpticalIllusionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OpticalIllusionService {

    @Autowired
    private OpticalIllusionRepository opticalIllusionRepository;

    //save question
    public ResponseEntity saveQuestion(OpticalIllusionTestDto dto) {

        OpticalIllusionTest opticalIllusionTest = new OpticalIllusionTest();

        opticalIllusionTest.setImgUrl(dto.getImgUrl());
        opticalIllusionTest.setQuestion(dto.getQuestion());
        opticalIllusionTest.setOptionA(dto.getOptionA());
        opticalIllusionTest.setOptionB(dto.getOptionB());
        opticalIllusionTest.setAnswer(dto.getAnswer());

        opticalIllusionRepository.save(opticalIllusionTest);

        return ResponseEntity.ok(dto);
    }
}
