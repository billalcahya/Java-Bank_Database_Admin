package com.tugasrancang.component;

import com.toedter.calendar.JDateChooser;
import com.tugasrancang.models.Nasabah;
import com.tugasrancang.models.Nasabah.JenisAkun;
import com.tugasrancang.repository.NasabahDAO;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Form_Edit extends javax.swing.JPanel {

    private JComboBox<JenisAkun> cmbJenisAkun;
    private JDateChooser TanggalLahir;
    private JButton btnTambah;

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

    public Form_Edit() {
        initComponents();
        button2.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        button3.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        restrictToNumbers(NomorIdentitas);
        restrictToNumbers(NomorTelephone);
        restrictToNumbers(NomorRekening);
        restrictToNumbers(Pin);
        restrictToNumbers(Id);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Tanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NomorIdentitas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Alamat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NomorTelephone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        NomorRekening = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JenisAkun = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Pin = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        panel = new javax.swing.JLayeredPane();
        button3 = new com.tugasrancang.swing.Button();
        button2 = new com.tugasrancang.swing.Button();
        NamaLengkap1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(242, 242, 242));

        jLabel1.setText("Nama ");

        Id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/user.png"))); // NOI18N

        jLabel2.setText("Tanggal Lahir");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/tanggal.png"))); // NOI18N

        jLabel5.setText("Nomor Identitas");

        NomorIdentitas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        NomorIdentitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorIdentitasActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/nomor_identitas.png"))); // NOI18N

        jLabel7.setText("Alamat (Kota)");

        Alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/alamat.png"))); // NOI18N

        jLabel8.setText("Nomor Telepon");

        NomorTelephone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/telepon.png"))); // NOI18N

        jLabel11.setText("Email");

        Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/email.png"))); // NOI18N

        jLabel13.setText("Nomor Rekening");

        NomorRekening.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/nomor_rekening.png"))); // NOI18N

        jLabel14.setText("Jenis Akun");

        JenisAkun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simpedes", "Britama", "BritamaJunio" }));
        JenisAkun.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/jenis_akun.png"))); // NOI18N

        jLabel18.setText("Pin");

        Pin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/pin.png"))); // NOI18N

        panel.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        button3.setBackground(new java.awt.Color(0, 153, 255));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Update");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel.add(button3);

        button2.setBackground(new java.awt.Color(255, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Delete");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panel.add(button2);

        NamaLengkap1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        NamaLengkap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaLengkap1ActionPerformed(evt);
            }
        });

        jLabel21.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(Pin)
                            .addComponent(JenisAkun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NomorRekening)
                            .addComponent(Email)
                            .addComponent(NomorTelephone)
                            .addComponent(Alamat)
                            .addComponent(NomorIdentitas)
                            .addComponent(Tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaLengkap1)
                            .addComponent(Id)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NamaLengkap1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomorIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomorTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomorRekening, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JenisAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
    }//GEN-LAST:event_IdActionPerformed

    private void NomorIdentitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorIdentitasActionPerformed
    }//GEN-LAST:event_NomorIdentitasActionPerformed

    private void AlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatActionPerformed
    }//GEN-LAST:event_AlamatActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        try {
            String idStr = Id.getText();

            if (idStr.isEmpty()) {
                throw new IllegalArgumentException("ID Nasabah harus diisi.");
            }

            int idNasabah = Integer.parseInt(idStr);

            NasabahDAO dao = new NasabahDAO();
            dao.deleteNasabah(idNasabah);

            javax.swing.JOptionPane.showMessageDialog(this, "Nasabah berhasil dihapus!");
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID Nasabah harus berupa angka.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | IllegalArgumentException | SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        Date selectedDate = Tanggal.getDate();

        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(selectedDate);

            System.out.println("Tanggal Lahir yang diformat: " + formattedDate);
        } else {
            System.out.println("Tanggal Lahir tidak dipilih.");
        }

        try {
            String idStr = Id.getText();
            if (idStr.isEmpty()) {
                throw new IllegalArgumentException("ID Nasabah harus diisi.");
            }
            int id = Integer.parseInt(idStr);
            String namaLengkap = NamaLengkap1.getText();
            String nomorIdentitas = NomorIdentitas.getText();
            String alamat = Alamat.getText();
            String telepon = NomorTelephone.getText();
            String email = Email.getText();
            String rekening = NomorRekening.getText();
            String jenisAkun = (String) JenisAkun.getSelectedItem();
            String pin = Pin.getText();

            if (namaLengkap.isEmpty() || nomorIdentitas.isEmpty()) {
                throw new IllegalArgumentException("Harap isi semua kolom yang wajib.");
            }

            java.sql.Date tanggalLahir = selectedDate != null ? new java.sql.Date(selectedDate.getTime()) : null;
            java.sql.Timestamp tanggalDibuat = new java.sql.Timestamp(new Date().getTime());

            Nasabah nasabah = new Nasabah(
                    id,
                    namaLengkap,
                    tanggalLahir,
                    nomorIdentitas,
                    alamat,
                    telepon,
                    email,
                    rekening,
                    Nasabah.JenisAkun.valueOf(jenisAkun),
                    pin,
                    tanggalDibuat
            );

            NasabahDAO dao = new NasabahDAO();
            dao.updateNasabah(nasabah);

            javax.swing.JOptionPane.showMessageDialog(this, "Nasabah berhasil disimpan!");
        } catch (HeadlessException | IllegalArgumentException | SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void NamaLengkap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaLengkap1ActionPerformed
    }//GEN-LAST:event_NamaLengkap1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Id;
    private javax.swing.JComboBox<String> JenisAkun;
    private javax.swing.JTextField NamaLengkap1;
    private javax.swing.JTextField NomorIdentitas;
    private javax.swing.JTextField NomorRekening;
    private javax.swing.JTextField NomorTelephone;
    private javax.swing.JTextField Pin;
    private com.toedter.calendar.JDateChooser Tanggal;
    private com.tugasrancang.swing.Button button2;
    private com.tugasrancang.swing.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLayeredPane panel;
    // End of variables declaration//GEN-END:variables
}
