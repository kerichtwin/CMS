package com.cinocms.demo.repositories;

import com.cinocms.demo.model.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity,Integer> {
}
