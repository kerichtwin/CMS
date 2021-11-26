package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<CitiesEntity,Integer> {
}
