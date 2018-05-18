package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
@Repository
@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idStock;

    @Column
    private int remainingItems;

    @Column
    private int idSku;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getRemainingItems() {
        return remainingItems;
    }

    public void setRemainingItems(int remainingItems) {
        this.remainingItems = remainingItems;
    }

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock=" + idStock +
                ", remainingItems=" + remainingItems +
                ", idSku=" + idSku +
                '}';
    }
}
