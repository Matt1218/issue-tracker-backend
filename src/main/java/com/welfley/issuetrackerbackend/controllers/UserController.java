package com.welfley.issuetrackerbackend.controllers;


import com.welfley.issuetrackerbackend.models.UserResource;
import com.welfley.issuetrackerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private UserResource getCurrentUser(@RequestBody UserResource userResource) {
        return userService.getUser(userResource);
    }

    @GetMapping("login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
        return userService.getUserByUsername(username, password);
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody UserResource userResource) {
        boolean userExists = userService.findUserByUsername(userResource.getUsername());
        if (userExists) {
            System.out.println("Username already exists");
            return false;
        }
        userService.saveUser(userResource);
        return true;
    }
}
