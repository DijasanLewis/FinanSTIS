/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import util.DatabaseHelper;
import java.sql.*;

/**
 *
 * @author yedij
 */


/**
 * Controller untuk mengelola pengguna.
 */
public class UserController {

    // Method untuk mendaftarkan pengguna baru
    public boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        boolean isSuccess = false;

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                // Mendapatkan ID pengguna yang baru dibuat
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        // Buat saldo awal untuk pengguna baru
                        createInitialBalances(userId);
                        isSuccess = true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }

    // Method untuk membuat saldo awal untuk pengguna baru
    private void createInitialBalances(int userId) {
        String[] categories = {"Tunai", "Bank", "E-Money", "Lainnya"};
        String sql = "INSERT INTO balances(user_id, category, amount) VALUES(?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (String category : categories) {
                pstmt.setInt(1, userId);
                pstmt.setString(2, category);
                pstmt.setDouble(3, 0.0); // Set amount to 0.0
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method untuk login pengguna
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

    // Method untuk mendapatkan ID pengguna berdasarkan username
    public int getUserId(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1; // Return -1 jika tidak ditemukan
    }
}
