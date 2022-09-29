package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.GKTestDto;
import com.example.ITFairGameProject.Service.GKTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
