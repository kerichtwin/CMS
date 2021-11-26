package com.cinocms.demo.services;

import com.cinocms.demo.model.FutureMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.repositories.FutureMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FutureMoviesService{
    @Autowired
    private FutureMoviesRepository futureMoviesRepository;

    public List<FutureMoviesEntity> findAll()
    {
        return futureMoviesRepository.findAll();
    }

    public FutureMoviesEntity save(FutureMoviesEntity futureMoviesEntity)
    {
        return futureMoviesRepository.save(futureMoviesEntity);
    }
    @Transactional
    public void deleteByMoviesByMovieFk(MoviesEntity fk){futureMoviesRepository.deleteByMoviesByMovieFk(fk);}
}
