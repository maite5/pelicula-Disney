package com.alkemy.pelicula.pelicula.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
