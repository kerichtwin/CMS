package com.cinocms.demo.repositories;

import com.cinocms.demo.model.VipHallsEntity;
import com.cinocms.demo.model.VipHallsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VipHallsGalleriesRepository extends JpaRepository<VipHallsGalleriesEntity,Integer> {
    List<VipHallsGalleriesEntity> findByVipHallsByVipHallFk(VipHallsEntity vipHallsEntity);
}
