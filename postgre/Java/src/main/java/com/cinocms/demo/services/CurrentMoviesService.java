package com.cinocms.demo.services;

import com.cinocms.demo.model.CurrentMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.repositories.CurrentMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CurrentMoviesService {
    @Autowired
    private CurrentMoviesRepository moviesRepository;

    public List<CurrentMoviesEntity> findAll()
    {
        return moviesRepository.findAll();
    }
    public CurrentMoviesEntity save(CurrentMoviesEntity currentMoviesEntity)
    {
        return moviesRepository.save(currentMoviesEntity);
    }
    @Transactional
    public void deleteByMoviesByMovieFk(MoviesEntity fk){moviesRepository.deleteByMoviesByMovieFk(fk);}
}
