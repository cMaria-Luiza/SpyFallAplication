package spyfallaplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import spyfallaplication.Menu;
import spyfallaplication.Jogador;
import spyfallaplication.Carta;

public class SpyFallAplication {

    Menu menu;
    
    private final int MAX_JOGADORES = 4;
    
    private ArrayList<Carta> cartas = new ArrayList<>(MAX_JOGADORES);
    private ArrayList<Jogador> jogadores = new ArrayList<>(MAX_JOGADORES);
    private List<List<String>> lugares = new ArrayList<>(5);
    private int espiaoID;
    private static String lugarDaPartida;
    private static int IDlugar;

    // private RandomTasksThread gerador;
    // private Server servidor;
    
    private final int HOSPITAL = 0;
    private final int RESTAURANTE = 1;
    private final int ESCOLA = 2;
    private final int CONCERTO_MUSICAL = 3;
    private final int PARQUE = 4;
    
    public SpyFallAplication() {
        // cria um arraylist de arraylists
        for(int i = 0; i < 5; i++)  
            lugares.add(new ArrayList<>(3));
            
        // inicializa o arraylist de lugares
        setLugares();
        sortearLugar();
        
            
        
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
        Random rand = new Random();
        int posicao = rand.nextInt(5);
        IDlugar = posicao;
        
        switch (posicao) {
            case HOSPITAL:
                lugarDaPartida = "Hospital";
                break;
            case RESTAURANTE:
                lugarDaPartida = "Restaurante";
                break;
            case ESCOLA:
                lugarDaPartida = "Escola";
                break;
            case CONCERTO_MUSICAL:
                lugarDaPartida = "Concerto Musical";
                break;
            case PARQUE:
                lugarDaPartida = "Parque";
                break;
        }
    }
    
    public void criarCartas() {
        Random rand = new Random();
        // cria as cartas 
        for(int i = 0; i < 3; i++) {
            Carta carta = new Carta();
            cartas.add(carta);
        }
        // adiciona o lugar
        cartas.forEach((c) -> {
            c.setLugar(lugarDaPartida);
        });
        // adiciona as funcoes
        cartas.forEach((c) -> {
            int n = rand.nextInt(3); // corre o risco de todos receber a mesma funcao VEERIFICAR ISSO!!!!!!
            c.setFuncao(lugares.get(IDlugar).get(n)); 
        });
        
    }
    
    public static void darCartas() {
        // distribue as cartas para os jogadores
    }
    
    public void sortearEspiao(){
        // atraves da posicão da lista do jogador
    }
    
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Menu().setVisible(true);
    }

}
