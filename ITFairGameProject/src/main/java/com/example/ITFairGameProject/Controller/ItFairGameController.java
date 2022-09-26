package com.example.ITFairGameProject.Controller;

import com.example.ITFairGameProject.Service.ItFairGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItFairGameController {

    @Autowired
    private ItFairGameService itFairGameService;

    public ItFairGameController(ItFairGameService itFairGameService) {
        this.itFairGameService = itFairGameService;
    }
}
