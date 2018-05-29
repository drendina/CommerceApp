package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Repository
@Entity
@Table(name = "sku_order")
public class SkuOrder {

    @Id
    @GeneratedValue
    private int idSku_order;
    private int idSku;
    private int idOrder;

    public SkuOrder() {
    }

    public SkuOrder(int idSku, int idOrder) {
        this.idSku = idSku;
        this.idOrder = idOrder;
    }

    public int getIdSku_order() {
        return idSku_order;
    }

    public void setIdSku_order(int idSku_order) {
        this.idSku_order = idSku_order;
    }

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "SkuOrder{" +
                "idSku_order=" + idSku_order +
                ", idSku=" + idSku +
                ", idOrder=" + idOrder +
                '}';
    }
}
