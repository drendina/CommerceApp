package com.sopra.data;

import org.springframework.stereotype.Repository;

@Repository
public class ProductData {

    private int idProduct;
    private String description;
    private String name;
    private String image;
    private String colore;
    private String tessuto;

    public ProductData() {
    }

    public ProductData(int idProduct, String description, String name, String image, String colore, String tessuto) {
        this.idProduct = idProduct;
        this.description = description;
        this.name = name;
        this.image = image;
        this.colore = colore;
        this.tessuto = tessuto;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    @Override
    public String toString() {
        return "ProductData{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", colore='" + colore + '\'' +
                ", tessuto='" + tessuto + '\'' +
                '}';
    }
}
