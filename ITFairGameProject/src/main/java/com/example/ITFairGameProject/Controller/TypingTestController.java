package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.TypingTestDto;
import com.example.ITFairGameProject.Service.TypingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypingTestController {

    @Autowired
    private TypingTestService typingTestService;

    public TypingTestController(TypingTestService typingTestService) {
        this.typingTestService = typingTestService;
    }

    @RequestMapping("/api/wpm")
    @PostMapping
    public ResponseEntity typedWpm(@RequestBody TypingTestDto dto) {

        return typingTestService.typedWPM(dto);
    }
}
