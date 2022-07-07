package model;

public class Cartas {
    private String nome;
    private double forca;
    private double defesa;
    private double vida;

    public Cartas(String nome, double forca, double defesa, double vida) {
        this.nome = nome;
        this.forca = forca;
        this.defesa = defesa;
        this.vida = vida;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getForca() {
        return forca;
    }

    public double getDefesa() {
        return defesa;
    }

    public double getVida() {
        return vida;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setForca(double forca) {
        this.forca = forca;
    }
    
    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }
    
    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public String toString() {
        return "\nCarta{Nome: "+ nome + " | Forca: " + forca + " | Defesa: " + defesa + " | Vida: " + vida + "}";
    }
}
