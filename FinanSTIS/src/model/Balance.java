/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */

/**
 * Kelas untuk merepresentasikan saldo.
 */
public class Balance {
    private int id;
    private String category;
    private double amount;
    private int userId; // Tambahkan atribut userId

    // Konstruktor default
    public Balance() {}

    // Konstruktor dengan parameter
    public Balance(int id, String category, double amount, int userId) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.userId = userId;
    }

    // Getter dan Setter untuk setiap atribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
