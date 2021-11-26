package com.cinocms.demo.сontrollers.admin.news.createNews;

import com.cinocms.demo.filesManipulation.FileToDisk;
import com.cinocms.demo.filesManipulation.TypesFile;
import com.cinocms.demo.filesManipulation.TypesGallery;
import com.cinocms.demo.model.NewsEntity;
import com.cinocms.demo.model.NewsGalleriesEntity;
import com.cinocms.demo.services.NewsGalleriesService;
import com.cinocms.demo.services.NewsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class CreateNewsRestController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsGalleriesService newsGalleriesService;

    @PostMapping("/create-news")
    public void createNews(@RequestParam(name = "newsInformation") String newsInformation,
                           @RequestParam(name = "mainImage") MultipartFile mainImage,
                           @RequestParam(name = "newsGallery") List<MultipartFile> newsGallery) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd").create();
        FileToDisk fileToDisk = new FileToDisk();

        NewsEntity newNewsEntity = gson.fromJson(newsInformation, NewsEntity.class);
        newNewsEntity.setCreationDate(new Date(new java.util.Date().getTime()));
        newNewsEntity.setPathToMainImage(fileToDisk.uploadFile(TypesFile.IMAGE, TypesGallery.NEWS, newNewsEntity.getName(),
                "mainImage", mainImage));

        NewsEntity NewsEntityWithId = newsService.save(newNewsEntity);

        for (var image : newsGallery) {
            newsGalleriesService.save(new NewsGalleriesEntity(fileToDisk.uploadFile(TypesFile.IMAGE, TypesGallery.NEWS,
                    newNewsEntity.getName(), UUID.randomUUID().toString(), image), NewsEntityWithId));
        }
    }
}
