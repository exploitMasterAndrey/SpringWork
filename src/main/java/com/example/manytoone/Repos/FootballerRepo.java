package com.example.manytoone.Repos;

import com.example.manytoone.Models.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballerRepo extends JpaRepository<Footballer, Integer> {
    @Override
    Footballer getById(Integer integer);

    @Override
    <S extends Footballer> S save(S entity);
}
