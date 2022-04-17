package com.organic.service.impl;

import com.organic.entity.UserLike;
import com.organic.repository.UserLikeRepository;
import com.organic.service.IUserLikeService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLikeService implements IUserLikeService {
    @Autowired
    private UserLikeRepository userLikeRepository;

    public List<UserLike> getAllByUser(int id_user){
        return this.userLikeRepository.findByIdUser(id_user);
    }

    @Override
    public UserLike save(UserLike ul) {
        return this.userLikeRepository.save(ul);
    }

    @Override
    public void delete(int id) {
        this.userLikeRepository.deleteById(id);
    }
}
