package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Role;
import com.example.localisation_pharmacie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @GetMapping("/")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/id/{id}")
    public Role findById(@PathVariable int id) {
        return roleService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Role roleinfo) {
        roleService.update(id, roleinfo);
    }

    @DeleteMapping("/")
    public void delete(@PathVariable Role o) {
        roleService.delete(o);
    }


}
