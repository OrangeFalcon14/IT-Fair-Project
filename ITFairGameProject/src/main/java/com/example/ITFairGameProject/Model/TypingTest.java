package com.example.ITFairGameProject.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "typing_test_info")
public class TypingTest {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_typed")
    private String userTyped;

    @Column(name = "user_typing_speed")
    private long userTypedSpeed;

    @Column(name = "user_score")
    private long userScore;
}
