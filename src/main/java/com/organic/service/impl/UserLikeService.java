package com.organic.service.impl;

import com.organic.dto.UserLikeDTO;
import com.organic.entity.UserLike;
import com.organic.repository.UserLikeRepository;
import com.organic.service.IUserLikeService;
import com.organic.util.DataUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserLikeService implements IUserLikeService {
    @Autowired
    private UserLikeRepository userLikeRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<UserLikeDTO> reportUserLike(){
        String sql = "SELECT COUNT(u.id_product) as SOLUONG, u.id_product IDPRODUCT, u.id_user IDUSER, p.name AS NAMEPRODUCT, p.image AS IMAGEPRODUCT, p.price AS PRICEPRODUCT FROM user_like u JOIN product p ON u.id_product = p.id GROUP BY u.id_product ORDER BY SOLUONG DESC";
        Query query = this.entityManager.createNativeQuery(sql.toString(), "TopLikeProduct");
        if (!DataUtils.isNullObject(5)) {
            query.setFirstResult(0).setMaxResults(5);
        }
        return query.getResultList();
    }
}
