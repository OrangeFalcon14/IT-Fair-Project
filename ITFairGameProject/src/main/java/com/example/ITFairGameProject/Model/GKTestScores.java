package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gk_test_scores")
public class GKTestScores {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "correct_answers")
    private long correctAnswers;

    @Column(name = "wrong_answers")
    private long wrongAnswers;

    @Column(name = "total_marks")
    private long totalMarks;
}
