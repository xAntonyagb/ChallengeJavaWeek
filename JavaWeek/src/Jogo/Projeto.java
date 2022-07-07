package Jogo;

import model.Cartas;
import model.Jogador;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class Projeto {
    private static ArrayList<Cartas> baralho = new ArrayList();
    private static ArrayList<Jogador> player = new ArrayList();

    public static void main(String[] args) {
        gerarCartas();
        nomeJogador();
        Deck_AI();
    }
    
    public static void gerarCartas() {
        baralho.add(new Cartas("carta branca", 8, 8, 8));
        baralho.add(new Cartas("The destroyer", 7, 7, 7));
        baralho.add(new Cartas("plantera", 6, 6, 6));
    }
    
    public static void Deck_AI(){
        Random r = new Random();
        int pos;
        player.add(new Jogador("computador"));
        
        for(int i=0;i<3;i++){
            pos = r.nextInt(3);
            player.get(1).addCarta(baralho.get(pos));
            System.out.println("A AI gerou a carta: " + baralho.get(pos));
        }
    }
    
    public static void nomeJogador(){
        player.add(new Jogador(
            JOptionPane.showInputDialog("Informe um nickname:"))
        );
        
        new PainelCartas().setVisible(true); 
    }
    
    public static void IniciarJogo(boolean pronto, int posicaoDaCarta, int cont){
        selecaoDeCartas(player.get(0), posicaoDaCarta, pronto, cont);
    }
    
    public static void selecaoDeCartas(Jogador jogador, int posicaoDaCarta, boolean pronto, int cont){
            jogador.addCarta(baralho.get(posicaoDaCarta));
            System.out.println("\nCarta adicionada ao deck: " + baralho.get(posicaoDaCarta));
            JOptionPane.showMessageDialog(null, "Carta adicionada!");

            if(pronto == true)
                new CartasEscolhidas().setVisible(true); 
    }
    
    public static int AI_MelhorAtributo(){
        ArrayList<Cartas> AI_deckCartas = player.get(1).getListaCartas();
        int forca=-999;
        int vida=-999;
        int defesa=-999;
        
        for(int i=0;i<3;i++){
                if(AI_deckCartas.get(i).getVida() > vida)
                    vida = (int) AI_deckCartas.get(i).getVida();
        }
        
        for(int i=0;i<3;i++){
                if(AI_deckCartas.get(i).getDefesa() > defesa){
                    defesa = (int) AI_deckCartas.get(i).getDefesa();
                }
        }
        
        for(int i=0;i<3;i++){
                if(AI_deckCartas.get(i).getForca() > forca){
                    forca = (int) AI_deckCartas.get(i).getForca();
                }
        }
        
        System.out.println("Melhor forca AI: "+forca);
        System.out.println("Melhor vida AI: "+vida);
        System.out.println("Melhor defesa AI: "+defesa);
        
        if(forca > vida){
            return 0;
        }else if(forca > defesa){
            return 0;
        }else if(vida > forca){
            return 1;
        }else if(vida > defesa){
            return 1;
        }else if(defesa > vida){
            return 2;
        }else{
            return 2;
        }
    }
     
    public static String vencedorRodada(int cartaEscolhida, String atributo){
        String vencedor;

        if(atributo == "vida"){
            vencedor = calculoVida(cartaEscolhida, escolhaAI(atributo));
        }else if(atributo == "defesa"){
            vencedor = calculoDefesa(cartaEscolhida, escolhaAI(atributo));
        }else{
            vencedor = calculoForca(cartaEscolhida, escolhaAI(atributo));
        }
        return vencedor;
    }
    
    public static int escolhaAI(String atributo){
        if(atributo == "vida"){
            System.out.println("\n\nAI esta escolhendo uma carta com vida alta...");
            return AI_EscolhaCartaDeVida();
        }else if(atributo == "defesa"){
            System.out.println("\n\nAI esta escolhendo uma carta com defesa alta...");
            return AI_EscolhaCartaDeDefesa();
        }else{
            System.out.println("\n\nAI esta escolhendo uma carta com forca alta...");
            return AI_EscolhaCartaDeForca();
        }
    }
    
    private static int AI_EscolhaCartaDeVida(){
        int melhorStats = -999;
        int melhorCarta=0;
        ArrayList<Cartas> AI_deckCartas = player.get(1).getListaCartas();
        System.out.println("Tamanho atual das cartas da AI: " + AI_deckCartas.size());
        
        for(int i=0;i<AI_deckCartas.size();i++){
                if(AI_deckCartas.get(i).getVida() > melhorStats){
                    melhorStats = (int) AI_deckCartas.get(i).getVida();
                    melhorCarta = i;
                    System.out.println("Todas as cartas do deck: "+ melhorCarta);
                }
        }
        System.out.println(AI_deckCartas.size());
        return melhorCarta;
    }
    
    private static int AI_EscolhaCartaDeDefesa(){
        int melhorStats = -999;
        int melhorCarta=0;
        ArrayList<Cartas> AI_deckCartas = player.get(1).getListaCartas();
        System.out.println("Tamanho atual das cartas da AI: " + AI_deckCartas.size());
        
        for(int i=0;i<AI_deckCartas.size();i++){
                if(AI_deckCartas.get(i).getDefesa() < melhorStats){
                    melhorStats = (int) AI_deckCartas.get(i).getDefesa();
                    melhorCarta = i;
                    System.out.println("Todas as cartas do deck: "+ melhorCarta);
                }
        }
        return melhorCarta;
    }
    
    private static int AI_EscolhaCartaDeForca(){
        int melhorStats = -999;
        int melhorCarta=0;
        ArrayList<Cartas> AI_deckCartas = player.get(1).getListaCartas();
        System.out.println("Tamanho atual das cartas da AI: " + AI_deckCartas.size());
        
        for(int i=0;i<AI_deckCartas.size();i++){
                if(AI_deckCartas.get(i).getForca() < melhorStats){
                    melhorStats = (int) AI_deckCartas.get(i).getForca();
                    melhorCarta = i;
                    System.out.println("Todas as cartas do deck: "+ melhorCarta);
                }
        }
        return melhorCarta;
    }
    
    private static String calculoVida(int cartaEscolhida, int cartaAI){
        ArrayList<Cartas> listaCartasJogadorUm = player.get(0).getListaCartas();
        ArrayList<Cartas> listaCartasJogadorDois = player.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(cartaAI).getVida() > listaCartasJogadorDois.get(cartaEscolhida).getVida()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(cartaAI).getVida() < listaCartasJogadorDois.get(cartaEscolhida).getVida()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }
            
    private static String calculoDefesa(int cartaEscolhida, int cartaAI){
        ArrayList<Cartas> listaCartasJogadorUm = player.get(0).getListaCartas();
        ArrayList<Cartas> listaCartasJogadorDois = player.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(cartaAI).getDefesa() > listaCartasJogadorDois.get(cartaEscolhida).getDefesa()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(cartaAI).getDefesa() < listaCartasJogadorDois.get(cartaEscolhida).getDefesa()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }
            
    private static String calculoForca(int cartaEscolhida, int cartaAI){
        ArrayList<Cartas> listaCartasJogadorUm = player.get(0).getListaCartas();
        ArrayList<Cartas> listaCartasJogadorDois = player.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(cartaAI).getForca() > listaCartasJogadorDois.get(cartaEscolhida).getForca()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(cartaAI).getForca() < listaCartasJogadorDois.get(cartaEscolhida).getForca()){
            removerCarta(player.get(0).getListaCartas(), cartaEscolhida);
            removerCarta(player.get(1).getListaCartas(), cartaAI);
            return player.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }    
    
    
    public static void removerCarta(ArrayList lista, int posicao){
        lista.remove(posicao);
    }
     
     public void limpar(){
         player.clear();
     }
}
