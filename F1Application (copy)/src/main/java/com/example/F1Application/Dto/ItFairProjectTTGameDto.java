package com.example.F1Application.Dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ItFairProjectTTGameDto {

    private long id;

    private String winner;

    private long numberOfRallies;

    private long timeTaken;
}
