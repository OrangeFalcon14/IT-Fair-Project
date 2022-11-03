package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.GKTestDto;
import com.example.ITFairGameProject.Dto.QuestionAnswerDto;
import com.example.ITFairGameProject.Service.GKTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GKTestController {

    @Autowired
    private GKTestService gkTestService;

    public GKTestController(GKTestService gkTestService) {
        this.gkTestService = gkTestService;
    }

    //save question info
    @RequestMapping("/api/saveQuestion")
    @PostMapping
    public ResponseEntity saveQuestion(@RequestBody GKTestDto dto) {

        return gkTestService.saveQuestion(dto);
    }

    //get 5 questions
    @GetMapping("/api/get5Questions")
    @ResponseBody
    public List<GKTestDto> get5Questions() {

        return gkTestService.get5Questions();
    }

    //collects answers
    @RequestMapping("/api/collectGKAnswers")
    @PostMapping
    public ResponseEntity calculateGKMarks(@RequestBody QuestionAnswerDto dto) {

        return gkTestService.calculateGKMarks(dto);
    }
}
