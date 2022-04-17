package com.organic.service;

import com.organic.dto.FeaturedProductDTO;
import com.organic.entity.Favorites;

import java.util.List;

public interface IFavoriteService {
    public List<FeaturedProductDTO> getFeaturedProduct();
    public Favorites save(Favorites favorites);
    public void delete(int id);
}
