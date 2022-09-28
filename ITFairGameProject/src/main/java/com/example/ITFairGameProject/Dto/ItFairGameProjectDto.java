package com.example.ITFairGameProject.Dto;

import lombok.Data;

@Data
public class ItFairGameProjectDto {

    private long id;

    private String userName;

    private long typingTestScores;

    private long IQTestScores;

    private long GKTestScores;

    private long opticalIllusionScores;

    private long totalPoints;

    private long userRank;

    private String userTyped;

    private long userTypedSpeed;
}
