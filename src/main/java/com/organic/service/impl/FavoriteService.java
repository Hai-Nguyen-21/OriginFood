package com.organic.service.impl;

import com.organic.dto.FeaturedProductDTO;
import com.organic.entity.Favorites;
import com.organic.repository.FavoriteRepository;
import com.organic.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FavoriteService implements IFavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FeaturedProductDTO> getFeaturedProduct() {
        List<FeaturedProductDTO> listFeaturedProduct = this.entityManager.createNamedQuery("getFeaturedProduct").getResultList();
        return listFeaturedProduct;
    }

    @Override
    public Favorites save(Favorites favorites) {
        return this.favoriteRepository.save(favorites);
    }

    @Override
    public void delete(int id) {
        this.favoriteRepository.deleteById(id);
    }

    public List<Favorites> getAllFavoriteById(int id){
        List<Favorites> listFavorites = this.favoriteRepository.findFavoritesByIdUser(id);
        return listFavorites;
    }

    public int getTotalFavoriteById(int id){
        return this.favoriteRepository.getTotalFavorite(id);
    }
}
