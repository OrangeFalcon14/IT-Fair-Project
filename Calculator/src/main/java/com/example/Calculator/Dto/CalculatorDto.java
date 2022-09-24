package com.example.Calculator.Dto;

import lombok.Data;

@Data
public class CalculatorDto {

    private long id;

    private long number1;

    private String operator;

    private long number2;

    private double answer;
}
