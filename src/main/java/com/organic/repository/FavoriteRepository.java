package com.organic.repository;

import com.organic.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorites, Integer> {

    public List<Favorites> findFavoritesByIdUser(int id_user);

    @Query(value = "SELECT COUNT(a.idUser) FROM Favorites a WHERE a.idUser = ?1")
    public int getTotalFavorite(int id);

}
