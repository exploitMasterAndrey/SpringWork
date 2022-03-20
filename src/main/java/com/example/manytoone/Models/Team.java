package com.example.manytoone.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "teams")
@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String creation_date;

    @OneToMany(mappedBy = "team")
    private List<Footballer> footballers;
}
