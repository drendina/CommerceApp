package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
@Repository
@Entity
@Table(name = "sku")
public class Sku implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSku;

    @Column
    private String size;

    @Column
    private int price;

    @Column
    private int baseProduct;

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBaseProduct() {
        return baseProduct;
    }

    public void setBaseProduct(int baseProduct) {
        this.baseProduct = baseProduct;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "idSku=" + idSku +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", baseProduct=" + baseProduct +
                '}';
    }
}
