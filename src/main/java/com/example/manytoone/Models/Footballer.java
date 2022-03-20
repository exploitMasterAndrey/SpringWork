package com.example.manytoone.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "footballers")
@Entity
@Getter
@Setter
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;

    @ManyToOne
    private Team team;
}
