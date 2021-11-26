package com.cinocms.demo.repositories;

import com.cinocms.demo.model.FutureMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutureMoviesRepository extends JpaRepository<FutureMoviesEntity, Integer> {
    void deleteByMoviesByMovieFk(MoviesEntity fk);
}
