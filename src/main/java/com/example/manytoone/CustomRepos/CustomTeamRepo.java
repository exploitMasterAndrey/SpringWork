package com.example.manytoone.CustomRepos;

import com.example.manytoone.Models.Team;

import java.util.List;

public interface CustomTeamRepo {
    List<Team> getSortedById();
    List<Team> getSortedByName();
    List<Team> getSortedByCreationDate();
}
