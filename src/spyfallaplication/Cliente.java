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
    private SpyFallAplication jogo;

    /*public Cliente(SpyFallAplication jogo){
          
    }*/
    
    /**
     * @param args the command line arguments
     */
    
    public  void conectar(){
        try {
            socket = new Socket("localhost", 12345);
        } catch (IOException ex) {
            Logger.getLogger(SpyFallAplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public static void main(String[] args) {
        //new Cliente();
        new Cliente().conectar();
        //new SpyFallAplication();
        Menu janelaPrincipal =  new Menu(new SpyFallAplication());
        janelaPrincipal.setVisible(true);  
        

    }
    
}
