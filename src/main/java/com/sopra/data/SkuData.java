package com.sopra.data;

public class SkuData {

    private int idSku;
    private String size;
    private int price;
    private int baseProduct;

    public SkuData() {
    }

    public SkuData(int idSku, String size, int price, int baseProduct) {
        this.idSku = idSku;
        this.size = size;
        this.price = price;
        this.baseProduct = baseProduct;
    }

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
        return "SkuData{" +
                "idSku=" + idSku +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", baseProduct=" + baseProduct +
                '}';
    }
}
