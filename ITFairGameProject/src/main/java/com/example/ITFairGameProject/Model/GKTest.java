package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GK_test_info")
public class GKTest {

    //All questions will be mcq's only

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
