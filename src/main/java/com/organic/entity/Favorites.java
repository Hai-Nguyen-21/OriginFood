package com.organic.entity;

import com.organic.dto.FeaturedProductDTO;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
@NamedNativeQuery(
        name = "getFeaturedProduct",
        query = "SELECT a.id_product ID_PRODUCT, p.name NAME_PRODUCT, p.image IMAGE, p.price PRICE, COUNT(a.id_product) QUANTITY FROM Favorites a JOIN Product p ON a.id_product = p.id GROUP BY a.id_product ORDER BY 3 DESC LIMIT 8",
        resultSetMapping = "FavoriteProductMapping"
)
@SqlResultSetMapping(
        name = "FavoriteProductMapping",
        classes = {
                @ConstructorResult(
                        targetClass = FeaturedProductDTO.class,
                        columns = {
                                @ColumnResult(name="ID_PRODUCT", type = Integer.class),
                                @ColumnResult(name="NAME_PRODUCT", type = String.class),
                                @ColumnResult(name="IMAGE", type = String.class),
                                @ColumnResult(name="PRICE", type = Double.class),
                                @ColumnResult(name="QUANTITY", type = Integer.class)
                        }
                )
        }
)
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "image_product")
    private String imageProduct;

    @Column(name = "price_product")
    private double priceProduct;

    public int getId_product() {
        return idProduct;
    }

    public void setId_product(int id_product) {
        this.idProduct = id_product;
    }

    public int getId_user() {
        return idUser;
    }

    public void setId_user(int id_user) {
        this.idUser = id_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }
}