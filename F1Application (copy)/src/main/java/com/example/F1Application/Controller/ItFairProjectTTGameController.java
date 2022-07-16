package com.example.F1Application.Controller;

import com.example.F1Application.Service.ItFairProjectTTGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItFairProjectTTGameController {

    @Autowired
    private ItFairProjectTTGameService itFairProjectTTGameService;

    public ItFairProjectTTGameController(ItFairProjectTTGameService itFairProjectTTGameService) {
        this.itFairProjectTTGameService = itFairProjectTTGameService;
    }
}
