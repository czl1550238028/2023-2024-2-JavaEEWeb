package com.example.ch6_5.service;
import java.util.List;
import com.example.ch6_5.entity.MyUser;
public interface MyUserService {
	public int saveUser(MyUser myUser);
	public int deleteUser(Integer id);
	public int updateUser(MyUser myUser);
	public List<MyUser> findAll();
	public MyUser findUserById(Integer id);
}
