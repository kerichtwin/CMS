package com.cinocms.demo.services;

import com.cinocms.demo.model.NewsEntity;
import com.cinocms.demo.model.NewsGalleriesEntity;
import com.cinocms.demo.repositories.NewsGalleriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsGalleriesService {
    @Autowired
    private NewsGalleriesRepository newsGalleriesRepository;

    public NewsGalleriesEntity save(NewsGalleriesEntity newsGalleriesEntity)
    {
        return newsGalleriesRepository.save(newsGalleriesEntity);
    }

    public List<NewsGalleriesEntity> findByNewsByNewsFk(NewsEntity id)
    {
        return newsGalleriesRepository.findByNewsByNewsFk(id);
    }

    public NewsGalleriesEntity findById(int id) {
        Optional<NewsGalleriesEntity> newsGalleriesEntity = newsGalleriesRepository.findById(id);
        if (newsGalleriesEntity.isPresent()) {
            return newsGalleriesEntity.get();
        } else {
            return null;
        }
    }

    public void deleteById(int id)
    {
        newsGalleriesRepository.deleteById(id);
    }
}
