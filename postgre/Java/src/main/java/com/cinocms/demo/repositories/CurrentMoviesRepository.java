package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CurrentMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentMoviesRepository extends JpaRepository<CurrentMoviesEntity, Integer> {
    void deleteByMoviesByMovieFk(MoviesEntity fk);
}
