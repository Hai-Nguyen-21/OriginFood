package com.organic.controller;

import com.organic.dto.FeaturedProductDTO;
import com.organic.entity.Favorites;
import com.organic.service.impl.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/featureds")
    public List<FeaturedProductDTO> getFeatured(){
        List<FeaturedProductDTO> listFeaturedProduct = this.favoriteService.getFeaturedProduct();
        return listFeaturedProduct;
    }

    @GetMapping("{id}")
    public List<Favorites> getAllFavorite(@PathVariable int id){
        List<Favorites> listFavorites = this.favoriteService.getAllFavoriteById(id);
        return listFavorites;
    }

    @GetMapping("/totalFav/{id}")
    public int getTotalFavor(@PathVariable int id){
        int total = this.favoriteService.getTotalFavoriteById(id);
        return total;
    }

    @PostMapping
    public Favorites saveFavorites(@Validated @RequestBody Favorites favorite){
        return this.favoriteService.save(favorite);
    }

    @DeleteMapping("{id}")
    public void deleteFavorite(@PathVariable int id){
        this.favoriteService.delete(id);
    }
}
