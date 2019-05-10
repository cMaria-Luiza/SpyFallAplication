package spyfallaplication;

import java.util.Random;

public class Sorteio implements Runnable {

    private int valor;
    private int limite;
    private final Random sort = new Random();

    public Sorteio(int limite) {
        this.limite = limite;
    }

    @Override
    public void run() {

        int numeroSorteado = sort.nextInt(limite);
        valor = numeroSorteado;
    }

    /**
     *
     * @return
     */
    public int getValor() {
        return valor;
    }

}
