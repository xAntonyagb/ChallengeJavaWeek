package Jogo;

public class CartasEscolhidas extends javax.swing.JFrame {
    
    public static boolean start = false;
    
    public CartasEscolhidas() {
        initComponents();
        exibirCartas();
    }
    
    public static int[] cartas = new int[3];
    
    public void setCartas(int posicao, int cont){
        if(cont == 0){
            cartas[0] = posicao;
        }
        if(cont == 1){
            cartas[1] = posicao;
        }
        if(cont == 2){
            cartas[2] = posicao;
        }
    }
    
    public void exibirCartas(){
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + cartas[0] +".png")));
        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + cartas[1] +".png")));
        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + cartas[2] +".png")));
    }

    public boolean isStart() {
        return start;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        img2 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btBatalhar = new javax.swing.JButton();
        btEscolherDnv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Script MT Bold", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cartas escolhidas: ");

        btBatalhar.setText("Batalhar");
        btBatalhar.setMaximumSize(new java.awt.Dimension(75, 20));
        btBatalhar.setMinimumSize(new java.awt.Dimension(75, 20));
        btBatalhar.setPreferredSize(new java.awt.Dimension(75, 20));
        btBatalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalharActionPerformed(evt);
            }
        });

        btEscolherDnv.setText("Recomeçar");
        btEscolherDnv.setMaximumSize(new java.awt.Dimension(135, 20));
        btEscolherDnv.setMinimumSize(new java.awt.Dimension(135, 20));
        btEscolherDnv.setPreferredSize(new java.awt.Dimension(135, 20));
        btEscolherDnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEscolherDnvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btEscolherDnv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btBatalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEscolherDnv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBatalhar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEscolherDnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEscolherDnvActionPerformed
        setVisible(false);
        PainelCartas resetar = new PainelCartas();
        resetar.reset();
    }//GEN-LAST:event_btEscolherDnvActionPerformed

    private void btBatalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalharActionPerformed
        setVisible(false);
        start = true;
        new Batalha().setVisible(true); 
    }//GEN-LAST:event_btBatalharActionPerformed

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
            java.util.logging.Logger.getLogger(CartasEscolhidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartasEscolhidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartasEscolhidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartasEscolhidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartasEscolhidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatalhar;
    private javax.swing.JButton btEscolherDnv;
    javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
