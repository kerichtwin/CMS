package com.cinocms.demo.services;

import com.cinocms.demo.model.ContactsEntity;
import com.cinocms.demo.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    public ContactsEntity findFirst()
    {
        return contactsRepository.findFirst();
    }
    public ContactsEntity save(ContactsEntity contactsEntity)
    {
        return contactsRepository.save(contactsEntity);
    }

    public ContactsEntity findById(int id) {
        Optional<ContactsEntity> contactsEntity = contactsRepository.findById(id);
        if (contactsEntity.isPresent()) {
            return contactsEntity.get();
        } else {
            return null;
        }
    }

    public List<ContactsEntity> findAll() {
        return contactsRepository.findAll();
    }
}
