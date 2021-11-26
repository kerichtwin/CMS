package com.cinocms.demo.services;

import com.cinocms.demo.model.VipHallsEntity;
import com.cinocms.demo.model.VipHallsGalleriesEntity;
import com.cinocms.demo.repositories.VipHallsGalleriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VipHallsGalleriesService {
    @Autowired
    private VipHallsGalleriesRepository vipHallsGalleriesRepository;

    public List<VipHallsGalleriesEntity> findByVipHallsByVipHallFk(VipHallsEntity vipHallsEntity)
    {
        return vipHallsGalleriesRepository.findByVipHallsByVipHallFk(vipHallsEntity);
    }


    public VipHallsGalleriesEntity save(VipHallsGalleriesEntity vipHallsGalleriesEntity)
    {
        return vipHallsGalleriesRepository.save(vipHallsGalleriesEntity);
    }

    public VipHallsGalleriesEntity findById(int id) {
        Optional<VipHallsGalleriesEntity> vipHallsGalleriesEntity = vipHallsGalleriesRepository.findById(id);
        if (vipHallsGalleriesEntity.isPresent()) {
            return vipHallsGalleriesEntity.get();
        } else {
            return null;
        }
    }

    public void deleteById(int id)
    {
        vipHallsGalleriesRepository.deleteById(id);
    }
}
