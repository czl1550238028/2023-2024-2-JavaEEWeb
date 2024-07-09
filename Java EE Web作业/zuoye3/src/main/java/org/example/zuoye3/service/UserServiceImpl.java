package org.example.zuoye3.service;

import jakarta.transaction.Transactional;
import org.example.zuoye3.entity.MyUser;
import org.example.zuoye3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;//依赖注入数据访问层

    @Override
    public void saveAll() {
        MyUser mu1 = new MyUser();
        mu1.setUname("aaa");
        mu1.setPassword("123456");
        mu1.setName("陈恒1");
        mu1.setAge(88);
        MyUser mu2 = new MyUser();
        mu2.setUname("bbb");
        mu2.setPassword("123456");
        mu2.setName("陈恒2");
        mu2.setAge(18);
        MyUser mu3 = new MyUser();
        mu3.setUname("ccc");
        mu3.setPassword("123456");
        mu3.setName("陈恒3");
        mu3.setAge(99);
        MyUser mu4 = new MyUser();
        mu4.setUname("ddd");
        mu4.setPassword("123456");
        mu4.setName("陈恒4");
        mu4.setAge(20);
        MyUser mu5 = new MyUser();
        mu5.setUname("eee");
        mu5.setPassword("123456");
        mu5.setName("陈恒5");
        mu5.setAge(66);
        List<MyUser> users = new ArrayList<MyUser>();
        users.add(mu1);
        users.add(mu2);
        users.add(mu3);
        users.add(mu4);
        users.add(mu5);
        //调用父接口中的方法saveAll
        userRepository.saveAll(users);
    }

    @Override
    public List<MyUser> findAll() {
        //调用父接口中的方法findAll
        return userRepository.findAll();
    }

    @Override
    public MyUser findByUname(String uname) {
        return userRepository.findByUname(uname);
    }

    @Override
    public List<MyUser> findByUnameLike(String uname) {
        return userRepository.findByUnameLike("%" + uname + "%");
    }

    @Override
    public MyUser getOne(int id) {
        //调用父接口中的方法getOne
        return userRepository.getOne(id);
    }
}

