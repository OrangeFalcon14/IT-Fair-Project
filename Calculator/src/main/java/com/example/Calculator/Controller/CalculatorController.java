package com.example.Calculator.Controller;

import com.example.Calculator.Dto.CalculatorDto;
import com.example.Calculator.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/api/calculate")
    public List<CalculatorDto> saveCalculation() {

        return calculatorService.getAndCalculate();
    }

    @GetMapping("/api/allCalculations")
    public List<CalculatorDto> getAllCalculations() {

        return calculatorService.getAllCalculations();
    }
}
