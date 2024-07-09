package com.example.ch6_6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ch6_6.entity.MyUser;
import com.example.ch6_6.repository.MyUserRepository;
@Service
public class MyUserServiceImpl implements MyUserService{
	@Autowired
	private MyUserRepository myUserRepository;
	@Override
	public List<MyUser> findAll() {
		return myUserRepository.findAll();
	}
}
