package com.organic.dto;

import lombok.*;


@Data
@AllArgsConstructor
@Getter
@Setter
public class UserLikeDTO {
    private Long id;
    private int totalLike;
    private int idProduct;
    private int idUser;
    private String nameProduct;
    private String imageProduct;
    private double priceProduct;

    public UserLikeDTO(int totalLike, int idProduct, int idUser, String nameProduct, String imageProduct, double priceProduct){
        this.totalLike = totalLike;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.nameProduct = nameProduct;
        this.imageProduct = imageProduct;
        this.priceProduct = priceProduct;
    }
}
