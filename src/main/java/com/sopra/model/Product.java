package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private String colore;

    @Column
    private String tessuto;

    @Column
    private String category;

    @Column
    private String gender;

    public Product() {}

    public Product(String code, String description, String name, String image, String colore, String tessuto, String category, String gender) {
        this.code="" +this.idProduct + "";
        this.description = description;
        this.name = name;
        this.image = image;
        this.colore = colore;
        this.tessuto = tessuto;
        this.category = category;
        this.gender = gender;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getTessuto() {
        return tessuto;
    }

    public void setTessuto(String tessuto) {
        this.tessuto = tessuto;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", colore='" + colore + '\'' +
                ", tessuto='" + tessuto + '\'' +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
