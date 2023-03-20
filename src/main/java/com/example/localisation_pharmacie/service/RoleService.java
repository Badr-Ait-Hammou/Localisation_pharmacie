package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.Role;
import com.example.localisation_pharmacie.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IDao<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role o) {
        return roleRepository.save(o);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public void update(Role o) {
        roleRepository.save(o);

    }

    @Override
    public void delete(Role o) {
    roleRepository.delete(o);
    }
}
