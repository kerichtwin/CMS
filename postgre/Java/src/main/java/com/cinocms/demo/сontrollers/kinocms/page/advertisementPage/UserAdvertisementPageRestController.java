package com.cinocms.demo.сontrollers.kinocms.page.advertisementPage;

import com.cinocms.demo.model.AdvertisementsEntity;
import com.cinocms.demo.model.AdvertisementsGalleriesEntity;
import com.cinocms.demo.services.AdvertisementsGalleriesService;
import com.cinocms.demo.services.AdvertisementsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserAdvertisementPageRestController {
    @Autowired
    private AdvertisementsService advertisementsService;
    @Autowired
    private AdvertisementsGalleriesService advertisementsGalleriesService;

    @PostMapping("/send-advertisement-information")
    public Map<String, String> sendCafeInformation() {
        Gson gson = new Gson();
        Map<String, String> advertisementInformation = new HashMap<>();

        AdvertisementsEntity advertisementsEntity = advertisementsService.findFirst();
        advertisementInformation.put("advertisement", gson.toJson(advertisementsEntity));

        List<AdvertisementsGalleriesEntity> advertisementsGallery = advertisementsGalleriesService.findByAdvertisementsByAdvertisementFk(advertisementsEntity);
        advertisementInformation.put("advertisementsGallery", gson.toJson(advertisementsGallery));

        return advertisementInformation;
    }
}
