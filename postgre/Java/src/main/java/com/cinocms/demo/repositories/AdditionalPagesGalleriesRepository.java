package com.cinocms.demo.repositories;

import com.cinocms.demo.model.AdditionalPagesEntity;
import com.cinocms.demo.model.AdditionalPagesGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalPagesGalleriesRepository extends JpaRepository<AdditionalPagesGalleriesEntity,Integer> {
    List<AdditionalPagesGalleriesEntity> findByAdditionalPagesByAdditionalPageFk(AdditionalPagesEntity additionalPagesEntity);
}
