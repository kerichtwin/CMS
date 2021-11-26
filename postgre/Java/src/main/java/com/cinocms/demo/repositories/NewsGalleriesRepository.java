package com.cinocms.demo.repositories;

import com.cinocms.demo.model.NewsEntity;
import com.cinocms.demo.model.NewsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsGalleriesRepository extends JpaRepository<NewsGalleriesEntity, Integer> {
    List<NewsGalleriesEntity> findByNewsByNewsFk(NewsEntity newsEntity);
}
