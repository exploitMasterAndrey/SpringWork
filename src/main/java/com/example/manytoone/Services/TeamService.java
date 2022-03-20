package com.example.manytoone.Services;

import com.example.manytoone.CustomRepos.CustomTeamRepoImpl;
import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.Team;
import com.example.manytoone.Repos.TeamRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private CustomTeamRepoImpl customTeamRepo;
    @Autowired
    private EmailService emailService;

    @Transactional
    public void createTeam(Team team){
        log.info("Create team named {}", team.getName());
        teamRepo.save(team);
        emailService.sendEmail("andreylobankoff@gmail.com", "Team added", "Work is done!");
        System.out.println("[TEAM CREATED]");
    }

    @Transactional
    public Team getTeamById(int ID){
        log.info("Get team by id = {}", ID);
        Team team = teamRepo.getById(ID);
        System.out.println("["+ team.getName() + " " + team.getCreation_date() + " " + team.getId()+ "]");
        return teamRepo.getById(ID);
    }

    @Transactional
    public List<Footballer> getFootballers(int ID){
        log.info("Get footballers in team with id = {}", ID);
        List<Footballer> list =  teamRepo.getById(ID).getFootballers();
        if (list.size() == 0) System.out.println("[NO PLAYERS IN " + teamRepo.getById(ID).getName() + " TEAM]");
        for(Footballer player : list){
            System.out.println("[" + player.getFirst_name() + " " + player.getLast_name() + "]");
        }
        return list;
    }

    @Transactional
    public void getSortedById(){
        log.info("Get sorted teams by id");
        List<Team> list = customTeamRepo.getSortedById();
        for(Team team : list){
            System.out.println("[" + team.getId() + " " + team.getName() + " " + team.getCreation_date() + "]");}
    }

    @Transactional
    public void getSortedByName(){
        log.info("Get sorted teams by name");
        List<Team> list = customTeamRepo.getSortedByName();
        for(Team team : list){
            System.out.println("[" + team.getId() + " " + team.getName() + " " + team.getCreation_date() + "]");}
    }

    @Transactional
    public void getSortedByCreationDate(){
        log.info("Get sorted teams by creation date");
        List<Team> list = customTeamRepo.getSortedByCreationDate();
        for(Team team : list){
            System.out.println("[" + team.getId() + " " + team.getName() + " " + team.getCreation_date() + "]");}
    }
}
