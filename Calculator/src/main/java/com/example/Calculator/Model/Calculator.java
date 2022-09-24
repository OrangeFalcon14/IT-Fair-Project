package com.example.Calculator.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "calculator_data")
public class Calculator {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "number_1")
    private long number1;

    @Column(name = "operator")
    private String operator;

    @Column(name = "number_2")
    private long number2;

    @Column(name = "answer")
    private double answer;
}
