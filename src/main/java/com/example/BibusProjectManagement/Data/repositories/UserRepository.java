package com.example.BibusProjectManagement.Data.repositories;

import com.example.BibusProjectManagement.Data.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    List<User> findAll();

    User getById(String id);
}
