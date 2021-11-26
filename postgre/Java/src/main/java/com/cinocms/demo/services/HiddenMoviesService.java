package com.cinocms.demo.services;

import com.cinocms.demo.model.HiddenMoviesEntity;
import com.cinocms.demo.model.MoviesEntity;
import com.cinocms.demo.repositories.HiddenMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HiddenMoviesService {
    @Autowired
    private HiddenMoviesRepository hiddenMoviesRepository;

    public HiddenMoviesEntity save(HiddenMoviesEntity hiddenMoviesEntity) {
        return hiddenMoviesRepository.save(hiddenMoviesEntity);
    }
    public List<HiddenMoviesEntity> findAll()
    {
        return hiddenMoviesRepository.findAll();
    }

    @Transactional
    public void deleteByMoviesByMovieFk(MoviesEntity fk){hiddenMoviesRepository.deleteByMoviesByMovieFk(fk);}
}
