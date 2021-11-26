package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CinemasEntity;
import com.cinocms.demo.model.CinemasGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemasGalleriesRepository extends JpaRepository<CinemasGalleriesEntity,Integer> {
    List<CinemasGalleriesEntity> getByCinemasByCinemaFk(CinemasEntity cinemasEntity);
}
