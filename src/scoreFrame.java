/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author archit
 */
public class scoreFrame extends javax.swing.JFrame {

    /**
     * Creates new form scoreFrame
     */
    public scoreFrame() {
        initComponents();
    }
    public int getAchooScore() {
        return Integer.parseInt(achooScore.getText());
    }
    public int getLoserScore() {
        return Integer.parseInt(loserScore.getText());
    }
    public void setAchooScore(int score) {
        achooScore.setText(Integer.toString(score));
    }
    public void setLoserScore(int score) {
        loserScore.setText(Integer.toString(score));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        achooLabel = new javax.swing.JLabel();
        loserLabel = new javax.swing.JLabel();
        achooScore = new javax.swing.JLabel();
        loserScore = new javax.swing.JLabel();
        colonLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setEnabled(false);
        setName("scoreFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        achooLabel.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        achooLabel.setText("Player1");

        loserLabel.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        loserLabel.setText("Player2");

        achooScore.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        achooScore.setText("0");

        loserScore.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        loserScore.setText("0");

        colonLabel.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        colonLabel.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(achooLabel)
                .addGap(57, 57, 57)
                .addComponent(loserLabel)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(achooScore)
                .addGap(89, 89, 89)
                .addComponent(colonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loserScore)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(achooLabel)
                    .addComponent(loserLabel))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(achooScore)
                    .addComponent(loserScore)
                    .addComponent(colonLabel))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scoreFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel achooLabel;
    private javax.swing.JLabel achooScore;
    private javax.swing.JLabel colonLabel;
    private javax.swing.JLabel loserLabel;
    private javax.swing.JLabel loserScore;
    // End of variables declaration//GEN-END:variables
}
