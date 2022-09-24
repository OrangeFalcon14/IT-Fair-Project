package com.example.Calculator.Service;

import com.example.Calculator.Dto.CalculatorDto;
import com.example.Calculator.Model.Calculator;
import com.example.Calculator.Repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    //all functions
    public List<CalculatorDto> getAndCalculate (){

        Scanner in = new Scanner(System.in);

        Calculator calculator = new Calculator();

        CalculatorDto calculatorDto = new CalculatorDto();

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

            calculator.setAnswer((number1+number2));

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setAnswer(calculator.getAnswer());

            calculatorRepository.save(calculator);

            System.err.println("The answer is : " + calculator.getAnswer());
        }

        else if (operator.equals("-")) {

            calculator.setAnswer((number1-number2));

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer(calculator.getAnswer());

            calculatorRepository.save(calculator);

            System.err.println("The answer is : " + calculator.getAnswer());
        }

        else if (operator.equals("*")) {

            calculator.setAnswer((number1*number2));

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer(calculator.getAnswer());

            calculatorRepository.save(calculator);

            System.err.println("The answer is : " + calculator.getAnswer());
        }

        else if (operator.equals("/")) {

            calculator.setAnswer((number1/number2));

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer(calculator.getAnswer());

            calculatorRepository.save(calculator);

            System.err.println("The answer is : " + calculator.getAnswer());
        }

        else if (operator.equals("%")) {

            calculator.setAnswer((number1%number2));

            calculatorDto.setNumber1(calculator.getNumber1());
            calculatorDto.setNumber2(calculator.getNumber2());
            calculatorDto.setOperator(calculator.getOperator());
            calculatorDto.setAnswer(calculator.getAnswer());

            calculatorRepository.save(calculator);

            System.err.println("The answer is : " + calculator.getAnswer());
        }

        List<Calculator> calculations = calculatorRepository.findAll();

        List<CalculatorDto> toReturn = new ArrayList<>();

        for (Calculator calculation : calculations) {

            CalculatorDto dto = new CalculatorDto();

            dto.setId(calculation.getId());
            dto.setNumber1(calculation.getNumber1());
            dto.setNumber2(calculator.getNumber2());
            dto.setAnswer(calculator.getAnswer());

            toReturn.add(dto);
        }

        return toReturn;
    }
    public List<CalculatorDto> getAllCalculations() {

        List<Calculator> calculations = calculatorRepository.findAll();

        List<CalculatorDto> toReturn = new ArrayList<>();

        for (Calculator calculator : calculations) {

            CalculatorDto dto = new CalculatorDto();

            dto.setId(calculator.getId());
            dto.setNumber1(calculator.getNumber1());
            dto.setNumber2(calculator.getNumber2());
            dto.setAnswer(calculator.getAnswer());

            toReturn.add(dto);
        }

        return toReturn;
    }
}