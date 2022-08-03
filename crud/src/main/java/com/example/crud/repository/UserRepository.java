package com.example.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.User;

// @Repository tells the spring boot that it wrapped with User Table with sql execution queries.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}