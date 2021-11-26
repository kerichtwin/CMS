package com.cinocms.demo.repositories;

import com.cinocms.demo.model.DealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealsRepository extends JpaRepository<DealsEntity,Integer> {
}
