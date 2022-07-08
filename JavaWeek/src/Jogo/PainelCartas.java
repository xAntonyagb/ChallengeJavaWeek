package Jogo;

import java.util.Random;

    public class PainelCartas extends javax.swing.JFrame {

        int Random_Um;
        int Random_Dois;
        int Random_Tres;
        int posicao;
        int cont=0;
        boolean pronto = false;

        public PainelCartas() {
            initComponents();
            randomizar();
        }

        private void randomizar(){
            Random r = new Random();
            Random_Um = r.nextInt(15);
            Random_Dois = r.nextInt(15);
            Random_Tres = r.nextInt(15);

            btCarta_Um.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + Random_Um +".png")));
            btCarta_Dois.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + Random_Dois +".png")));
            btCarta_Tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + Random_Tres +".png")));
        }

        public int getRandom_Um() {
            return Random_Um;
        }

        public int getRandom_Dois() {
            return Random_Dois;
        }

        public int getRandom_Tres() {
            return Random_Tres;
        }

        public int getPoicao(){
            return posicao;
        }

        public void setPosicao(int posicao) {
            this.posicao = posicao;
        }

        public void reset(){
            this.cont = 0;
            randomizar();

            Projeto resetar = new Projeto();
            resetar.limpar();
            resetar.nomeJogador();
         }
        
        private void enviarEscolhidas(){
            CartasEscolhidas cartas = new CartasEscolhidas();
            cartas.setCartas(getPoicao(), cont);
        }

        private void funcaoBt(){
            enviarEscolhidas();
            
            cont = cont+1;
            if(cont == 3)
                pronto = true;
            
            Projeto starter = new Projeto();
            starter.IniciarJogo(pronto, getPoicao(), cont);

            randomizar();
            if(pronto == true){
                 setVisible(false);
            }
        }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCarta_Dois = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btCarta_Tres = new javax.swing.JButton();
        btCarta_Um = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 51, 51));

        btCarta_Dois.setBackground(new java.awt.Color(238, 238, 238));
        btCarta_Dois.setForeground(new java.awt.Color(0, 0, 0));
        btCarta_Dois.setBorder(null);
        btCarta_Dois.setBorderPainted(false);
        btCarta_Dois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarta_DoisActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Escolha dentre as cartas:");

        btCarta_Tres.setBackground(new java.awt.Color(238, 238, 238));
        btCarta_Tres.setBorder(null);
        btCarta_Tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarta_TresActionPerformed(evt);
            }
        });

        btCarta_Um.setBackground(new java.awt.Color(238, 238, 238));
        btCarta_Um.setForeground(java.awt.SystemColor.activeCaptionBorder);
        btCarta_Um.setBorder(null);
        btCarta_Um.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarta_UmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCarta_Um, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCarta_Dois, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCarta_Tres, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCarta_Dois, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCarta_Um, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCarta_Tres, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCarta_UmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarta_UmActionPerformed
        setPosicao(getRandom_Um());
        funcaoBt();
    }//GEN-LAST:event_btCarta_UmActionPerformed

    private void btCarta_DoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarta_DoisActionPerformed
        setPosicao(getRandom_Dois());
        funcaoBt();
    }//GEN-LAST:event_btCarta_DoisActionPerformed

    private void btCarta_TresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarta_TresActionPerformed
        setPosicao(getRandom_Tres());
        funcaoBt();
    }//GEN-LAST:event_btCarta_TresActionPerformed

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
            java.util.logging.Logger.getLogger(PainelCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelCartas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarta_Dois;
    private javax.swing.JButton btCarta_Tres;
    private javax.swing.JButton btCarta_Um;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
