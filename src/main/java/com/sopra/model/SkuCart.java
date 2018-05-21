package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Repository
@Entity
@Table(name = "sku_cart")
public class SkuCart {

    @Id
    @GeneratedValue
    private int idSku_cart;
    private int idSku;
    private int idCart;

    public SkuCart() {
    }

    public SkuCart(int idSku, int idCart) {
        this.idSku = idSku;
        this.idCart = idCart;
    }

    public int getIdSku_cart() {
        return idSku_cart;
    }

    public void setIdSku_cart(int idSku_cart) {
        this.idSku_cart = idSku_cart;
    }

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }
}
