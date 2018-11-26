package com.sopra.data;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

@Repository
public class CartPageData implements Iterable<CartPageData>{

    private int idSku;
    private String name;
    private String image;
    private int cumulative_size_price;
    private int quantity;
    private String size;

    public CartPageData(){}

    public CartPageData(int idSku, String name, String image, int cumulative_size_price, int quantity, String size) {
        this.idSku = idSku;
        this.name = name;
        this.image = image;
        this.cumulative_size_price = cumulative_size_price;
        this.quantity = quantity;
        this.size = size;
    }

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
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

    public int getCumulative_size_price() {
        return cumulative_size_price;
    }

    public void setCumulative_size_price(int cumulative_size_price) {
        this.cumulative_size_price = cumulative_size_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CartPageData{" +
                "idSku=" + idSku +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", cumulative_size_price=" + cumulative_size_price +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartPageData that = (CartPageData) o;
        return idSku == that.idSku &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSku, size);
    }

    @NotNull
    @Override
    public Iterator<CartPageData> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super CartPageData> action) {

    }

    @Override
    public Spliterator<CartPageData> spliterator() {
        return null;
    }
}
