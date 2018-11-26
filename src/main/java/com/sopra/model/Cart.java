package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Column @GeneratedValue(strategy = GenerationType.AUTO) @Id private int idCart;
    @Column private int amount;
    @Column private int idUser;

    public Cart() {
        this.amount = 0;
    }

    public Cart(int idUser) {
        this.amount = 0;
        this.idUser = idUser;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idCart=" + idCart +
                ", amount=" + amount +
                ", idUser=" + idUser +
                '}';
    }
}
