package com.example.manytoone.Controllers;

import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.Team;
import com.example.manytoone.Services.FootballerService;
import com.example.manytoone.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private FootballerService footballerService;
    @GetMapping("/create")
    public void createTeam(@ModelAttribute Team team){
        teamService.createTeam(team);
    }

    @GetMapping("/show")
    public void getTeamById(@RequestParam int ID){
        teamService.getTeamById(ID);
    }

    @GetMapping("/show/all")
    public void getFootballers(@RequestParam int ID){
        teamService.getFootballers(ID);
    }

    @GetMapping("/sorted")
    public void getSorted(@RequestParam String field){
        switch (field){
            case "ID":
                teamService.getSortedById();
                break;
            case "name":
                teamService.getSortedByName();
                break;
            case "creation_date":
                teamService.getSortedByCreationDate();
                break;
        }
    }

}
