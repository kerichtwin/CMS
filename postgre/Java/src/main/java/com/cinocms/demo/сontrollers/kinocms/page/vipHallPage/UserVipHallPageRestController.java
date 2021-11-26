package com.cinocms.demo.сontrollers.kinocms.page.vipHallPage;

import com.cinocms.demo.model.VipHallsEntity;
import com.cinocms.demo.model.VipHallsGalleriesEntity;
import com.cinocms.demo.services.VipHallsGalleriesService;
import com.cinocms.demo.services.VipHallsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserVipHallPageRestController {
    @Autowired
    private VipHallsService vipHallsService;
    @Autowired
    private VipHallsGalleriesService vipHallsGalleriesService;

    @PostMapping("/send-vip-hall-information")
    public Map<String, String> sendVipHallInformation() {
        Gson gson = new Gson();
        Map<String, String> vipHallInformation = new HashMap<>();

        VipHallsEntity vipHallsEntity = vipHallsService.findFirst();
        vipHallInformation.put("vipHall", gson.toJson(vipHallsEntity));

        List<VipHallsGalleriesEntity> vipHallsGallery = vipHallsGalleriesService.findByVipHallsByVipHallFk(vipHallsEntity);
        vipHallInformation.put("vipHallsGallery", gson.toJson(vipHallsGallery));

        return vipHallInformation;
    }
}
