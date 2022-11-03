package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "iq_test_score")
public class IqTestScores {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "total_marks")
    private long totalMarks;

    @Column(name = "correct_answers")
    private long correctAnswers;

    @Column(name = "wrong_answers")
    private long wrongAnswers;
}
