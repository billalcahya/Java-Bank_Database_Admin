package com.tugasrancang.component;

import java.awt.CardLayout;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.*;
import java.awt.event.*;
import com.tugasrancang.repository.NasabahTransaction;

public class TransaksiNasabah extends javax.swing.JPanel {


    private final NasabahTransaction nasabahTransaction = new NasabahTransaction();

    private void restrictToNumbers(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  
                }
            }
        });
    }

    public TransaksiNasabah() {
        FlatMacLightLaf.setup(); 
        initComponents();

        jPanel1.add(TransferUang, "TransferUang");
        jPanel1.add(SetorUang, "SetorUang");
        jPanel1.add(TarikUang, "TarikUang");

        restrictToNumbers(RekeningPengirim);
        restrictToNumbers(RekeningPenerima);
        restrictToNumbers(PinPengirim);
        restrictToNumbers(JumlahSaldo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        panelBorder1 = new com.tugasrancang.swing.PanelBorder();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TransferUang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RekeningPengirim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PinPengirim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JumlahSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Catatan = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        RekeningPenerima = new javax.swing.JTextField();
        Kirim = new com.tugasrancang.swing.Button();
        SetorUang = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        RekeningSetor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PinSetor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        UangSetor = new javax.swing.JTextField();
        button2 = new com.tugasrancang.swing.Button();
        TarikUang = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Rekening = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Pin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Uang = new javax.swing.JTextField();
        button3 = new com.tugasrancang.swing.Button();

        jLabel6.setText("jLabel6");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Transfer Uang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Setor Uang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Tarik Uang");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Transaksi Uang"));
        jPanel1.setLayout(new java.awt.CardLayout());

        TransferUang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Masukkan Rekening Pengirim*");

        jLabel2.setText("Konfirmasi Pin Pengirim*");

        jLabel3.setText("Jumlah Saldo yang Dikirim*");

        jLabel4.setText("Catatan");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setText("Masukkan Rekening Penerima*");

        Kirim.setBackground(new java.awt.Color(153, 102, 255));
        Kirim.setForeground(new java.awt.Color(255, 255, 255));
        Kirim.setText("Kirim");
        Kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KirimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransferUangLayout = new javax.swing.GroupLayout(TransferUang);
        TransferUang.setLayout(TransferUangLayout);
        TransferUangLayout.setHorizontalGroup(
            TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransferUangLayout.createSequentialGroup()
                .addGroup(TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TransferUangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Kirim, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TransferUangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(RekeningPenerima)
                            .addComponent(Catatan)
                            .addComponent(RekeningPengirim)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TransferUangLayout.createSequentialGroup()
                                .addGroup(TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JumlahSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(PinPengirim)))
                                .addGap(0, 296, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        TransferUangLayout.setVerticalGroup(
            TransferUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferUangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RekeningPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PinPengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JumlahSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Catatan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RekeningPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(Kirim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(TransferUang, "card2");

        SetorUang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Masukkan Rekening*");

        jLabel8.setText("Konfirmasi Pin*");

        jLabel9.setText("Jumlah Uang*");

        button2.setBackground(new java.awt.Color(153, 102, 255));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Setor");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SetorUangLayout = new javax.swing.GroupLayout(SetorUang);
        SetorUang.setLayout(SetorUangLayout);
        SetorUangLayout.setHorizontalGroup(
            SetorUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetorUangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SetorUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RekeningSetor)
                    .addGroup(SetorUangLayout.createSequentialGroup()
                        .addGroup(SetorUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(PinSetor, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(UangSetor))
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetorUangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        SetorUangLayout.setVerticalGroup(
            SetorUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetorUangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RekeningSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PinSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UangSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(SetorUang, "card3");

        TarikUang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Masukkan Rekening* ");

        jLabel11.setText("Konfirmasi Pin*");

        jLabel12.setText("Jumlah Uang*");

        button3.setBackground(new java.awt.Color(153, 102, 255));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Tarik");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TarikUangLayout = new javax.swing.GroupLayout(TarikUang);
        TarikUang.setLayout(TarikUangLayout);
        TarikUangLayout.setHorizontalGroup(
            TarikUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TarikUangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TarikUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rekening)
                    .addGroup(TarikUangLayout.createSequentialGroup()
                        .addGroup(TarikUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(Pin)
                            .addComponent(jLabel12)
                            .addComponent(Uang, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TarikUangLayout.createSequentialGroup()
                        .addGap(0, 405, Short.MAX_VALUE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        TarikUangLayout.setVerticalGroup(
            TarikUangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TarikUangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rekening, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Uang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(TarikUang, "card4");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        String rekening = RekeningSetor.getText();
        String pin = PinSetor.getText();
        String uang = UangSetor.getText();

        if (!nasabahTransaction.validateRekeningAndPin(rekening, pin)) {
            return; 
        }

        if (!uang.matches("\\d+")) {  
            JOptionPane.showMessageDialog(this, "Jumlah saldo harus berupa bilangan bulat positif!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int jumlahSaldo = Integer.parseInt(uang);
        
        nasabahTransaction.setorTunai(rekening, jumlahSaldo);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        String rekening = Rekening.getText();
        String pin = Pin.getText();
        String uang = Uang.getText();

        if (!nasabahTransaction.validateRekeningAndPin(rekening, pin)) {
            return;  
        }

        if (!uang.matches("\\d+")) { 
            JOptionPane.showMessageDialog(this, "Jumlah saldo harus berupa bilangan bulat positif!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int jumlahSaldo = Integer.parseInt(uang);

        nasabahTransaction.tarikTunai(rekening, jumlahSaldo);


    }//GEN-LAST:event_button3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout ly = (CardLayout) jPanel1.getLayout();
        ly.show(jPanel1, "TransferUang");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout ly = (CardLayout) jPanel1.getLayout();
        ly.show(jPanel1, "SetorUang");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout ly = (CardLayout) jPanel1.getLayout();
        ly.show(jPanel1, "TarikUang");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void KirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KirimActionPerformed

        String rekeningPengirim = RekeningPengirim.getText();
        String pinPengirim = PinPengirim.getText();
        String jumlahSaldoStr = JumlahSaldo.getText();
        String catatan = Catatan.getText();
        String rekeningPenerima = RekeningPenerima.getText();

        if (!nasabahTransaction.validateRekeningAndPin(rekeningPengirim, pinPengirim)) {
            return;  
        }

        if (!jumlahSaldoStr.matches("\\d+")) {  
            JOptionPane.showMessageDialog(this, "Jumlah saldo harus berupa bilangan bulat positif!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int jumlahSaldo = Integer.parseInt(jumlahSaldoStr);

        nasabahTransaction.transferUang(rekeningPengirim, rekeningPenerima, jumlahSaldo);

    }//GEN-LAST:event_KirimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Catatan;
    private javax.swing.JTextField JumlahSaldo;
    private com.tugasrancang.swing.Button Kirim;
    private javax.swing.JTextField Pin;
    private javax.swing.JTextField PinPengirim;
    private javax.swing.JTextField PinSetor;
    private javax.swing.JTextField Rekening;
    private javax.swing.JTextField RekeningPenerima;
    private javax.swing.JTextField RekeningPengirim;
    private javax.swing.JTextField RekeningSetor;
    private javax.swing.JPanel SetorUang;
    private javax.swing.JPanel TarikUang;
    private javax.swing.JPanel TransferUang;
    private javax.swing.JTextField Uang;
    private javax.swing.JTextField UangSetor;
    private com.tugasrancang.swing.Button button2;
    private com.tugasrancang.swing.Button button3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private com.tugasrancang.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
