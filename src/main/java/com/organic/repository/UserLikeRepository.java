package com.organic.repository;

import com.organic.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {
    public List<UserLike> findByIdUser(int id_user);
}
