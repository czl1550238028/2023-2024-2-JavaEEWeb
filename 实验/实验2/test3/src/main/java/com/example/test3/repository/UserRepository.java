package com.example.test3.repository;


import com.example.test3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    void deleteById(Long id);
}