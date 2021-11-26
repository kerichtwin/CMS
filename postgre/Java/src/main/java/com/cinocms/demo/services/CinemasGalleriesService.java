package com.cinocms.demo.services;

import com.cinocms.demo.model.CinemasEntity;
import com.cinocms.demo.model.CinemasGalleriesEntity;
import com.cinocms.demo.model.HallsEntity;
import com.cinocms.demo.model.HallsGalleriesEntity;
import com.cinocms.demo.repositories.CinemasGalleriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemasGalleriesService {
    @Autowired
    private CinemasGalleriesRepository cinemasGalleriesRepository;

    public CinemasGalleriesEntity findById(int id) {
        Optional<CinemasGalleriesEntity> cinemasGalleriesEntity = cinemasGalleriesRepository.findById(id);
        if (cinemasGalleriesEntity.isPresent()) {
            return cinemasGalleriesEntity.get();
        } else {
            return null;
        }
    }

    public List<CinemasGalleriesEntity> getByCinemasByCinemaFk(CinemasEntity cinemasEntity)
    {
        return cinemasGalleriesRepository.getByCinemasByCinemaFk(cinemasEntity);
    }

    public CinemasGalleriesEntity save(CinemasGalleriesEntity cinemasGalleriesEntity) {
        return cinemasGalleriesRepository.save(cinemasGalleriesEntity);
    }

    public void deleteById(int id)
    {
        cinemasGalleriesRepository.deleteById(id);
    }

}
