package com.example.localisation_pharmacie.repository;

import com.example.localisation_pharmacie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findById(int id);
}
