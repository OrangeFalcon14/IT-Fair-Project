package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "optical_illusion_test")
public class OpticalIllusionTest {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "question")
    private String question;

    @Column(name = "optionA")
    private String optionA;

    @Column(name = "optionB")
    private String optionB;

    @Column(name = "optionC")
    private String optionC;

    @Column(name = "optionD")
    private String optionD;

    @Column(name = "answer")
    private String answer;
}
