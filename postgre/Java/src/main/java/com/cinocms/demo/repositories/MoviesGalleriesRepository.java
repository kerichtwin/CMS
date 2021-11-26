package com.cinocms.demo.repositories;

import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.model.MoviesGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;

public interface MoviesGalleriesRepository extends JpaRepository<MoviesGalleriesEntity, Integer> {
    LinkedList<MoviesGalleriesEntity> findByMoviesByMovieFk(MoviesEntity movieFk);

    void deleteByPathToImage(String path);

}
