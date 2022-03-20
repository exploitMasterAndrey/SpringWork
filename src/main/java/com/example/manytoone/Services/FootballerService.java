package com.example.manytoone.Services;

import com.example.manytoone.CustomRepos.CustomFootballerRepo;
import com.example.manytoone.CustomRepos.CustomFootballerRepoImpl;
import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Repos.FootballerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class FootballerService {
    @Autowired
    private FootballerRepo footballerRepo;
    @Autowired
    private CustomFootballerRepo customFootballerRepo;
    @Autowired
    private EmailService emailService;

    @Transactional
    public void getTeamByFootballer(int footballerID){
        log.info("Get team by footballer ID = {}", footballerID);
        System.out.println(footballerRepo.getById(footballerID).getTeam().getName());
    }

    @Transactional
    public void addFootballer(Footballer footballer){
        log.info("Add footballer {}", footballer.getFirst_name());
        footballerRepo.save(footballer);
        emailService.sendEmail("andreylobankoff@gmail.com", "Footballer added", "Work is done!");
    }

    @Transactional
    public void getFootballerById(int ID){
        log.info("Get footballer by ID = {}", ID);
        Footballer footballer =  footballerRepo.getById(ID);
        System.out.println("[" + footballer.getFirst_name() + " " + footballer.getLast_name() + " " + footballer.getTeam().getName() + "]");
    }

    @Transactional
    public void getSortedById(){
        log.info("Get sorted footballers by id");
        List<Footballer> list = customFootballerRepo.getSortedById();
        for(Footballer footballer : list){
            System.out.println("[" + footballer.getId() + " " + footballer.getFirst_name() + " " + footballer.getLast_name() + " " + footballer.getTeam().getName() + "]");}
    }

    @Transactional
    public void getSortedByFirstName(){
        log.info("Get sorted footballers by first name");
        List<Footballer> list = customFootballerRepo.getSortedByFirstName();
        for(Footballer footballer : list){
            System.out.println("[" + footballer.getId() + " " + footballer.getFirst_name() + " " + footballer.getLast_name() + " " + footballer.getTeam().getName() + "]");}
    }

    @Transactional
    public void getSortedByLastName(){
        log.info("Get sorted footballers by last name");
        List<Footballer> list = customFootballerRepo.getSortedByLastName();
        for(Footballer footballer : list){
            System.out.println("[" + footballer.getId() + " " + footballer.getFirst_name() + " " + footballer.getLast_name() + " " + footballer.getTeam().getName() + "]");}
    }

    @Transactional
    public void getSortedByTeamId(){
        log.info("Get sorted footballers by team id");
        List<Footballer> list = customFootballerRepo.getSortedByTeamId();
        for(Footballer footballer : list){
            System.out.println("[" + footballer.getId() + " " + footballer.getFirst_name() + " " + footballer.getLast_name() + " " + footballer.getTeam().getId() + "]");}
    }

}
