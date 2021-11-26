package com.cinocms.demo.repositories;

import com.cinocms.demo.model.HiddenMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiddenMoviesRepository extends JpaRepository<HiddenMoviesEntity, Integer> {
    void deleteByMoviesByMovieFk(MoviesEntity fk);
}
