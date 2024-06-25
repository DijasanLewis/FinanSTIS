/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Yedija Lewi Suryadi (222212921 - 2KS1 - Politeknik Statistika STIS 2024)
 */
public class DatabaseHelper {
    // URL untuk koneksi ke database SQLite
    private static final String URL = "jdbc:sqlite:finanstis.db";

    // Method untuk menghubungkan ke database
    public static Connection connect() {
        Connection conn = null;
        try {
            // Mencoba untuk membuat koneksi ke database
            conn = DriverManager.getConnection(URL);
            System.out.println("Koneksi ke SQLite berhasil.");
        } catch (SQLException e) {
            // Menangani kesalahan koneksi
            System.out.println(e.getMessage());
        }
        // Mengembalikan objek koneksi
        return conn;
    }
}
