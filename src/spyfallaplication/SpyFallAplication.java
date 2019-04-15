package SpyFallAplication;

import java.util.ArrayList;
import java.util.List;

public class SpyFallAplication {

    private final int MAX_JOGADORES = 4;
    
    private ArrayList<Carta> cartas = new ArrayList<>(MAX_JOGADORES);
    private ArrayList<Jogador> jogadores = new ArrayList<>(MAX_JOGADORES);
    private List<List<String>> lugares = new ArrayList<>(5);
    private int espiaoID;
    
    private final int HOSPITAL = 0;
    private final int RESTAURANTE = 1;
    private final int ESCOLA = 2;
    private final int CONCERTO_MUSICAL = 3;
    private final int PARQUE = 4;
    
    public SpyFallAplication() {
        for(int i = 0; i < 5; i++)  
            lugares.add(new ArrayList<>(3));
            // lugares.get(0).add("foobar");
            
        
    }
    
    public void setLugares() {
        lugares.get(HOSPITAL).add("Médica");
        lugares.get(HOSPITAL).add("Paciente");
        lugares.get(HOSPITAL).add("Visitante");
        
        lugares.get(RESTAURANTE).add("Garçon");
        lugares.get(RESTAURANTE).add("Cliente");
        lugares.get(RESTAURANTE).add("Faxineiro");
        
        lugares.get(ESCOLA).add("Diretor");
        lugares.get(ESCOLA).add("Aluno");
        lugares.get(ESCOLA).add("Pai de aluno");
        
        lugares.get(CONCERTO_MUSICAL).add("Cantor");
        lugares.get(CONCERTO_MUSICAL).add("Fã");
        lugares.get(CONCERTO_MUSICAL).add("Empresário");
        
        lugares.get(PARQUE).add("Criança");
        lugares.get(PARQUE).add("Policial");
        lugares.get(PARQUE).add("Cachorro");

    }
    
    public void sortearLugar() {
        // sorteia lugar pela posicao na lista de lugares
    }
    
    public void criarCartas() {
        // inicializa as cartas, set o lugar sorteado e distribui as funcões entre as cartas 
    }
    
    public void darCartas() {
        // distribue as cartas para os jogadores
    }
    
    public void sortearEspiao(){
        // atraves da posicão da lista do jogador
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
