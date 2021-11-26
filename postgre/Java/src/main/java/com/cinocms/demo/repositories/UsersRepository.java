package com.cinocms.demo.repositories;

import com.cinocms.demo.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
}
