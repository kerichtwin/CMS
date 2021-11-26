package com.cinocms.demo.сontrollers.admin.user.usersList;

import com.cinocms.demo.services.AuthorizationsService;
import com.cinocms.demo.services.UsersService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UsersListRestController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthorizationsService authorizationsService;

    @PostMapping("/list-users")
    public String sendAllUsers() {
        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();

        String listUsers = (gson.toJson(usersService.findAll()));

        return listUsers;
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestParam("idUserDelete") Integer idUserDelete) {
        authorizationsService.deleteById((usersService.findById(idUserDelete).getAuthorizationsByAuthorizationFk().getIdAuthorization()));
    }
}
