package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Dto.ItFairGameProjectDto;
import com.example.ITFairGameProject.Service.ItFairGameProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItFairGameController {

    @Autowired
    private ItFairGameProjectService itFairGameService;

    public ItFairGameController(ItFairGameProjectService itFairGameService) {
        this.itFairGameService = itFairGameService;
    }

    //Calculating the wpm

}
