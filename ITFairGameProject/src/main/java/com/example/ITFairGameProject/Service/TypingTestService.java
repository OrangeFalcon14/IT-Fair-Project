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

        long typingScore = 0;

        if(wpm == 0) {
            typingScore = 0;
        }

        else if (wpm <= 10) {
            typingScore = 1;
        }

        else if (wpm > 10 && wpm <= 20) {
            typingScore = 2; 
        }

        else if (wpm > 20 && wpm <= 35) {
            typingScore = 3;
        }

        else if (wpm > 35 && wpm <= 50) {
            typingScore = 4;
        }

        else if (wpm > 50) {
            typingScore = 5;
        } 

        dto.setUserScore(typingScore);

        typingTest.setUserName(dto.getUserName());
        typingTest.setUserTypedSpeed(dto.getUserTypedSpeed());
        typingTest.setUserScore(dto.getUserScore());

        typingTestRepository.save(typingTest);

        return ResponseEntity.ok(dto);
    }
}
