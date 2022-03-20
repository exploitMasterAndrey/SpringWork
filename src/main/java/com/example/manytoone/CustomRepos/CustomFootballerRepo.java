package com.example.manytoone.CustomRepos;

import com.example.manytoone.Models.Footballer;

import javax.management.Query;
import java.util.List;

public interface CustomFootballerRepo {
    List<Footballer> getSortedById();
    List<Footballer> getSortedByFirstName();
    List<Footballer> getSortedByLastName();
    List<Footballer> getSortedByTeamId();
}
