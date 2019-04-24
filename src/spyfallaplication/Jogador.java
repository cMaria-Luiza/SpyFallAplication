package spyfallaplication;

public class Jogador {
    private String nome;
    private int ID;
    private Carta minhaCarta;
    private boolean ehEspiao;
    private int votos;
    
    
    public Jogador(String nome) {
        this.nome = nome;
        
        //this.ID = ID;
        //minhaCarta = carta;
        /*votos = 0;
        
        if (minhaCarta.getLugar() == null)
            ehEspiao = true; */
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
    
    public Carta getCarta() {
        return minhaCarta;
    }
        
    public boolean JogadorEspiao() {
        return ehEspiao;
    }
    
    public int getVotos() {
        return votos;
    }
    
    public void rebeberVoto() {
        votos++;
    }
}

