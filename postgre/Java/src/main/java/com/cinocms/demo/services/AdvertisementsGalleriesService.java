package com.cinocms.demo.services;

import com.cinocms.demo.model.AdvertisementsEntity;
import com.cinocms.demo.model.AdvertisementsGalleriesEntity;
import com.cinocms.demo.repositories.AdvertisementsGalleriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementsGalleriesService {
    @Autowired
    private AdvertisementsGalleriesRepository advertisementsGalleriesRepository;

    public List<AdvertisementsGalleriesEntity> findByAdvertisementsByAdvertisementFk(AdvertisementsEntity advertisementsEntity)
    {
        return advertisementsGalleriesRepository.findByAdvertisementsByAdvertisementFk(advertisementsEntity);
    }


    public AdvertisementsGalleriesEntity save(AdvertisementsGalleriesEntity advertisementsGalleriesEntity)
    {
        return advertisementsGalleriesRepository.save(advertisementsGalleriesEntity);
    }

    public AdvertisementsGalleriesEntity findById(int id) {
        Optional<AdvertisementsGalleriesEntity> advertisementsGalleriesEntity = advertisementsGalleriesRepository.findById(id);
        if (advertisementsGalleriesEntity.isPresent()) {
            return advertisementsGalleriesEntity.get();
        } else {
            return null;
        }
    }

    public void deleteById(int id)
    {
        advertisementsGalleriesRepository.deleteById(id);
    }

}
