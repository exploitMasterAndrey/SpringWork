package com.example.manytoone;

import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.Team;
import com.example.manytoone.Repos.FootballerRepo;
import com.example.manytoone.Repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ManyToOneApplication{

    public static void main(String[] args) {
        SpringApplication.run(ManyToOneApplication.class, args);
    }

//    @Autowired
//    TeamRepo teamRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Footballer footballer = new Footballer();
//        footballer.setFirstName("andrey");
//        footballer.setLastName("lobankov");
//
//        Team team = new Team();
//        team.setName("somename");
//        team.setCreationDate("somedate");
//        team.setFootballers(List.of(footballer));
//
//        teamRepo.save(team);
//    }
}
