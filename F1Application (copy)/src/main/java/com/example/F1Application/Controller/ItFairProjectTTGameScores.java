package com.example.F1Application.Controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "IT_Fair_Project_TT_Game_Scores")
public class ItFairProjectTTGameScores {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "winner")
    private int winner;

        
}
