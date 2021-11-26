package com.cinocms.demo.сontrollers.admin.statistic;

import com.cinocms.demo.model.CurrentMoviesEntity;
import com.cinocms.demo.model.FutureMoviesEntity;
import com.cinocms.demo.services.CurrentMoviesService;
import com.cinocms.demo.services.FutureMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class StatisticController {
    public static final String LINK = "/statistics";
    @Autowired
    private CurrentMoviesService currentMoviesService;
    @Autowired
    private FutureMoviesService futureMoviesService;

    @GetMapping(LINK)
    public String statistics(Model model)
    {
       List<CurrentMoviesEntity> currentMoviesEntities = currentMoviesService.findAll();
        model.addAttribute("countCurrentMovies",currentMoviesEntities.size());
        List<FutureMoviesEntity> futureMoviesEntities = futureMoviesService.findAll();
        model.addAttribute("countFutureMovies",futureMoviesEntities.size());
        return "admin/StatisticsPage";
    }
}
