package com.sopra.data;

import org.springframework.stereotype.Repository;

@Repository
public class ProductData {

    private String code;
    private String description;
    private String name;
    private String image;
    private String colore;
    private String tessuto;
    private String category;
    private String gender;

    public ProductData() {
    }

    public ProductData(String code, String description, String name, String image, String colore, String tessuto, String category, String gender) {
        this.description = description;
        this.name = name;
        this.image = image;
        this.colore = colore;
        this.tessuto = tessuto;
        this.category = category;
        this.gender = gender;
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
        return "ProductData{" +
                " description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", colore='" + colore + '\'' +
                ", tessuto='" + tessuto + '\'' +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
