package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CafesEntity;
import com.cinocms.demo.model.CafesGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafesGalleriesRepository extends JpaRepository<CafesGalleriesEntity,Integer> {
    List<CafesGalleriesEntity> findByCafesByCafeFk(CafesEntity cafesEntity);
}
