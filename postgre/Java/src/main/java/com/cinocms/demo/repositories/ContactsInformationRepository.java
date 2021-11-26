package com.cinocms.demo.repositories;

import com.cinocms.demo.model.ContactsEntity;
import com.cinocms.demo.model.ContactsInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactsInformationRepository extends JpaRepository<ContactsInformationEntity,Integer> {
    List<ContactsInformationEntity> findByContactsByContactFk(ContactsEntity contactsEntity);
}
