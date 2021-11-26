package com.cinocms.demo.сontrollers.admin.listPages.contacts.createContacts;

import com.cinocms.demo.filesManipulation.FileToDisk;
import com.cinocms.demo.filesManipulation.TypesFile;
import com.cinocms.demo.filesManipulation.TypesGallery;
import com.cinocms.demo.model.ContactsInformationEntity;
import com.cinocms.demo.services.ContactsInformationService;
import com.cinocms.demo.services.ContactsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
public class CreateContactsRestController {
    @Autowired
    private ContactsService contactsService;
    @Autowired
    private ContactsInformationService contactsInformationService;

    @PostMapping("/create-default-entry-Контакты")
    public void createContactsInformation(@RequestParam(name = "contactsInformation") String contactsInformation,
                           @RequestParam(name = "logo") MultipartFile logo) {
        Gson gson = new Gson();
        FileToDisk fileToDisk = new FileToDisk();

        ContactsInformationEntity contactsInformationEntity = gson.fromJson(contactsInformation, ContactsInformationEntity.class);

        contactsInformationEntity.setPathToLogo(fileToDisk.uploadFile(TypesFile.IMAGE, TypesGallery.CONTACTS, contactsInformationEntity.getNameCinema(),
                "mainImage", logo));
        contactsInformationEntity.setContactsByContactFk(contactsService.findAll().get(0));
        contactsInformationService.save(contactsInformationEntity);
    }
}
