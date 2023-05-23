package com.example.localisation_pharmacie.service;

import com.example.localisation_pharmacie.dao.IDao;
import com.example.localisation_pharmacie.entity.User;
import com.example.localisation_pharmacie.entity.Ville;
import com.example.localisation_pharmacie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IDao<User> {

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

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
    public void delete(User o) {

    }


    public void update(Integer id,User userinfo) {
        User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        user.setEmail(userinfo.getEmail());
      //  user.setNom(userinfo.getNom());
       // user.setPrenom(userinfo.getPrenom());
       // user.setPharmacieList(userinfo.getPharmacieList());
        user.setPassword(userinfo.getPassword());
        userRepository.save(user);
    }


    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id " + id));
        userRepository.delete(user);
    }
}
