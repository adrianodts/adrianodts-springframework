package com.adrianodts.springframework.javapersistenceapi.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
// @Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "p_id")
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "cd_id", referencedColumnName = "cd_id")
    // private CartDetail cartDetail;

    // @Column(name = "p_description")
    private String description;

    // @Column(name = "p_price")
    private BigDecimal price;

    // @Column(name = "p_image_url")
    private String imageUrl;

    @Version
    // @Column(name = "p_version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public CartDetail getCartDetail() {
    //     return cartDetail;
    // }

    // public void setCartDetail(CartDetail cartDetail) {
    //     this.cartDetail = cartDetail;
    // }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    } 



}
