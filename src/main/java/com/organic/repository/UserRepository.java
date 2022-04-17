package com.organic.repository;

import com.organic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUsernameAndPassword(String username, String password);
}
