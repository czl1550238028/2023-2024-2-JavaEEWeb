package com.example.ch6_1.repository;

import com.example.ch6_1.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
}

