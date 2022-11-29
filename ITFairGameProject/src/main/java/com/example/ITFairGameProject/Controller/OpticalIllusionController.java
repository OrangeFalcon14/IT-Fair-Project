package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.OpticalIllusionTestDto;
import com.example.ITFairGameProject.Service.OpticalIllusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpticalIllusionController {

    @Autowired
    private OpticalIllusionService opticalIllusionService;

    @RequestMapping("/api/saveOpticalIllusionQuestion")
    @PostMapping
    public ResponseEntity saveQuestion(@RequestBody OpticalIllusionTestDto dto) {

        return opticalIllusionService.saveQuestion(dto);
    }


}
