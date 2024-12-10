package com.tugasrancang.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Nasabah {

    private int idNasabah;
    private String namaLengkap;
    private Date tanggalLahir;
    private String nomorIdentitas;
    private String alamat;
    private String nomorTelepon;
    private String email;
    private String nomorRekening;
    private JenisAkun jenisAkun;
    private String saldo;
    private String pin;
    private Timestamp tanggalDibuat;

    public Nasabah(int idNasabah, String namaLengkap, Date tanggalLahir, String nomorIdentitas, String alamat, String nomorTelepon, String email, String nomorRekening, JenisAkun jenisAkun, String saldo, String pin, Timestamp tanggalDibuat) {
        this.idNasabah = idNasabah;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.nomorIdentitas = nomorIdentitas;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.nomorRekening = nomorRekening;
        this.jenisAkun = jenisAkun;
        this.saldo = saldo;
        this.pin = pin;
        this.tanggalDibuat = tanggalDibuat;
    }
    
    public Nasabah(int idNasabah, String namaLengkap, Date tanggalLahir, String nomorIdentitas, String alamat, String nomorTelepon, String email, String nomorRekening, JenisAkun jenisAkun, String pin, Timestamp tanggalDibuat) {
        this.idNasabah = idNasabah;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.nomorIdentitas = nomorIdentitas;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.nomorRekening = nomorRekening;
        this.jenisAkun = jenisAkun;
        this.pin = pin;
        this.tanggalDibuat = tanggalDibuat;
    }

    public enum JenisAkun {
        Simpedes, Britama, BritamaJunio
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void setNomorIdentitas(String nomorIdentitas) {
        this.nomorIdentitas = nomorIdentitas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public JenisAkun getJenisAkun() {
        return jenisAkun;
    }

    public void setJenisAkun(JenisAkun jenisAkun) {
        this.jenisAkun = jenisAkun;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Timestamp getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Timestamp tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }
}
