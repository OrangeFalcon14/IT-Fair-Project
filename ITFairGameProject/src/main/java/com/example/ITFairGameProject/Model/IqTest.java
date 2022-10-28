package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "iq_test")
public class IqTest {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "question")
    private String question;

    @Column(name = "option_a")
    private String optionA;

    @Column(name = "option_b")
    private String optionB;

    @Column(name = "option_c")
    private String optionC;

    @Column(name = "option_d")
    private String optionD;

    @Column(name = "answer")
    private String answer;
}
