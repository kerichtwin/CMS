package com.cinocms.demo.services;


import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.model.MoviesGalleriesEntity;
import com.cinocms.demo.repositories.MoviesGalleriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

@Service
public class MoviesGalleriesService {

    @Autowired
    private MoviesGalleriesRepository moviesGalleriesRepository;

    public void save(MoviesGalleriesEntity moviesEntity) {
        moviesGalleriesRepository.save(moviesEntity);
    }

    public LinkedList<MoviesGalleriesEntity>findByMoviesByMovieFk(MoviesEntity movieFk) {
        return moviesGalleriesRepository.findByMoviesByMovieFk(movieFk);
    }

    @Transactional
    public void deleteByPath(String path)
    {
        moviesGalleriesRepository.deleteByPathToImage(path);
    }

}
