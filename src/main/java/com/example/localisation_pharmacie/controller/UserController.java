package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.User;
import com.example.localisation_pharmacie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id/{id}")
    public User findById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/save")
    public int save(@RequestBody User user) {
        userRepository.save(user);
        return 1;
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return userRepository.findAll();
    }



}
