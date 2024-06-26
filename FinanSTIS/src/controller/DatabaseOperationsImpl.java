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
/**
 *
 * @author yedij
 */

public class DatabaseOperationsImpl implements DatabaseOperations {

    @Override
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

    @Override
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

    @Override
    public void addBalance(Balance balance) {
        String sql = "INSERT INTO balances(category, amount, user_id) VALUES(?,?,?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, balance.getCategory());
            pstmt.setDouble(2, balance.getAmount());
            pstmt.setInt(3, balance.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions(type, date, category, amount, description, balance_id, user_id) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getType());
            pstmt.setString(2, transaction.getDate());
            pstmt.setString(3, transaction.getCategory());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setString(5, transaction.getDescription());
            pstmt.setInt(6, transaction.getBalanceId());
            pstmt.setInt(7, transaction.getUserId());
            pstmt.executeUpdate();

            // Update balance
            return updateBalance(transaction.getBalanceId(), transaction.getAmount(), transaction.getType());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBalance(int balanceId, double amount, String transactionType) {
        String sql = "UPDATE balances SET amount = amount + ? WHERE id = ?";

        double updateAmount = transactionType.equals("Pengeluaran") ? -amount : amount;

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, updateAmount);
            pstmt.setInt(2, balanceId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Balance> getAllBalances(int userId) {
        List<Balance> balances = new ArrayList<>();
        String sql = "SELECT * FROM balances WHERE user_id = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Balance balance = new Balance();
                balance.setId(rs.getInt("id"));
                balance.setCategory(rs.getString("category"));
                balance.setAmount(rs.getDouble("amount"));
                balance.setUserId(userId);
                balances.add(balance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return balances;
    }

    @Override
    public List<Transaction> getAllTransactions(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getString("date"));
                transaction.setCategory(rs.getString("category"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDescription(rs.getString("description"));
                transaction.setBalanceId(rs.getInt("balance_id"));
                transaction.setUserId(userId);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return transactions;
    }
    
    @Override
    public List<Transaction> getTransactionsByPeriod(int userId, String period) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ? AND date >= ?";

        String currentDate = java.time.LocalDate.now().toString();
        String startDate;

        switch (period) {
            case "Hari Ini":
                startDate = currentDate;
                break;
            case "7 Hari":
                startDate = java.time.LocalDate.now().minusDays(7).toString();
                break;
            case "30 Hari":
            default:
                startDate = java.time.LocalDate.now().minusDays(30).toString();
                break;
        }

        System.out.println("Memuat transaksi untuk user id: " + userId + ", periode: " + period + ", dari tanggal: " + startDate);

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, startDate);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getString("date"));
                transaction.setCategory(rs.getString("category"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDescription(rs.getString("description"));
                transaction.setBalanceId(rs.getInt("balance_id"));
                transaction.setUserId(rs.getInt("user_id"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Jumlah transaksi yang ditemukan: " + transactions.size());

        return transactions;
    }
    
    @Override
    public Balance getBalanceById(int balanceId) {
        String sql = "SELECT * FROM balances WHERE id = ?";
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, balanceId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Balance balance = new Balance();
                balance.setId(rs.getInt("id"));
                balance.setCategory(rs.getString("category"));
                balance.setAmount(rs.getDouble("amount"));
                balance.setUserId(rs.getInt("user_id"));
                return balance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}