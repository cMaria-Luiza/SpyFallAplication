
package spyfallaplication;

import java.util.Random;

public class Sort implements Runnable {
    private int valor;
    private int limite;
    private final Random sort = new Random();
    
    public Sort(int limite) {
        this.limite = limite;
    } 

    @Override
    public void run() {
        
        int numeroSorteado = sort.nextInt(limite);
        valor = numeroSorteado;
    }
    
    public int getValor() {
        return valor;
    }

    
    
    
    
    
    
    
}
