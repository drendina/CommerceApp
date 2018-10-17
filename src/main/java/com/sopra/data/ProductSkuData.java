package com.sopra.data;

import org.springframework.stereotype.Repository;

@Repository
public class ProductSkuData {

    private String styleNumber; // baseproduct_idSku
    private String description;
    private String name;
    private String image;
    private String colore;
    private String tessuto;
    private String size;
    private int price;

    public ProductSkuData(){}

    public ProductSkuData(String styleNumber, String description, String name, String image, String colore, String tessuto, String size, int price) {
        this.styleNumber = styleNumber;
        this.description = description;
        this.name = name;
        this.image = image;
        this.colore = colore;
        this.tessuto = tessuto;
        this.size = size;
        this.price = price;
    }

    public String getStyleNumber() {
        return styleNumber;
    }

    public void setStyleNumber(String styleNumber) {
        this.styleNumber = styleNumber;
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
        return "SkuData{" +
                "styleNumber=" + styleNumber +
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
