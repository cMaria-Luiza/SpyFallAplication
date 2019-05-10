package spyfallaplication;

public class Jogador {

    private String nome;
    private int ID;

    /**
     *
     * @param nome
     */
    public Jogador(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param id
     */
    public void setID(int id) {
        ID = id;
    }

}
