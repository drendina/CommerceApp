package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
@Repository
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrder;

    @Column
    private String birthdate;

    @Column
    private int idUser;

    @Column
    private int idAddress;

    public Order() {
    }

    public Order(String birthdate, int idUser, int idAddress) {
        this.birthdate = birthdate;
        this.idUser = idUser;
        this.idAddress = idAddress;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", birthdate='" + birthdate + '\'' +
                ", idUser=" + idUser +
                ", idAddress=" + idAddress +
                '}';
    }
}
