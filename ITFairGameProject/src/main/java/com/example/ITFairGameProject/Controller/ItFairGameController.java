package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.ItFairGameProjectDto;
import com.example.ITFairGameProject.Dto.UserNameDto;
import com.example.ITFairGameProject.Service.ItFairGameProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class ItFairGameController {

    @Autowired
    private ItFairGameProjectService itFairGameService;

    //createUser
    @RequestMapping("/api/userName")
    @PostMapping
    public ResponseEntity userName(@RequestBody UserNameDto dto) {

        return itFairGameService.userName(dto);
    }

    //saveScores
    @RequestMapping("/api/calculateScores")
    @PostMapping
    public ResponseEntity calculateScores(@RequestBody ItFairGameProjectDto dto) {

        return itFairGameService.calculateScores(dto);
    }

    //getScoredByDescOrder
    @GetMapping("/api/getInDesc")
    public List<ItFairGameProjectDto> getScoresInDesc() {
        return itFairGameService.getScoresInDesc();
    }
}
