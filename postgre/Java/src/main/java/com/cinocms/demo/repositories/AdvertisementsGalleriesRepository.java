package com.cinocms.demo.repositories;

import com.cinocms.demo.model.AdvertisementsEntity;
import com.cinocms.demo.model.AdvertisementsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementsGalleriesRepository extends JpaRepository<AdvertisementsGalleriesEntity,Integer> {
    List<AdvertisementsGalleriesEntity> findByAdvertisementsByAdvertisementFk(AdvertisementsEntity advertisementsEntity);
}
