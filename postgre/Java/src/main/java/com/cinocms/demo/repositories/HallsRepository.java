package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CinemasEntity;
import com.cinocms.demo.model.HallsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallsRepository extends JpaRepository<HallsEntity, Integer> {
    List<HallsEntity> findByCinemasByCinemaFk(CinemasEntity cinemasEntity);
}
