package spyfallaplication;

public class Jogador {
    private String nome;
    private int ID;
    private Carta minhaCarta;
    private boolean ehEspiao;
    private int votos;
    
    
    public Jogador(String nome) {
       this.nome = nome;
       ehEspiao = false;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setCarta(Carta carta){
        this.minhaCarta = carta;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int id) {
        ID = id;
    }
    
    public Carta getCarta() {
        return minhaCarta;
    }
        
    public void tornarEspiao() {
        ehEspiao = true;
    }
    
    public boolean ehEspiao(){
        return ehEspiao;
    }
    
    public int getVotos() {
        return votos;
    }
    
    public void rebeberVoto() {
        votos++;
    }
}

