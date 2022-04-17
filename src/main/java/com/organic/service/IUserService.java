package com.organic.service;

import com.organic.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User save(User u);
    public List<User> getAllUser();
    public Optional<User> findUserById(int id);
    public void deleteUserById(int id);
    public User update(User u);
}
