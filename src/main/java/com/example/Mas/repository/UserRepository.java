package com.example.Mas.repository;

import com.example.Mas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    // SELECT * FROM USER WHERE username = ?1
    User findByUsername(String username);
    User findByEmail(String email);
}
