package com.example.manytoone;

import com.example.manytoone.CustomRepos.CustomFootballerRepo;
import com.example.manytoone.CustomRepos.CustomTeamRepo;
import com.example.manytoone.Models.Footballer;
import com.example.manytoone.Models.User;
import com.example.manytoone.Repos.FootballerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestFootbal {
    @Mock
    private FootballerRepo FootballerRepo;

    @Captor
    ArgumentCaptor<Footballer> captor;

    @org.junit.jupiter.api.Test
    void getFootballers(){
        Footballer footballer = new Footballer();
        footballer.setFirst_name("Andrey");
        Footballer footballer1 = new Footballer();
        footballer1.setFirst_name("Pavel");

        Mockito.when(FootballerRepo.findAll()).thenReturn(List.of(footballer, footballer1));
        Assertions.assertEquals(2, FootballerRepo.findAll().size());
    }

    @Test
    void saveOrUpdate(){
        Footballer footballer = new Footballer();
        footballer.setFirst_name("Vitya");

        FootballerRepo.save(footballer);
        Mockito.verify(FootballerRepo).save(captor.capture());
        Footballer captured = captor.getValue();
        Assertions.assertEquals("Vitya", captured.getFirst_name());
    }


}
