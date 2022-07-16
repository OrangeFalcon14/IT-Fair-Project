package com.example.F1Application.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "IT_Fair_Project_TT_Game_Data")
@Entity
public class ItFairProjectTTGameScores {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "winner")
    private String winner;

    @Column(name = "number_of_rallies")
    private long numberOfRallies;

    @Column(name = "time_taken")
    private long timeTaken;
}
