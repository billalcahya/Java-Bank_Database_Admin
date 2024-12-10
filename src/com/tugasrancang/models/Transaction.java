
package com.tugasrancang.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Transaction extends Nasabah {
    
    private int idTransaksi;
    private JenisTransaksi jenisTransaksi;
    private BigDecimal jumlah;
    private Timestamp tanggalTransaksi;
    
    public enum JenisTransaksi {
        TRANSFER, SETOR, TARIK
    }

    public Transaction(int idNasabah, String namaLengkap, Date tanggalLahir, String nomorIdentitas, String alamat,
                     String nomorTelepon, String email, String nomorRekening, JenisAkun jenisAkun, String saldo, 
                     String pin, Timestamp tanggalDibuat, int idTransaksi, JenisTransaksi jenisTransaksi, 
                     BigDecimal jumlah, Timestamp tanggalTransaksi) {
                         
        super(idNasabah, namaLengkap, tanggalLahir, nomorIdentitas, alamat, nomorTelepon, email, nomorRekening, jenisAkun, saldo, pin, tanggalDibuat);
        
        this.idTransaksi = idTransaksi;
        this.jenisTransaksi = jenisTransaksi;
        this.jumlah = jumlah;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public JenisTransaksi getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(JenisTransaksi jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    public Timestamp getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Timestamp tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
}

