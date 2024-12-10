package com.tugasrancang.form;

import com.formdev.flatlaf.FlatLightLaf;
import com.tugasrancang.models.Admin;
import com.tugasrancang.repository.AdminDAO;
import com.tugasrancang.swing.ScrollBar;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BuatAdmin extends javax.swing.JPanel {

    private void tableRowClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow != -1) {
            String id = table1.getValueAt(selectedRow, 0).toString();
            String username = table1.getValueAt(selectedRow, 1).toString();
            String password = table1.getValueAt(selectedRow, 2).toString();

            ID.setText(id);
            Username.setText(username);
            Password.setText(password);
        }
    }

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

    private void loadAdminData() {
        table1.setModel(AdminDAO.getAdminData());
    }

    public BuatAdmin() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        initComponents();
        button2.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        button1.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        button3.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        restrictToNumbers(ID);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        loadAdminData();
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRowClicked(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new com.tugasrancang.swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        button1 = new com.tugasrancang.swing.Button();
        button2 = new com.tugasrancang.swing.Button();
        ID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        button3 = new com.tugasrancang.swing.Button();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.tugasrancang.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("Buat Akun Admin");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Silahkan Masukkan Username dan Password : ");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/user.png"))); // NOI18N
        jLabel3.setText("Username");

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/pin.png"))); // NOI18N
        jLabel4.setText("Password");

        button1.setBackground(new java.awt.Color(0, 153, 255));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Update");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(255, 0, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Delete");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        button3.setBackground(new java.awt.Color(0, 204, 51));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Create");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Username)
                    .addComponent(Password)
                    .addComponent(ID)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Daftar Admin");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Password", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 464, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
    }//GEN-LAST:event_UsernameActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            int id = Integer.parseInt(ID.getText()); 

            String username = Username.getText();
            String password = Password.getText();

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Harap isi semua kolom yang wajib.");
            }

            java.sql.Timestamp waktu = new java.sql.Timestamp(new Date().getTime());

            Admin admin = new Admin(
                    id, 
                    username,
                    password,
                    waktu);

            AdminDAO dao = new AdminDAO();
            dao.updateAdmin(admin);
            javax.swing.JOptionPane.showMessageDialog(this, "Admin berhasil diupdate!");
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        loadAdminData();

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        try {
            int id = Integer.parseInt(ID.getText());

            if (ID.getText().isEmpty()) {
                throw new IllegalArgumentException("Harap isi kolom ID.");
            }

            AdminDAO dao = new AdminDAO();
            dao.deleteAdmin(id);

            javax.swing.JOptionPane.showMessageDialog(this, "Admin berhasil dihapus!");

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException | IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        loadAdminData();

    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        try {
            String username = Username.getText();
            String password = Password.getText();

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Harap isi semua kolom yang wajib.");
            }

            java.sql.Timestamp waktu = new java.sql.Timestamp(new Date().getTime());

            Admin admin = new Admin(
                    0,
                    username,
                    password,
                    waktu);

            AdminDAO dao = new AdminDAO();
            dao.tambahAdmin(admin);
            javax.swing.JOptionPane.showMessageDialog(this, "Admin berhasil ditambah!");
        } catch (HeadlessException | IllegalArgumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        loadAdminData();
    }//GEN-LAST:event_button3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private com.tugasrancang.swing.Button button1;
    private com.tugasrancang.swing.Button button2;
    private com.tugasrancang.swing.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.tugasrancang.swing.PanelBorder panelBorder1;
    private com.tugasrancang.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
