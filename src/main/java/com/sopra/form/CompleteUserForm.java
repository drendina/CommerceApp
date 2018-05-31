package com.sopra.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class CompleteUserForm {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String CAP_PATTERN = "^[0-9]{5}$";
    private static final String PHONE_NUMBER_PATTERN = "^\\d{10}$";

    @NotBlank
    private String title;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String address;

    @Pattern(regexp = PHONE_NUMBER_PATTERN)
    private String number;

    @Pattern(regexp = CAP_PATTERN )
    private String cap;

    @NotBlank
    private String city;

    @NotBlank
    private String nation;

    @Pattern (regexp = EMAIL_PATTERN, message = "must match name@domain.country")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordRepeat;

    @NotBlank
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

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
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
