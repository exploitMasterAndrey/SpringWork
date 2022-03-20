package com.example.manytoone.Controllers;

import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.Team;
import com.example.manytoone.Repos.FootballerRepo;
import com.example.manytoone.Repos.TeamRepo;
import com.example.manytoone.Services.FootballerService;
import com.example.manytoone.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class FootballerController {
    @Autowired
    private FootballerService footballerService;
    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/{footballerID}/team")
    public void getPlayerTeam(@PathVariable("footballerID") int footballerID){
        footballerService.getTeamByFootballer(footballerID);
    }

    @GetMapping("/add")
    public void addFootballer(@RequestParam String first_name, @RequestParam String last_name, @RequestParam int team_id){
        Footballer footballer = new Footballer();
        footballer.setFirst_name(first_name);
        footballer.setLast_name(last_name);
        footballer.setTeam(teamService.getTeamById(team_id));

        footballerService.addFootballer(footballer);
    }

    @GetMapping("/show")
    public void getFootballerById(@RequestParam int ID){
        footballerService.getFootballerById(ID);
    }

    @GetMapping("/sorted")
    public void getSorted(@RequestParam String field){
        switch (field){
            case "ID":
                footballerService.getSortedById();
                break;
            case "first_name":
                footballerService.getSortedByFirstName();
                break;
            case "last_name":
                footballerService.getSortedByLastName();
                break;
            case "team_id":
                footballerService.getSortedByTeamId();
                break;
        }
    }
}
