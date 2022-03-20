package com.example.manytoone.Repos;

import com.example.manytoone.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
    @Override
    Team getById(Integer integer);

    @Override
    <S extends Team> S save(S entity);
}
