package com.bss.auth.controller;

import com.bss.auth.model.User;
import com.bss.auth.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Rocky on 14-11-2018.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private CustomUserDetailsService userService;

    /*@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }*/

    /*@PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/{username}")
    public User getUserByName(@PathVariable(value = "username") String username){
        return userService.findByUserName(username);
    }*/

    @GetMapping("/current")
    public User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("UserController, getAuthenticatedUser, user: "+ auth.getName());
        return userService.findByUserName(auth.getName());
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        System.out.println("UserController registerUser, user: "+ user);
        return userService.saveUser(user);
    }
}
