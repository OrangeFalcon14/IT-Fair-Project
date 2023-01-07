package com.example.ITFairGameProject.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_names")
public class UserNames {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name")
    private String userName;
}
