package com.cinocms.demo.сontrollers.admin.news.deleteNews;

import com.cinocms.demo.filesManipulation.DeleteFile;
import com.cinocms.demo.filesManipulation.FileToDisk;
import com.cinocms.demo.filesManipulation.TypesFile;
import com.cinocms.demo.filesManipulation.TypesGallery;
import com.cinocms.demo.model.NewsEntity;
import com.cinocms.demo.model.NewsGalleriesEntity;
import com.cinocms.demo.services.NewsGalleriesService;
import com.cinocms.demo.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class DeleteNewsRestController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsGalleriesService newsGalleriesService;

    @DeleteMapping("/delete-news")
    public void deleteNews(@RequestParam("idNews") Integer idNews) {

        NewsEntity newsEntity = newsService.findById(idNews);
        List<NewsGalleriesEntity> newsGalleriesEntities =  newsGalleriesService.findByNewsByNewsFk(newsEntity);
        for (var picture : newsGalleriesEntities) {
            DeleteFile.delete(picture.getPathToImage());
        }

        DeleteFile.delete(newsEntity.getPathToMainImage());

        DeleteFile.delete(FileToDisk.NAME_ROOT_FOLDER + "/" +TypesFile.IMAGE.getNameFolder() + "/"
                + TypesGallery.NEWS + "/" + newsEntity.getName());

        newsService.deleteById(idNews);
    }
}
