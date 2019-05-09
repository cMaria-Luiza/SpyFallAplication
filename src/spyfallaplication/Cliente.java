package spyfallaplication;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanessa
 */
public class Cliente {
    private Socket socket;
<<<<<<< HEAD
    private SpyFallAplication jogo;

    /*public Cliente(SpyFallAplication jogo){
          
    }*/
    
    /**
     * @param args the command line arguments
     */
    
=======

>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd
    public  void conectar(){
        try {
            socket = new Socket("localhost", 12345);
        } catch (IOException ex) {
            Logger.getLogger(SpyFallAplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
<<<<<<< HEAD
    public static void main(String[] args) {
        //new Cliente();
        new Cliente().conectar();
        //new SpyFallAplication();
        Menu janelaPrincipal =  new Menu(new SpyFallAplication());
        janelaPrincipal.setVisible(true);  
        
=======
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Cliente jogo = new Cliente();
        jogo.conectar();
        SpyFallAplication spyFallAplication = new SpyFallAplication();
        Menu janelaPrincipal =  new Menu();
        janelaPrincipal.setVisible(true);   
>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd

    }
    
}
