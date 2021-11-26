package com.cinocms.demo.сontrollers.admin.news.editNews;

import com.cinocms.demo.model.NewsEntity;
import com.cinocms.demo.services.NewsGalleriesService;
import com.cinocms.demo.services.NewsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class EditNewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsGalleriesService newsGalleriesService;

    @GetMapping("/edit-news")
    public String news(@RequestParam("idNews") Integer idNews, Model model)
    {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        NewsEntity newsEntity = newsService.findById(idNews);

        model.addAttribute("oldNews", gson.toJson(newsEntity));
        model.addAttribute("oldImagesFromGallery", gson.toJson(newsGalleriesService.findByNewsByNewsFk(newsEntity)));
        return "admin/news/EditNews";
    }
}
