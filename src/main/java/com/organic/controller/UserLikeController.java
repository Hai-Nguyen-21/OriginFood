package com.organic.controller;

import com.organic.dto.UserLikeDTO;
import com.organic.entity.UserLike;
import com.organic.service.impl.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user/liked")
public class UserLikeController {

    @Autowired
    private UserLikeService userLikeService;

    @GetMapping("{id}")
    public List<UserLike> getAll(@PathVariable int id){
        return this.userLikeService.getAllByUser(id);
    }

    @PostMapping("/add")
    public UserLike saveUserLike(@RequestBody UserLike userLike){
        return this.userLikeService.save(userLike);
    }

    @DeleteMapping("{id}")
    public void deleteUserLike(@PathVariable int id){
        this.userLikeService.delete(id);
    }

    @GetMapping("/report-count")
    public List<UserLikeDTO> getAllTotalCount(){
        return this.userLikeService.reportUserLike();
    }
}
