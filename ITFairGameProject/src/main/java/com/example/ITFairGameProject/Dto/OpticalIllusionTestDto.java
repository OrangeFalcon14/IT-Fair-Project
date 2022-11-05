package com.example.ITFairGameProject.Dto;

import lombok.Data;

@Data
public class OpticalIllusionTestDto {

    private long id;
    private String imgUrl;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
}
