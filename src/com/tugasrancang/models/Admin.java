package com.tugasrancang.models;

import java.sql.Timestamp;

public class Admin {

    private int id;
    private String username;
    private String password;
    private Timestamp waktu;

    public Admin(int id, String username, String password, Timestamp waktu) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.waktu = waktu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Timestamp getWaktu(){
        return waktu;
    }
    
    public void setWaktu(Timestamp waktu){
        this.waktu = waktu;
    }
}
