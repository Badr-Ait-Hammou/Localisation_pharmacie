package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.User;
import com.example.localisation_pharmacie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IDao<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User o) {
        return userRepository.save(o);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User o) {
        userRepository.save(o);
    }

    @Override
    public void delete(User o) {
        userRepository.delete(o);
    }
}
