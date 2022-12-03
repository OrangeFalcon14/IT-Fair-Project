package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.IllusionQuestionAnswerDto;
import com.example.ITFairGameProject.Dto.OpticalIllusionTestDto;
import com.example.ITFairGameProject.Service.OpticalIllusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@Controller
public class OpticalIllusionController {

    @Autowired
    private OpticalIllusionService opticalIllusionService;

    @RequestMapping("/api/saveOpticalIllusionQuestion")
    @PostMapping
    public ResponseEntity saveQuestion(@RequestBody OpticalIllusionTestDto dto) {

        return opticalIllusionService.saveQuestion(dto);
    }

    @GetMapping("/api/get5IllusionQuestions")
    @ResponseBody
    public List<OpticalIllusionTestDto> get5Questions() {

        return opticalIllusionService.get5IllusionQuestions();
    }

    @RequestMapping("/api/calculateOpticalIllusionMarks")
    @PostMapping
    public ResponseEntity calculateMarks(@RequestBody IllusionQuestionAnswerDto dto) {

        return opticalIllusionService.calculateOpticalIllusionMarks(dto);
    }
}
