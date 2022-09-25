package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "IT_fair_game_project")
public class ItFairGameProject {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "typing_test_scores")
    private long typingTestScores;

    @Column(name = "iq_test_scores")
    private long IQTestScores;

    @Column(name = "gk_test_scores")
    private long GKTestScores;

    @Column(name = "optical_illusion_scores")
    private long opticalIllusionScores;

    @Column(name = "total_points")
    private long totalPoints;

    @Column(name = "user_rank")
    private long userRank;
}
