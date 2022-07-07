package Jogo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Cartas;

public class Batalha extends javax.swing.JFrame {
    CartasEscolhidas deckCartas = new CartasEscolhidas();
    public static int[] R_cartdas = new int[3];
    
    Projeto main = new Projeto();
    int turno;
    
    public Batalha() {
        R_cartdas[0] = deckCartas.cartas[0];
        R_cartdas[1] = deckCartas.cartas[1];
        R_cartdas[2] = deckCartas.cartas[2];
                
        if(deckCartas.isStart() == true){
            initComponents();
            exibirCartas();

            Random r = new Random();
            this.turno = r.nextInt(2);
            definirTurno(turno);
        }
    }
    
    public void exibirCartas(){
        if(carta1 != null)
            carta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + R_cartdas[0] +".png")));
        if(carta2 != null)
            carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + R_cartdas[1] +".png")));
        if(carta3 != null)
            carta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + R_cartdas[2] +".png")));
        //img1.setIcon(null);
        //getContentPane().remove(teste);
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
    
     public void atualizarCartasJogador(int posicao){
         if(posicao == 1){
             R_cartdas[1] = R_cartdas[2];
         }else if(posicao == 0){
             R_cartdas[0] = R_cartdas[1];
             R_cartdas[1] = R_cartdas[2];
         }else
             cartas[3] = cartas[0];
         exibirCartas();
         getContentPane().repaint();
     }
     
     public void atualizarCartasAI(int posicao){
         if(posicao == 1){
             cartas[1] = cartas[2];
         }else if(posicao == 0){
             cartas[0] = cartas[1];
             cartas[1] = cartas[2];
         }
         getContentPane().repaint();
     }
     
    private void definirTurno(int turno){
        if(turno == 0){
            this.turno = 1;
            turnoJogador();
        }
        else{
            this.turno = 0;
            turnoAI();
        }
    }

    public int getTurno() {
        return turno;
    }
    
    
    private void turnoJogador(){
        String[] opcoes = new String[] {"Força", "Vida", "Defesa", "Desistir"};
        
        int escolha = JOptionPane.showOptionDialog(null, "Qual atributo quer escolher:", "É o seu turno!",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, opcoes, opcoes[0]);
        
        levarParaTeste(escolha);
    }
    
    
    
    private void turnoAI(){
        JOptionPane.showMessageDialog(null, "O turno é do adiversário!");
        int escolha = main.AI_MelhorAtributo();
        System.out.println("TURNO DA AI | Escolha da AI: "+escolha);
        levarParaTeste(escolha);
    }
    
        private void levarParaTeste(int entrada){
        String atributo="";
        
        if(entrada == 0){
            atributo = "forca";
            AtributoEscolhido.setForeground(new java.awt.Color(255, 204, 0));
        }
        else if(entrada == 1){
            atributo = "vida";
            AtributoEscolhido.setForeground(new java.awt.Color(204, 0, 0));
        }
        else if(entrada == 2){
            atributo = "defesa";
            AtributoEscolhido.setForeground(new java.awt.Color(0, 0, 204));
        }
        else{
            System.exit(0);
        }
        
        int cartaAI = cartas[main.escolhaAI(atributo)];
        
        AtributoEscolhido.setText(atributo);
        cartaPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/img" + cartaAI +".png")));
        getContentPane().repaint();
    }
        
        private void vitorias(String resultado){
            int PontosAI=0;
            int PontosJogador=0;
            ArrayList<Cartas> AI_deckCartas = main.player.get(1).getListaCartas();
            
            if(!(resultado.equals("empate") || resultado.equals("computador"))){
                PontosJogador += 1;
            }else if(resultado.equals("computador") || AI_deckCartas.size() == 0){
                PontosAI += 1;
            }else{
                PontosJogador += 1;
                PontosAI += 1;
                System.out.println("empate");
            }
            
            if(main.Tamanho_DeckJogador() == 0 || main.Tamanho_DeckAI() == 0){
                if(PontosJogador > PontosAI){
                    JOptionPane.showMessageDialog(null, resultado + " venceu o jogo!");
                }else if(PontosJogador < PontosAI){
                    JOptionPane.showMessageDialog(null, "Você perdeu! "+ resultado + " é o vencedor");
                }else{
                    JOptionPane.showMessageDialog(null, "empate, não houve ganhador!");
                }
                System.exit(0);
            }  
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1 = new javax.swing.JButton();
        carta2 = new javax.swing.JButton();
        carta3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        escritaCartaPC = new javax.swing.JLabel();
        cartaPC = new javax.swing.JLabel();
        EscritaAtributo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        escritaCartaPC1 = new javax.swing.JLabel();
        AtributoEscolhido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carta1.setText("jButton1");
        carta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta1ActionPerformed(evt);
            }
        });

        carta2.setText("jButton1");
        carta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta2ActionPerformed(evt);
            }
        });

        carta3.setText("jButton1");
        carta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta3ActionPerformed(evt);
            }
        });

        escritaCartaPC.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        escritaCartaPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        escritaCartaPC.setText("Carta do adversário:");

        cartaPC.setText("jLabel1");

        EscritaAtributo.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        EscritaAtributo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EscritaAtributo.setText("O atributo escolhido foi:");

        escritaCartaPC1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        escritaCartaPC1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        escritaCartaPC1.setText("Escolha uma de suas cartas:");

        AtributoEscolhido.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(escritaCartaPC, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EscritaAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AtributoEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(escritaCartaPC1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cartaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(escritaCartaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EscritaAtributo)
                            .addComponent(AtributoEscolhido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(escritaCartaPC1))
                    .addComponent(cartaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta1ActionPerformed
        getContentPane().remove(carta1);
        int cartaEscolhida = R_cartdas[0];
        String atributo = AtributoEscolhido.getText();
        String resultado = main.vencedorRodada(cartaEscolhida, atributo);
        if(resultado.equals("empate")){
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado);
        }else{
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado + " ganha essa rodada!");
        }
        getContentPane().repaint();
        vitorias(resultado);
        definirTurno(getTurno());
    }//GEN-LAST:event_carta1ActionPerformed

    private void carta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta2ActionPerformed
        getContentPane().remove(carta2);
        
        int cartaEscolhida = R_cartdas[1];
        String atributo = AtributoEscolhido.getText();
        String resultado = main.vencedorRodada(cartaEscolhida, atributo);
        if(resultado.equals("empate")){
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado);
        }else{
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado + " ganha essa rodada!");
        }
        getContentPane().repaint();
        definirTurno(getTurno());
    }//GEN-LAST:event_carta2ActionPerformed

    private void carta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta3ActionPerformed
        getContentPane().remove(carta3);
        
        int cartaEscolhida = R_cartdas[2];
        String atributo = AtributoEscolhido.getText();
        String resultado = main.vencedorRodada(cartaEscolhida, atributo);
        if(resultado.equals("empate")){
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado);
        }else{
            JOptionPane.showMessageDialog(null, "O resultado da rodada é: " + resultado + " ganha essa rodada!");
        }
        getContentPane().repaint();
        definirTurno(getTurno());
    }//GEN-LAST:event_carta3ActionPerformed

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
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batalha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AtributoEscolhido;
    private javax.swing.JLabel EscritaAtributo;
    private javax.swing.JButton carta1;
    private javax.swing.JButton carta2;
    private javax.swing.JButton carta3;
    private javax.swing.JLabel cartaPC;
    private javax.swing.JLabel escritaCartaPC;
    private javax.swing.JLabel escritaCartaPC1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
