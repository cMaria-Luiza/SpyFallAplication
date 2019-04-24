package spyfallaplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SpyFallAplication {

    private Menu menu;
    
    private static final int MAX_JOGADORES = 4;
    
    private ArrayList<Carta> cartas = new ArrayList<>(MAX_JOGADORES);
    private static ArrayList<Jogador> jogadores = new ArrayList<>(MAX_JOGADORES);
    private ArrayList<String> lugares = new ArrayList<String>(5);
    private int espiaoID;
    private static String lugarDaPartida;
    private static int lugarID;
    
    private final int HOSPITAL = 0;
    private final int RESTAURANTE = 1;
    private final int ESCOLA = 2;
    private final int CONCERTO_MUSICAL = 3;
    private final int PRACA = 4;
    
    public SpyFallAplication() {
        setLugares();
        
        
    }
    
    
    public void criarCartas() {
    
        
    }
    
    public static void darCartas() {
        // distribue as cartas para os jogadores
    }
    
    public void sorteios() {
        // sortear espiao
        Sort sorteio1 = new Sort(MAX_JOGADORES);
        sorteio1.start();
        espiaoID = sorteio1.getValor();
        
        // sortear lugar
        Sort sorteio2 = new Sort(5);
        sorteio2.start();
        lugarID = sorteio2.getValor();
    }
    
    public static void setJogadores(Jogador jogador){
        jogadores.add(jogador);
        System.out.println(jogadores.size());
    }
    
    private void setLugares() {
        lugares.add("Hospital");
        lugares.add("Restaurante");
        lugares.add("Escola");
        lugares.add("Concerto Musical");
        lugares.add("Praça");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Menu().setVisible(true);
    }

}
