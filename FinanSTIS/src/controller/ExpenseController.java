/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Balance;
import model.BalanceCategory;
import model.Transaction;
import util.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */


public class ExpenseController {
    // Method untuk menambah kategori saldo
    public void addBalanceCategory(BalanceCategory category) {
        String sql = "INSERT INTO balance_categories(name) VALUES(?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method untuk mengambil semua kategori saldo
    public List<BalanceCategory> getAllBalanceCategories() {
        List<BalanceCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM balance_categories";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BalanceCategory category = new BalanceCategory();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categories;
    }
    // Method untuk menambah saldo
    public void addBalance(Balance balance) {
        String sql = "INSERT INTO balances(category, amount) VALUES(?,?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, balance.getCategory());
            pstmt.setDouble(2, balance.getAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method untuk menambah transaksi
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions(type, date, category, amount, description, balance_id) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getType());
            pstmt.setString(2, transaction.getDate());
            pstmt.setString(3, transaction.getCategory());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setString(5, transaction.getDescription());
            pstmt.setInt(6, transaction.getBalanceId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method untuk mengambil semua saldo
    public List<Balance> getAllBalances() {
        List<Balance> balances = new ArrayList<>();
        String sql = "SELECT * FROM balances";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Balance balance = new Balance();
                balance.setId(rs.getInt("id"));
                balance.setCategory(rs.getString("category"));
                balance.setAmount(rs.getDouble("amount"));
                balances.add(balance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return balances;
    }

    // Method untuk mengambil semua transaksi
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getString("date"));
                transaction.setCategory(rs.getString("category"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDescription(rs.getString("description"));
                transaction.setBalanceId(rs.getInt("balance_id"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return transactions;
    }
    
    // Method untuk daftar pengguna baru
    public boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    // Method untuk pengguna login
    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
