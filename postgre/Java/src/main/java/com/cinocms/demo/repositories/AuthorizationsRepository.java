package com.cinocms.demo.repositories;

import com.cinocms.demo.model.AuthorizationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationsRepository extends JpaRepository<AuthorizationsEntity,Integer> {
}
