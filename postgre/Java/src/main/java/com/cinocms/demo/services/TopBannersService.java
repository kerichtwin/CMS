package com.cinocms.demo.services;

import com.cinocms.demo.model.TopBannersEntity;
import com.cinocms.demo.repositories.TopBannersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopBannersService {
    @Autowired
    private TopBannersRepository topBannersRepository;

    public TopBannersEntity save(TopBannersEntity topBannersEntity) {
        return topBannersRepository.save(topBannersEntity);
    }

    public TopBannersEntity findFirst() {
        if (topBannersRepository.findFirst() != null) {
            return topBannersRepository.findFirst();
        } else {
            return new TopBannersEntity();
        }
    }

    public List<TopBannersEntity> findAll() {
        return topBannersRepository.findAll();
    }

    public TopBannersEntity findById(int id) {
        Optional<TopBannersEntity> topBannersEntity = topBannersRepository.findById(id);
        if (topBannersEntity.isPresent()) {
            return topBannersEntity.get();
        } else {
            return null;
        }
    }

}
