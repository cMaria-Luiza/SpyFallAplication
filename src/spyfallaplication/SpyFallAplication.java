package spyfallaplication;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SpyFallAplication {

    private Menu menu;
    
    private static final int MAX_JOGADORES = 2;
    private static final int NUM_LUGARES = 5;
    
    private static ArrayList<Jogador> jogadores = new ArrayList<>(MAX_JOGADORES);
    private ArrayList<String> lugares = new ArrayList<>(NUM_LUGARES);
    private int espiaoID;
    private static String lugarDaPartida;
    private static int lugarID;
    private static int jogadorID;
    private Jogador jogadorMaisVotado;
    private boolean espiaoGanhou;
    
    private final int HOSPITAL = 0;
    private final int RESTAURANTE = 1;
    private final int ESCOLA = 2;
    private final int CONCERTO_MUSICAL = 3;
    private final int PRACA = 4;
    
    public SpyFallAplication() {
            setLugares();
            for(int i = 0; i < 4; i++){
                new Menu(this).setVisible(true);
            }
            
    }
    
    public void sorteios() {
        
        // sortear espiao
        Sorteio sorteio1 = new Sorteio(MAX_JOGADORES);
        sorteio1.run();
        espiaoID = sorteio1.getValor();
        
        System.out.println("ID do espiao = " + espiaoID);
        
        // sortear lugar
        Sorteio sorteio2 = new Sorteio(NUM_LUGARES);
        sorteio2.run();
        lugarID = sorteio2.getValor();
        lugarDaPartida = lugares.get(lugarID);
        
        System.out.println(lugarDaPartida);
    }
    
    public int getEspiao(){
        return espiaoID;
    }
    
    public int getLugar(){
        return lugarID;
    }
    
    public static boolean salaCompleta() {
        System.out.println(jogadores.size());
        return jogadores.size() == MAX_JOGADORES;
    }
    
    public void setJogador(Jogador jogador){
        jogadores.add(jogador);
        jogador.setID(jogadores.size()-1);
        jogadorID = jogador.getID();
        System.out.println(jogadores.size());
    }
    
    public int jogadorID(){
        return jogadorID;
    }
    
    public int quantJogadoresOn() {
        return jogadores.size();
    }
    
    public Jogador getJogador(int posicao) {
        if(posicao > 3 || posicao < 0) 
            return null;
        
        return jogadores.get(posicao);
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
        
 
    }


}
