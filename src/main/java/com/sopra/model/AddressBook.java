package com.sopra.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Repository
@Entity
@Table(name = "address_book")
public class AddressBook implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAddressBook;

    @Column
    private String address;

    @Column
    private String number;

    @Column
    private String cap;

    @Column
    private String city;

    @Column
    private String nation;

    public AddressBook(){}

    public AddressBook(String address, String number, String cap, String city, String nation ){
        this.address=address;
        this.number=number;
        this.cap=cap;
        this.city=city;
        this.nation=nation;
    }

    public int getIdAddressBook() {
        return idAddressBook;
    }

    public void setIdAddressBook(int idAddressBook) {
        this.idAddressBook = idAddressBook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "idAddressBook=" + idAddressBook +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", cap=" + cap +
                ", city='" + city + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}
