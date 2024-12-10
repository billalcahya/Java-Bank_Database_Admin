package com.tugasrancang.component;

import com.tugasrancang.models.Model_Card;
import com.tugasrancang.repository.TransaksiRepository;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

public class Card extends javax.swing.JPanel {

    private Color color1;
    private Color color2;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Card() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;

        IbTitle.setForeground(Color.WHITE);
        IbValue.setForeground(Color.WHITE);
        IbDescription.setForeground(Color.WHITE);
    }

    public void setData(Model_Card data) {
        IbIcon.setIcon(data.getIcon());
        IbTitle.setText(data.getTitle());
        IbValue.setText(data.getValues());
        IbDescription.setText(data.getDescription());
    }

    public void updateTotalUang() {
        SwingWorker<Double, Void> worker = new SwingWorker<>() {
            @Override
            protected Double doInBackground() {
                return TransaksiRepository.getTotalUang();
            }

            @Override
            protected void done() {
                try {
                    double totalUang = get(); 
                    IbValue.setText("Rp " + String.format("%,.2f", totalUang)); 
                } catch (InterruptedException | ExecutionException e) {
                    IbValue.setText("Error"); 
                }
            }
        };
        worker.execute(); 
    }
    
    public void updateTotalNasabah() {
    SwingWorker<Integer, Void> worker = new SwingWorker<>() {
        @Override
        protected Integer doInBackground() {
            return TransaksiRepository.getTotalNasabah(); 
        }

        @Override
        protected void done() {
            try {
                int totalNasabah = get(); 
                IbValue.setText(totalNasabah + " Nasabah"); 
            } catch (InterruptedException | ExecutionException e) {
                IbValue.setText("Error");
            }
        }
    };
    worker.execute(); 
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbIcon = new javax.swing.JLabel();
        IbTitle = new javax.swing.JLabel();
        IbValue = new javax.swing.JLabel();
        IbDescription = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(215, 150));

        IbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tugasrancang/icon/stock.png"))); // NOI18N

        IbTitle.setBackground(new java.awt.Color(255, 255, 255));
        IbTitle.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        IbTitle.setText("Total Uang");

        IbValue.setBackground(new java.awt.Color(255, 255, 255));
        IbValue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        IbValue.setText("Values");

        IbDescription.setBackground(new java.awt.Color(255, 255, 255));
        IbDescription.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        IbDescription.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IbIcon)
                    .addComponent(IbDescription)
                    .addComponent(IbTitle)
                    .addComponent(IbValue))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(IbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbDescription)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbDescription;
    private javax.swing.JLabel IbIcon;
    private javax.swing.JLabel IbTitle;
    private javax.swing.JLabel IbValue;
    // End of variables declaration//GEN-END:variables
}
