package com.cinocms.demo.repositories;

import com.cinocms.demo.model.DealsEntity;
import com.cinocms.demo.model.DealsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealsGalleryRepository extends JpaRepository<DealsGalleriesEntity,Integer> {
    List<DealsGalleriesEntity> findByDealsByDealFk(DealsEntity dealsEntity);
}
