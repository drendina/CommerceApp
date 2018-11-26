package com.sopra.data;

import org.springframework.stereotype.Repository;

@Repository
public class ProductSkuData {

    //private String styleNumber; // baseproduct_idSku
    private int idSku;
    private String description;
    private String name;
    private String image;
    private String colore;
    private String tessuto;
    private String category;
    private String gender;
    private String size;
    private int price;

    public ProductSkuData(){}

    public ProductSkuData(int idSku, String description, String name, String image, String colore, String tessuto, String category, String gender, String size, int price) {
        //this.styleNumber = styleNumber;
        this.idSku = idSku;
        this.description = description;
        this.name = name;
        this.image = image;
        this.colore = colore;
        this.tessuto = tessuto;
        this.category=category;
        this.gender = gender;
        this.size = size;
        this.price = price;
    }

   /* public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
    }*/

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
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


    @Override
    public String toString() {
        return "ProductSkuData{" +
                " idSku=" + idSku +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", colore='" + colore + '\'' +
                ", tessuto='" + tessuto + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
