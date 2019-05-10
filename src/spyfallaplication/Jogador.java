package spyfallaplication;

public class Jogador {
    private String nome;
    private int ID;
    
    
    public Jogador(String nome) {
       this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int id) {
        ID = id;
    }
        
}
