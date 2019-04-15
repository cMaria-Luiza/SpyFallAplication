package spyfallaplication;


// IGNOREM ISSO AQUI EU TAVA NUM RACIOCIONIO E PERDI. DEPOIS AJEITO
import java.util.Random;
import java.util.ArrayList;

public class RandomTasksThread {
    private Random numeroAleatorio;
    private ArrayList<Object> lista;
    
    
    
    public void run(int limite) {
        int posicao = gerarNumeroAleatorio(limite);
        
    }
    
    public RandomTasksThread(ArrayList<Object> list){
        lista = list;    }
    
    public int gerarNumeroAleatorio(int limite) {
        return numeroAleatorio.nextInt(limite);
    }
    
    public static Object ganhadorDoSorteio(int posicao, ArrayList<Object> lista) {
        return lista.get(posicao);
    }
}
