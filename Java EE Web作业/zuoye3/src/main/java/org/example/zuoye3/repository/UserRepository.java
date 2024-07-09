package org.example.zuoye3.repository;


import org.example.zuoye3.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * 这里不需要使用@Repository注解数据访问层，
 * 因为Spring Boot自动配置了JpaRepository
 */
public interface UserRepository extends JpaRepository<MyUser, Integer>{
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
}

