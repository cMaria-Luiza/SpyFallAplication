package SpyFallAplication;

public class Jogador {
    private String nome;
    private int ID;
    private Carta minhaCarta;
    private boolean ehEspiao;
    private int votos;
    
    
    public Jogador(String nome, int ID, Carta carta) {
        this.nome = nome;
        this.ID = ID;
        carta = minhaCarta;
        votos = 0;
        
        if (minhaCarta.getLugar() == null)
            ehEspiao = true;
        
    }
    
    public String getNome() {
        return nome;
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

