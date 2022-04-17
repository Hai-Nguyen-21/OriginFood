package com.organic.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // DH + random 2 số + createdDate + idUser (DH 21012002 1)
    @Column(name = "code")
    private String code;

    @Column(name = "createddate")
    private Timestamp createDate;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_user", nullable = false)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "address", nullable = false)
    private String address;

    // 1 - Unresolved - đang đợi xử lý
    // 2 - Processing - đang xử lý
    // 3 - Processed - đã xử lý xong
    // 4 - Shipping - đang vận chuyển
    // 5 - Completion - Giao thành công
    // 6 - Fail - Giao thất bại
    @Column(name = "status")
    private String status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}