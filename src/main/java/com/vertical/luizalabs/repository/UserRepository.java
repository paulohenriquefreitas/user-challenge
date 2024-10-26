package com.vertical.luizalabs.repository;

import com.vertical.luizalabs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}