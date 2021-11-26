package com.cinocms.demo.repositories;

import com.cinocms.demo.model.GendersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GendersRepository extends JpaRepository<GendersEntity,Integer> {
}
