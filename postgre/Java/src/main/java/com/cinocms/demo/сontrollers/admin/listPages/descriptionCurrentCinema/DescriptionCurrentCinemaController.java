package com.cinocms.demo.сontrollers.admin.listPages.descriptionCurrentCinema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DescriptionCurrentCinemaController {
    @GetMapping("/edit-default-entry-О кинотеатре")
    public String showMainPage() {
        return "admin/pages/DescriptionCurrentCinema";
    }
}
