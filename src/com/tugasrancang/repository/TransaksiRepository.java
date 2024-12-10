package com.tugasrancang.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class TransaksiRepository {

    public static double getTotalUang() {
        double total = 0;
        String query = "SELECT SUM(saldo) AS total FROM nasabah";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data total uang dari database!");
        }
        return total;
    }

    public static int getTotalNasabah() {
        int totalNasabah = 0;
        String query = "SELECT COUNT(*) AS total FROM nasabah";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                totalNasabah = rs.getInt("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data total nasabah dari database!");
        }

        return totalNasabah;
    }

    public static DefaultTableModel getTransaksiData() {
        DefaultTableModel model = new DefaultTableModel();
        String query = "SELECT id_transaksi, id_nasabah, jenis_transaksi, jumlah, tanggal_transaksi FROM transaksi";

        model.setColumnIdentifiers(new Object[]{"ID Transaksi", "ID Nasabah", "Jenis Transaksi", "Jumlah", "Waktu"});

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_transaksi"), 
                    rs.getInt("id_nasabah"), 
                    rs.getString("jenis_transaksi"), 
                    rs.getDouble("jumlah"),
                    rs.getTimestamp("tanggal_transaksi") 
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data transaksi dari database! " + e.getMessage(), e);
        }
        return model;
    }

}
