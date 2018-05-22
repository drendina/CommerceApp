package com.sopra.data;

public class CartData {

    private int idCart;
    private int amount;
    private int idUser;

    public CartData(int idCart, int amount, int idUser) {
        this.idCart = idCart;
        this.amount = amount;
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
        return "CartData{" +
                "idCart=" + idCart +
                ", amount=" + amount +
                ", idUser=" + idUser +
                '}';
    }
}
