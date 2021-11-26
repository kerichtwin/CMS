package com.cinocms.demo.сontrollers.admin.mailing;

import com.cinocms.demo.filesManipulation.DeleteFile;
import com.cinocms.demo.filesManipulation.FileToDisk;
import com.cinocms.demo.filesManipulation.TypesFile;
import com.cinocms.demo.filesManipulation.TypesGallery;
import com.cinocms.demo.model.MailingsEntity;
import com.cinocms.demo.services.MailingsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class MailingRestController {
    @Autowired
    private MailingsService mailingsService;

    @PostMapping("/show-loaded-files")
    public String showLoadedFiles() {
        Gson gson = new Gson();

        return gson.toJson(mailingsService.findAll());
    }

    @PostMapping("/mailing-save-file")
    public void saveFile(@RequestParam("fileForMailing") MultipartFile fileForMailing) {
        FileToDisk fileToDisk = new FileToDisk();
        mailingsService.save(new MailingsEntity(fileToDisk.uploadFile(TypesFile.FILE, TypesGallery.MAILING,
                TypesGallery.MAILING.name(), UUID.randomUUID().toString(), fileForMailing), fileForMailing.getOriginalFilename()));
        if (mailingsService.getCountMailings() > 5) {
            DeleteFile.delete(mailingsService.findById(mailingsService.getMinId()).getPathToFile());
            mailingsService.deleteById(mailingsService.getMinId());
        }
    }

    @DeleteMapping("/delete-mailing-file")
    public void deleteMailingFile(@RequestParam("idMailing") Integer idMailing) {
        DeleteFile.delete(mailingsService.findById(idMailing).getPathToFile());
        mailingsService.deleteById(idMailing);
    }
}
