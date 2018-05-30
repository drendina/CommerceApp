package com.sopra.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompleteUserForm {
    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 3)
    private String surname;

    @NotNull
    @Size(min = 10)
    private String address;

    @NotNull
    @Min(99999999)
    @Max(999999999)
    private int number;

    @NotNull
    @Min(10000)
    @Max(30000)
    private int cap;

    @NotNull
    @Size(min = 3)
    private String city;

    @NotNull
    @Size(min = 3)
    private String nation;

    @NotNull
    @Size(min = 3)
    private String email;

    @NotNull
    @Size(min = 3)
    private String password;
    @NotNull
    @Size(min = 1)
    private String newsletter;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
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

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    @Override
    public String toString() {
        return "CompleteUserForm{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", cap=" + cap +
                ", city='" + city + '\'' +
                ", nation='" + nation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", newsletter='" + newsletter + '\'' +
                '}';
    }
}
