package com.tugasrancang.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NasabahTransaction {

    public boolean validateRekeningAndPin(String rekening, String pin) {
        boolean isValid = false;
        try {
            try (Connection con = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM nasabah WHERE nomor_rekening = ? AND pin = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, rekening);
                ps.setString(2, pin);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    isValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor rekening atau PIN salah!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    private boolean cekSaldoCukup(String rekeningPengirim, double jumlah) {
        String query = "SELECT saldo FROM nasabah WHERE nomor_rekening = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, rekeningPengirim);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                return saldo >= jumlah;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public void transferUang(String rekeningPengirim, String rekeningPenerima, double jumlah) {
        if (rekeningPengirim.equals(rekeningPenerima)) {
            JOptionPane.showMessageDialog(null, "Rekening pengirim dan penerima tidak boleh sama!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cekSaldoCukup(rekeningPengirim, jumlah)) {
            JOptionPane.showMessageDialog(null, "Saldo tidak mencukupi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String updatePengirim = "UPDATE nasabah SET saldo = saldo - ? WHERE nomor_rekening = ?";
        String updatePenerima = "UPDATE nasabah SET saldo = saldo + ? WHERE nomor_rekening = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psPengirim = conn.prepareStatement(updatePengirim); PreparedStatement psPenerima = conn.prepareStatement(updatePenerima)) {

                psPengirim.setDouble(1, jumlah);
                psPengirim.setString(2, rekeningPengirim);
                psPengirim.executeUpdate();

                psPenerima.setDouble(1, jumlah);
                psPenerima.setString(2, rekeningPenerima);
                psPenerima.executeUpdate();

                conn.commit();

                catatTransaksi(getIdNasabahByRekening(rekeningPengirim), "TRANSFER", jumlah);

                JOptionPane.showMessageDialog(null, "Transfer berhasil!");
            } catch (SQLException e) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat transfer!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan koneksi database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tarikTunai(String rekeningPengirim, double jumlah) {
        if (jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah tarik tunai harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cekSaldoQuery = "SELECT saldo, id_nasabah FROM nasabah WHERE nomor_rekening = ?";
        String updatePengirimQuery = "UPDATE nasabah SET saldo = saldo - ? WHERE nomor_rekening = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psCekSaldo = conn.prepareStatement(cekSaldoQuery)) {
                psCekSaldo.setString(1, rekeningPengirim);
                ResultSet rs = psCekSaldo.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Rekening tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double saldoPengirim = rs.getDouble("saldo");
                int idNasabah = rs.getInt("id_nasabah");

                if (saldoPengirim < jumlah) {
                    JOptionPane.showMessageDialog(null, "Saldo tidak mencukupi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (PreparedStatement psUpdatePengirim = conn.prepareStatement(updatePengirimQuery)) {
                    psUpdatePengirim.setDouble(1, jumlah);
                    psUpdatePengirim.setString(2, rekeningPengirim);
                    int rowsAffected = psUpdatePengirim.executeUpdate();

                    if (rowsAffected > 0) {
                        conn.commit();
                        catatTransaksi(idNasabah, "TARIK", jumlah);
                        JOptionPane.showMessageDialog(null, "Tarik tunai berhasil!");
                    } else {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Tarik tunai gagal! Rekening tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat tarik tunai: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setorTunai(String rekeningPenerima, double jumlah) {
        if (jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah setor harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String cekRekeningQuery = "SELECT id_nasabah FROM nasabah WHERE nomor_rekening = ?";
        String updatePenerimaQuery = "UPDATE nasabah SET saldo = saldo + ? WHERE nomor_rekening = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psCek = conn.prepareStatement(cekRekeningQuery)) {
                psCek.setString(1, rekeningPenerima);
                ResultSet rs = psCek.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Rekening tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int idNasabah = rs.getInt("id_nasabah");

                try (PreparedStatement psPenerima = conn.prepareStatement(updatePenerimaQuery)) {
                    psPenerima.setDouble(1, jumlah);
                    psPenerima.setString(2, rekeningPenerima);
                    int rowsAffected = psPenerima.executeUpdate();

                    if (rowsAffected > 0) {
                        conn.commit();
                        catatTransaksi(idNasabah, "SETOR", jumlah);
                        JOptionPane.showMessageDialog(null, "Setor tunai berhasil!");
                    } else {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Setor tunai gagal! Rekening tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Kesalahan saat setor tunai: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void catatTransaksi(int idNasabah, String jenisTransaksi, double jumlah) {
        String query = "INSERT INTO transaksi (id_nasabah, jenis_transaksi, jumlah) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, idNasabah);
            ps.setString(2, jenisTransaksi);
            ps.setBigDecimal(3, BigDecimal.valueOf(jumlah));  // Konversi ke BigDecimal

            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mencatat transaksi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getIdNasabahByRekening(String rekening) {
        String query = "SELECT id_nasabah FROM nasabah WHERE nomor_rekening = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, rekening);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_nasabah");
            }
        } catch (SQLException e) {
        }
        throw new RuntimeException("Nasabah tidak ditemukan!");
    }

}
