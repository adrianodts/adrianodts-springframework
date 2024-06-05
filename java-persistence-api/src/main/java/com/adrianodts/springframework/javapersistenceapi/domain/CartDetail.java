package com.adrianodts.springframework.javapersistenceapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
//@Table(name = "cart_details")
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "cd_id")
    private Long id;

    @ManyToOne
    // @JoinColumn(name = "ca_id", referencedColumnName = "ca_id")
    private Cart cart;

    @OneToOne
    // @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private Product product;

    @Version
    // @Column(name = "cd_version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    
    
}
