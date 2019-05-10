package spyfallaplication;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Vanessa Pessoa
 */
public class Servidor extends Thread {
     private static ServerSocket servidor;
     private static ArrayList<BufferedWriter> jogadores;
     private String nome;
     private Socket con;
     private InputStream input;
     private InputStreamReader inr;
     private BufferedReader bfr;
     
   public Servidor(Socket con){
         this.con = con;
         try{
             // cria um objeto BufferedReader() que aponta para o stream do cliente socket
             this.input = con.getInputStream();
             this.inr = new InputStreamReader(input);
             bfr = new BufferedReader(inr);

             
         } catch(IOException ex){
             ex.printStackTrace();
         }
     }
        
     /*
        Toda vez que um novo cliente acessar o servidor
        o metodo run() sera acionado e alocado numa thread.
        Tambem irá verificar se existe uma nova mensagem.
     */
     @Override
     public void run(){
   try{
             String mensagem;
             OutputStream output = this.con.getOutputStream();
             Writer ouw = new OutputStreamWriter(output);
             BufferedWriter bfw = new BufferedWriter(ouw);
             jogadores.add(bfw);
             nome = mensagem = bfr.readLine();
                          
             while(!"Sair".equalsIgnoreCase(mensagem)){
                 mensagem = bfr.readLine();
                 enviar(bfw, mensagem);
                 System.out.println(mensagem);
             }
         } catch(IOException ex){
             ex.printStackTrace();
         }
     }
     
      public void enviar (BufferedWriter saida, String msg){
         BufferedWriter bws;
         
         for(BufferedWriter bw : jogadores){
             bws = (BufferedWriter)bw;
             
             if(!(saida == bws)){
                 try {
                     bw.write(nome + ": " + msg + "\r \n");
                     bw.flush();
                 } catch (IOException ex) {
                     Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }   
     }
     
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       try{
          
           servidor = new ServerSocket(12345);
           jogadores = new ArrayList<BufferedWriter>();
          
          
           while(true){
               System.out.println("Aguardando conexão...");
                Socket socket = servidor.accept();
                Runnable processaJogador = new Cliente();
                Thread processo = new Thread(processaJogador);
                processo.start();
               System.out.println("Cliente Conectado...");               
           }
          
       } catch (HeadlessException | NumberFormatException | IOException ex){
           ex.printStackTrace();
       }
    }    
}
