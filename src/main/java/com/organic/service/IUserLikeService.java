package com.organic.service;

import com.organic.entity.UserLike;

import java.util.List;

public interface IUserLikeService {
    public UserLike save(UserLike ul);
    public void delete(int id);
}
