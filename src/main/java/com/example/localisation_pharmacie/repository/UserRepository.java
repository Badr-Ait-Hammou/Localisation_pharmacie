package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);
}
