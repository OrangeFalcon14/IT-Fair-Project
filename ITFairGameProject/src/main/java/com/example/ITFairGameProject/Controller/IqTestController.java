package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.IqQuestionAnswersDto;
import com.example.ITFairGameProject.Dto.IqTestDto;
import com.example.ITFairGameProject.Service.IqTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(maxAge = 3600)
@RestController
public class IqTestController {

    @Autowired
    private IqTestService iqTestService;

    @RequestMapping("/api/saveIqQuestion")
    @PostMapping
    public ResponseEntity saveQuestion(@RequestBody IqTestDto dto) {

        return iqTestService.saveQuestion(dto);
    }

    @GetMapping("/api/get2Questions")
    public List<IqTestDto> get5Questions() {
        return iqTestService.get2Questions();
    }

    @RequestMapping("/api/collectIqAnswers")
    @PostMapping
    public ResponseEntity calculateIQMarks(@RequestBody IqQuestionAnswersDto dto) {

        return iqTestService.calculateIQMarks(dto);
    }
}
