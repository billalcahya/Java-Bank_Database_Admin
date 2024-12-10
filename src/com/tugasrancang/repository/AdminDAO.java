package com.tugasrancang.repository;

import com.tugasrancang.models.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class AdminDAO {

    public static DefaultTableModel getAdminData() {
        DefaultTableModel model = new DefaultTableModel();
        String query = "SELECT id, username, password, created_at FROM admin";

        model.setColumnIdentifiers(new Object[]{"ID", "Username", "Password", "Waktu"});

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getTimestamp("created_at")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data admin dari database!");
        }

        return model;
    }

    public void tambahAdmin(Admin admin) {
        String query = "INSERT INTO admin (username, password, created_at) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.setTimestamp(3, admin.getWaktu());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Gagal menambah nasabah!", e);
        }
    }

    public void updateAdmin(Admin admin) {
        String query = "UPDATE admin SET username = ?, password = ?, created_at = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPassword());
            stmt.setTimestamp(3, admin.getWaktu());
            stmt.setInt(4, admin.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Admin dengan ID " + admin.getId() + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal memperbarui data admin!", e);
        }
    }

    public void deleteAdmin(int id) {
        String query = "DELETE FROM admin WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Admin dengan ID " + id + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Gagal menghapus data admin!", e);
        }
    }

}
