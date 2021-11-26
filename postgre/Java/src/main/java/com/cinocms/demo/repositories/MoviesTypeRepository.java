package com.cinocms.demo.repositories;

import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.model.MoviesTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;

public interface MoviesTypeRepository extends JpaRepository<MoviesTypesEntity,Integer> {
    LinkedList<MoviesTypesEntity> findByMoviesByMovieFk(MoviesEntity movieFk);
    LinkedList<MoviesTypesEntity> getByType(String name);

    void deleteByMoviesByMovieFk(MoviesEntity movieFk);
}
