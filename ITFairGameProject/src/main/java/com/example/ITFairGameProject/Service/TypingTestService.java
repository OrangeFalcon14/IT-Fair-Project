package com.example.ITFairGameProject.Service;

import com.example.ITFairGameProject.Model.TypingTest;
import com.example.ITFairGameProject.Repository.TypingTestRepository;
import com.example.ITFairGameProject.Dto.TypingTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TypingTestService {

    @Autowired
    private TypingTestRepository typingTestRepository;

    public TypingTestService(TypingTestRepository typingTestRepository) {
        this.typingTestRepository = typingTestRepository;
    }

    //calculating the wpm raw api
    public ResponseEntity typedWPM(TypingTestDto dto) {

        TypingTest typingTest = new TypingTest();

        typingTest.setUserTyped(dto.getUserTyped());

        int noOfCharactersInMin = (typingTest.getUserTyped().length() - 1)*3;

        int wpm = (int) (Math.round(noOfCharactersInMin/5));

        dto.setUserTypedSpeed(wpm);

        typingTest.setUserTypedSpeed(dto.getUserTypedSpeed());

        typingTestRepository.save(typingTest);

        return ResponseEntity.ok(dto);
    }
}
