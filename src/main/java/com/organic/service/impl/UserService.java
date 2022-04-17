package com.organic.service.impl;

import com.organic.entity.Order;
import com.organic.entity.User;
import com.organic.repository.OrderRepository;
import com.organic.repository.UserRepository;
import com.organic.service.IUserService;
import com.organic.util.MD5Encryptor;
import com.organic.util.ValidateAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private static Key key = MD5Encryptor.generateKey();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public User save(User u) {
        User fromDB = new User();

        if(u.getUsername().length() < 5){
            return null;
        } else {
            fromDB.setUsername(u.getUsername());
        }

        if(u.getPassword().length() < 5){
            return null;
        } else {
            try {
                String encryptPass = MD5Encryptor.encrypt(u.getPassword(), key);
                fromDB.setPassword(encryptPass);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        fromDB.setFullname(u.getFullname());

        fromDB.setAddress(u.getAddress());

        if(ValidateAttribute.isValidMobileNumber(u.getPhone())){
            fromDB.setPhone(u.getPhone());
        }

        fromDB.setRole(false);
        this.userRepository.save(fromDB);
        this.insertOrder(fromDB);
        return fromDB;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        list = this.userRepository.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public Optional<User> findUserById(int id) {
        if(id < 0){
            return null;
        }
        return this.userRepository.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User update(User u) {
        User fromDB = this.userRepository.findById(u.getId()).orElse(null);
        try {
            if(fromDB != null){
                fromDB.setFullname(u.getFullname());
                fromDB.setAddress(u.getAddress());
                fromDB.setPassword(MD5Encryptor.encrypt(u.getPassword(), key));
                fromDB.setPhone(u.getPhone());
                return this.userRepository.save(fromDB);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void insertOrder(User u){
        Order o = new Order();
        o.setIdUser(u.getId());
        o.setStatus("Unresolved");
        this.orderService.createNewOrder(u);
    }

    public User login(String u, String p){
        return this.userRepository.findUserByUsernameAndPassword(u, p);
    }
}
