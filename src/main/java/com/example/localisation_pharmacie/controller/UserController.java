package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.User;
import com.example.localisation_pharmacie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/controller/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/email/{email}")
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody User userinfo) {
        userService.update(id, userinfo);
    }





}
