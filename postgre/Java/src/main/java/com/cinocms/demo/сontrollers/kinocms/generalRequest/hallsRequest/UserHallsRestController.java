package com.cinocms.demo.сontrollers.kinocms.generalRequest.hallsRequest;

import com.cinocms.demo.model.HallsEntity;
import com.cinocms.demo.model.HallsGalleriesEntity;
import com.cinocms.demo.services.HallsGalleriesService;
import com.cinocms.demo.services.HallsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserHallsRestController {
    @Autowired
    private HallsService hallsService;
    @Autowired
    private HallsGalleriesService hallsGalleriesService;

    @PostMapping("/send-chosen-hall-information")
    public Map<String, String> sendChosenMovieInformation(@RequestParam("idHall") Integer idHall) {
        Gson gson = new Gson();
        Map<String, String> cinemasInformation = new HashMap<>();

        HallsEntity hallsEntity = hallsService.findById(idHall);
        List<HallsGalleriesEntity> hallsGallery = hallsGalleriesService.getByHallsByHallFk(hallsEntity);

        cinemasInformation.put("hall", gson.toJson(hallsEntity));
        cinemasInformation.put("hallsGallery", gson.toJson(hallsGallery));

        return cinemasInformation;
    }
}
