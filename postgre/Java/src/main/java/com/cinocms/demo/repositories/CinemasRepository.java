package com.cinocms.demo.repositories;

import com.cinocms.demo.model.CinemasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemasRepository extends JpaRepository<CinemasEntity,Integer> {
}
