package org.example.shiyan2.repository;

import org.example.shiyan2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);
    void deleteById(long id);

}
