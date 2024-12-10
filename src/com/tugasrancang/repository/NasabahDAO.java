package com.tugasrancang.repository;

import com.tugasrancang.models.Nasabah;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NasabahDAO {

    public static DefaultTableModel getNasabahData() {
        DefaultTableModel model = new DefaultTableModel();
        String query = "SELECT id_nasabah, nama_lengkap, nomor_rekening, jenis_akun, saldo FROM nasabah";

        model.setColumnIdentifiers(new Object[]{"ID Nasabah", "Nama", "Nomor Rekening", "Jenis Akun", "Saldo"});

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_nasabah"),
                    rs.getString("nama_lengkap"),
                    rs.getString("nomor_rekening"),
                    rs.getString("jenis_akun"),
                    rs.getDouble("saldo")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data nasabah dari database!");
        }

        return model;
    }

    public void tambahNasabah(Nasabah nasabah) {
        String query = "INSERT INTO nasabah (nama_lengkap, nomor_identitas, alamat, nomor_telepon, email, nomor_rekening, jenis_akun, saldo, pin, tanggal_lahir, tanggal_dibuat) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nasabah.getNamaLengkap());
            stmt.setString(2, nasabah.getNomorIdentitas());
            stmt.setString(3, nasabah.getAlamat());
            stmt.setString(4, nasabah.getNomorTelepon());
            stmt.setString(5, nasabah.getEmail());
            stmt.setString(6, nasabah.getNomorRekening());
            stmt.setString(7, nasabah.getJenisAkun().name());
            stmt.setString(8, nasabah.getSaldo());
            stmt.setString(9, nasabah.getPin());
            stmt.setDate(10, new java.sql.Date(nasabah.getTanggalLahir().getTime()));
            stmt.setTimestamp(11, nasabah.getTanggalDibuat());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idNasabah = generatedKeys.getInt(1);
                    catatLog(idNasabah, "TAMBAH", "Ditambahkan: " + nasabah.getNamaLengkap());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal menambah nasabah!", e);
        }
    }

    public List<Nasabah> getAllNasabah() throws SQLException {
        List<Nasabah> nasabahList = new ArrayList<>();
        String sql = "SELECT * FROM nasabah";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Nasabah nasabah = new Nasabah(
                        rs.getInt("idNasabah"),
                        rs.getString("namaLengkap"),
                        rs.getDate("tanggalLahir"),
                        rs.getString("nomorIdentitas"),
                        rs.getString("alamat"),
                        rs.getString("nomorTelepon"),
                        rs.getString("email"),
                        rs.getString("nomorRekening"),
                        Nasabah.JenisAkun.valueOf(rs.getString("jenisAkun")),
                        rs.getString("pin"),
                        rs.getTimestamp("tanggalDibuat")
                );
                nasabahList.add(nasabah);
            }
        }
        return nasabahList;
    }

    public void updateNasabah(Nasabah nasabah) throws SQLException {
        String selectSaldoSQL = "SELECT saldo FROM nasabah WHERE id_nasabah = ?";
        String updateSQL = "UPDATE nasabah SET nama_lengkap = ?, tanggal_lahir = ?, nomor_identitas = ?, alamat = ?, nomor_telepon = ?, email = ?, nomor_rekening = ?, jenis_akun = ?, saldo = ?, pin = ?, tanggal_dibuat = ? "
                + "WHERE id_nasabah = ?";
        String insertLogSQL = "INSERT INTO log_nasabah (id_nasabah, aksi, deskripsi, waktu) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); 

            String currentSaldo = null;

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSaldoSQL)) {
                selectStmt.setInt(1, nasabah.getIdNasabah());
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        currentSaldo = rs.getString("saldo");
                    } else {
                        throw new RuntimeException("ID Nasabah tidak ditemukan!");
                    }
                }
            }

            try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                updateStmt.setString(1, nasabah.getNamaLengkap());
                updateStmt.setDate(2, new java.sql.Date(nasabah.getTanggalLahir().getTime()));
                updateStmt.setString(3, nasabah.getNomorIdentitas());
                updateStmt.setString(4, nasabah.getAlamat());
                updateStmt.setString(5, nasabah.getNomorTelepon());
                updateStmt.setString(6, nasabah.getEmail());
                updateStmt.setString(7, nasabah.getNomorRekening());
                updateStmt.setString(8, nasabah.getJenisAkun().name());
                updateStmt.setString(9, currentSaldo); 
                updateStmt.setString(10, nasabah.getPin());
                updateStmt.setTimestamp(11, nasabah.getTanggalDibuat());
                updateStmt.setInt(12, nasabah.getIdNasabah());

                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful.");
                } else {
                    throw new RuntimeException("Update failed. No rows affected.");
                }
            }

            try (PreparedStatement logStmt = conn.prepareStatement(insertLogSQL)) {
                String deskripsi = "ID " + nasabah.getIdNasabah() + " Diperbarui.";
                logStmt.setInt(1, nasabah.getIdNasabah());
                logStmt.setString(2, "UBAH");
                logStmt.setString(3, deskripsi);
                logStmt.executeUpdate();
            }

            conn.commit(); 
        } catch (SQLException e) {
            throw new RuntimeException("Gagal memperbarui data nasabah!", e);
        }
    }

    public void deleteNasabah(int idNasabah) throws SQLException {
        String sql = "DELETE FROM nasabah WHERE id_nasabah = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idNasabah);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                catatLog(idNasabah, "HAPUS", " ID " + idNasabah + " Dihapus.");
            }
        }
    }

    private void catatLog(int idNasabah, String aksi, String deskripsi) {
        String sql = "INSERT INTO log_nasabah (id_nasabah, aksi, deskripsi) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idNasabah);
            stmt.setString(2, aksi);
            stmt.setString(3, deskripsi);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mencatat log nasabah!", e);
        }
    }

    public static DefaultTableModel getLogNasabah() {
        DefaultTableModel model = new DefaultTableModel();
        String query = "SELECT id_log, id_nasabah, aksi, deskripsi, waktu FROM log_nasabah";

        model.setColumnIdentifiers(new Object[]{"ID Log", "ID Nasabah", "Aksi", "Deskripsi", "Waktu"});

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_log"), 
                    rs.getInt("id_nasabah"), 
                    rs.getString("aksi"), 
                    rs.getString("deskripsi"), 
                    rs.getTimestamp("waktu")
                });
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal mengambil data transaksi dari database! " + e.getMessage(), e);
        }
        return model;
    }
}

