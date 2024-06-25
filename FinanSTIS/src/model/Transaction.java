/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */
// Kelas untuk merepresentasikan transaksi
public class Transaction {
    private int id;
    private String type;
    private String date;
    private String category;
    private double amount;
    private String description;
    private int balanceId;

    // Konstruktor default
    public Transaction() {}

    // Konstruktor dengan parameter
    public Transaction(int id, String type, String date, String category, double amount, String description, int balanceId) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.balanceId = balanceId;
    }

    // Getter dan Setter untuk setiap atribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }
}
