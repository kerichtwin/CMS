package com.cinocms.demo.repositories;

import com.cinocms.demo.model.HallsEntity;
import com.cinocms.demo.model.HallsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallsGalleriesRepository extends JpaRepository<HallsGalleriesEntity,Integer> {
    List<HallsGalleriesEntity> getByHallsByHallFk(HallsEntity cinemasEntity);
}
