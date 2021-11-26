package com.cinocms.demo.services;


import com.cinocms.demo.model.CinemasEntity;
import com.cinocms.demo.model.HallsEntity;
import com.cinocms.demo.repositories.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallsService {
    @Autowired
    private HallsRepository hallsRepository;

    public HallsEntity save(HallsEntity hallsEntity) {
        return hallsRepository.save(hallsEntity);
    }

    public HallsEntity findById(int id) {
        Optional<HallsEntity> hallsEntity = hallsRepository.findById(id);
        if (hallsEntity.isPresent()) {
            return hallsEntity.get();
        } else {
            return null;
        }
    }

    public List<HallsEntity> findAll() {
        return hallsRepository.findAll();
    }

    public List<HallsEntity> findByCinemasByCinemaFk(CinemasEntity cinemasEntity) {
        return hallsRepository.findByCinemasByCinemaFk(cinemasEntity);
    }

    public void deleteById(int id) {
        hallsRepository.deleteById(id);
    }

}
