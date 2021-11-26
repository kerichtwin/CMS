package com.cinocms.demo.repositories;

import com.cinocms.demo.model.LanguagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesRepository extends JpaRepository<LanguagesEntity,Integer> {
}
