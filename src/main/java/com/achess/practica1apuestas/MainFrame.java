/*
 * Welcome
 */
package com.achess.practica1apuestas;

import com.achess.practica1apuestas.UI.PanelApuestas;
import com.achess.practica1apuestas.UI.PanelResultados;
import com.achess.practica1apuestas.betsLogic.Bets;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author achess
 */
public class MainFrame extends javax.swing.JFrame {

    private PanelApuestas apuestas;
    private PanelResultados resultados;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        customInit();
    }
    
    private void customInit(){
        this.setLocationRelativeTo(null);
        apuestas = new PanelApuestas();
        panelMenus.add(apuestas);
        resultados = new PanelResultados();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelNav = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelMenus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrera de caballos");
        setResizable(false);
        setSize(new java.awt.Dimension(771, 429));

        panelNav.setBackground(new java.awt.Color(31, 31, 35));
        panelNav.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(151, 123, 252));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Apuestas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(145, 12, 0, 12);
        panelNav.add(jButton1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(151, 123, 252));
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Resultados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 12);
        panelNav.add(jButton2, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(250, 66, 59));
        jButton3.setForeground(java.awt.Color.white);
        jButton3.setText("RESET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(108, 12, 12, 12);
        panelNav.add(jButton3, gridBagConstraints);

        getContentPane().add(panelNav, java.awt.BorderLayout.LINE_START);

        panelMenus.setBackground(new java.awt.Color(14, 14, 16));
        panelMenus.setMinimumSize(new java.awt.Dimension(675, 437));
        panelMenus.setPreferredSize(new java.awt.Dimension(675, 437));
        getContentPane().add(panelMenus, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        panelMenus.removeAll();        
        panelMenus.add(apuestas);
        SwingUtilities.updateComponentTreeUI(panelMenus);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        panelMenus.removeAll();        
        panelMenus.add(resultados);
        SwingUtilities.updateComponentTreeUI(panelMenus);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int value = JOptionPane.showConfirmDialog(this, "Los datos serán borrados\n¿Quiere continuar?", "Reset", JOptionPane.YES_NO_OPTION);
        if(value == 0){
            Bets.getBets().clear();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel panelMenus;
    private javax.swing.JPanel panelNav;
    // End of variables declaration//GEN-END:variables
}
