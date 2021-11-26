package com.cinocms.demo.repositories;

import com.cinocms.demo.model.DescriptionCurrentCinemasEntity;
import com.cinocms.demo.model.DescriptionCurrentCinemasGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DescriptionCurrentCinemasGalleriesRepository extends JpaRepository<DescriptionCurrentCinemasGalleriesEntity,Integer> {
    List<DescriptionCurrentCinemasGalleriesEntity> findByDescriptionCurrentCinemasByDescriptionCurrentCinemaFk(DescriptionCurrentCinemasEntity descriptionCurrentCinemasEntity);
}
