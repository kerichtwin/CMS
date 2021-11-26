package com.cinocms.demo.repositories;

import com.cinocms.demo.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;

public interface MoviesRepository extends JpaRepository<MoviesEntity,Integer> {
    List<MoviesEntity> getByName(String name);
}
