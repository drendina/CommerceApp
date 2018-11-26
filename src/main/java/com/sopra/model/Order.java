package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Column @GeneratedValue(strategy = GenerationType.AUTO) @Id private int idOrder;
    @Column private String orderDate;
    @Column private int idUser;
    @Column private int amount;

    public Order() {
    }

    public Order(String orderDate, int idUser, int amount) {
        this.orderDate = orderDate;
        this.idUser = idUser;
        this.amount = amount;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", orderDate='" + orderDate + '\'' +
                ", idUser=" + idUser +
                ", amount=" + amount +
                '}';
    }
}
