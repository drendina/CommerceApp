package com.sopra.data;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserData {
//idUser NON deve esserci
    private int idUser;
    private String title;
    private String name;
    private String surname;
    private List<AddressData> addresses;
    private String email;
    private String password;
    private String role;
    private String newsletter;
    private CartData cartData;

    public UserData() {
    }

    public UserData(int idUser, String title, String name, String surname, String role) {
        this.idUser = idUser;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }
// BISOGNA ARRIVARE AD UTILIZZARE QUESTO!!!

/*    public UserData(String title, String name, String surname, List<AddressData> addresses, String role) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }*/

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<AddressData> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressData> addresses) {
        addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "idUser=" + idUser +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addresses=" + addresses +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", newsletter='" + newsletter + '\'' +
                ", cartData=" + cartData +
                '}';
    }
}
