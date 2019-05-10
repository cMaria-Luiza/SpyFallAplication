package spyfallaplication;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanessa
 */
public class Cliente implements Runnable{
    private Socket socket;
    private Cliente cliente;

 
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
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        //new SpyFallAplication();
       new Cliente().conectar();
        Menu janelaPrincipal =  new Menu();
        janelaPrincipal.setVisible(true);  
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
