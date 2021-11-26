package com.cinocms.demo.сontrollers.admin.user.createUser;

import com.cinocms.demo.services.CitiesService;
import com.cinocms.demo.services.GendersService;
import com.cinocms.demo.services.LanguagesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class CreateUserRestController {
    @Autowired
    private LanguagesService languagesService;
    @Autowired
    private GendersService gendersService;
    @Autowired
    private CitiesService citiesService;

    @PostMapping("/user-default-information")
    public Map<String, String> sendDefaultInformation() {
        Gson gson = new Gson();
        Map<String, String> defaultInformations = new HashMap<>();
        defaultInformations.put("usersLanguages", gson.toJson(languagesService.findAll()));
        defaultInformations.put("usersGenders", gson.toJson(gendersService.findAll()));
        defaultInformations.put("usersCities", gson.toJson(citiesService.findAll()));
        return defaultInformations;
    }
}
