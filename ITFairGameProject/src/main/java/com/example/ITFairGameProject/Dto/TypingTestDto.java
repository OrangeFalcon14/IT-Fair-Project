package com.example.ITFairGameProject.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TypingTestDto {

//    private long id;

    private String userTyped;

    private long userTypedSpeed;
}
