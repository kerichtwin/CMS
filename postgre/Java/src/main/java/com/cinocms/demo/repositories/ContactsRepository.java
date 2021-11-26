package com.cinocms.demo.repositories;

import com.cinocms.demo.model.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactsRepository extends JpaRepository<ContactsEntity, Integer> {
    @Query(value = "SELECT * FROM contacts ORDER BY id_contact LIMIT 1",nativeQuery = true)
    ContactsEntity findFirst();
}
