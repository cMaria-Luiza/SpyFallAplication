package spyfallaplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SpyFallAplication {

    private Menu menu;
    
    private static final int MAX_JOGADORES = 4;
    private static final int NUM_LUGARES = 5;
    
    private ArrayList<Carta> cartas = new ArrayList<>(MAX_JOGADORES);
    private static ArrayList<Jogador> jogadores = new ArrayList<>(MAX_JOGADORES);
    private ArrayList<String> lugares = new ArrayList<>(NUM_LUGARES);
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
        sorteios();
        
        
    }
    
    
    public void criarCartas() {
        // criar carta do espiao 
        Carta espiao = new Carta(null);
        cartas.add(espiao);
        
        // criar as demais cartas
        for(int i =0; i < MAX_JOGADORES-1; i++) {
            Carta carta = new Carta(lugarDaPartida);
        }
        
    }
    
    public void darCartas() {
        for (int i = 0; i < MAX_JOGADORES; i++) {
            Jogador jog = jogadores.get(i);
            if (jogadores.lastIndexOf(jog) == espiaoID) 
                jog.setCarta(cartas.get(0)); // a carta do espiao esta sempre na primeira posicao do arraylist
            else 
                jog.setCarta(cartas.get(i)); 
        }
        
        
    }
    
    public void sorteios() {
        // sortear espiao
        Sort sorteio1 = new Sort(MAX_JOGADORES);
        sorteio1.run();
        espiaoID = sorteio1.getValor();
        
        System.out.println("ID do espiao = " + espiaoID);
        
        // sortear lugar
        Sort sorteio2 = new Sort(NUM_LUGARES);
        sorteio2.run();
        lugarID = sorteio2.getValor();
        lugarDaPartida = lugares.get(lugarID);
        
        System.out.println(lugarDaPartida);
    }
    
    public static void setJogador(Jogador jogador){
        jogadores.add(jogador);
        jogador.setID(jogadores.size()-1);
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
        new Menu().setVisible(true);
    }

}
