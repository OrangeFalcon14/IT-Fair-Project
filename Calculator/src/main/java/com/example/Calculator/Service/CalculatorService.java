package com.example.Calculator.Service;

import com.example.Calculator.Dto.CalculatorDto;
import com.example.Calculator.Model.Calculator;
import com.example.Calculator.Repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    //add
    public ResponseEntity saveCalculation (CalculatorDto calculatorDto){

        Scanner in = new Scanner(System.in);

        Calculator calculator = new Calculator();

        long number1, number2;
        String operator, operatorD;

        System.out.println("Enter 2 numbers :");
        number1 = in.nextLong();
        number2 = in.nextLong();

        calculator.setNumber1(number1);
        calculator.setNumber2(number2);

        System.out.printf("");
        operatorD = in.nextLine();
        System.out.println("Enter the operator :");
        operator = in.nextLine();

        calculator.setOperator(operator);

        if (operator.equals("+")) {

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setAnswer((calculator.getNumber1()+calculator.getNumber2()));

            calculatorRepository.save(calculator);
        }

        else if (operator.equals("-")) {

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer((calculator.getNumber1()-calculator.getNumber2()));

            calculatorRepository.save(calculator);
        }

        else if (operator.equals("*")) {

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer((calculator.getNumber1()*calculator.getNumber2()));

            calculatorRepository.save(calculator);
        }

        else if (operator.equals("/")) {

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer((calculator.getNumber1()/calculator.getNumber2()));

            calculatorRepository.save(calculator);
        }

        else if (operator.equals("%")) {

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer((calculator.getNumber1()%calculator.getNumber2()));

            calculatorRepository.save(calculator);
        }

        return ResponseEntity.ok(calculatorDto);
    }
}