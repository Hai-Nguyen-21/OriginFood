package com.organic.entity;

import com.organic.dto.UserLikeDTO;

import javax.persistence.*;

@Entity
@Table(name = "user_like")
@NamedNativeQuery(
        name = "getLikeProduct",
        query = "SELECT COUNT(u.idProduct) as SOLUONG, u.idProduct IDPRODUCT, u.idUser IDUSER, u.nameProduct NAMEPRODUCT, u.imageProduct IMAGEPRODUCT FROM UserLike u GROUP BY u.idProduct ORDER BY SOLUONG DESC",
        resultSetMapping = "TopLikeProduct"
)
@SqlResultSetMapping(
        name = "TopLikeProduct",
        classes = {
                @ConstructorResult(
                        targetClass = UserLikeDTO.class,
                        columns = {
                                @ColumnResult(name = "SOLUONG", type = Integer.class),
                                @ColumnResult(name = "IDPRODUCT", type = Integer.class),
                                @ColumnResult(name = "IDUSER", type = Integer.class),
                                @ColumnResult(name = "NAMEPRODUCT", type = String.class),
                                @ColumnResult(name = "IMAGEPRODUCT", type = String.class)
                        }
                )
        }
)
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_user", nullable = false)
    private Integer idUser;

    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}