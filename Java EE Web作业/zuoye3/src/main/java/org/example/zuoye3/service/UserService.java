package org.example.zuoye3.service;

import org.example.zuoye3.entity.MyUser;

import java.util.List;

public interface UserService {
    public void saveAll();
    public List<MyUser> findAll();
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
    public MyUser getOne(int id);
}

