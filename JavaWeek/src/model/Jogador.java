package model;
import java.util.ArrayList;
import model.Cartas;

public class Jogador {
    
    private String nickName;
    private ArrayList<Cartas> listaCartas = new ArrayList();

    public Jogador(String nickname){
        this.nickName = nickname;
    }

    public String getNickName(){
        return nickName;
    }

    public void serNickName(String nickName){
        this.nickName = nickName;
    }

    public ArrayList getListaCartas(){
        return listaCartas;
    }

    public void addCarta(Cartas novaCarta){
        listaCartas.add(novaCarta);
    }

    public String toString() {
        return "JogoCartas{" + "nickName: " + nickName + " | listaCartas: " + listaCartas + "}\n";
    }
    
}