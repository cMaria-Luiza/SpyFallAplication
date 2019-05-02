/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spyfallaplication;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Vanessa Pessoa
 */
    public class Cliente extends javax.swing.JFrame implements ActionListener , KeyListener  {
        private static final long serialVersionUID = 1L;
        private JTextArea texto;
        private JTextField txtMsg;
        private JButton btnSair;
        private JButton btnEnviar;
        private JLabel lblHistorico;
        private JLabel lblMsg;
        private JPanel pnlContent;
        private Socket socket;
        private OutputStream output;
        private Writer outwriter;
        private BufferedWriter bfwriter;
        private JTextField txtIP;
        private JTextField txtPorta;
        private JTextField txtNome;
        
        public Cliente(){
            initComponents();
            
        } 
        
        public void initComponents(){
            JLabel lblMensagem = new JLabel("Verificar");
            txtIP = new JTextField("127.0.0.1");
            txtPorta = new JTextField("12345");
            txtNome = new JTextField("Jogador");
            Object[] texts = {lblMensagem, txtIP, txtPorta, txtNome};
            JOptionPane.showMessageDialog(null, texts);
            pnlContent = new JPanel();
            texto = new JTextArea(10,20);
            texto.setEditable(false);
            texto.setBackground(new Color(240,240,240)); // mudar a cor 
            txtMsg = new JTextField(30);
            lblHistorico = new JLabel("Histórico");
            lblMsg = new JLabel("Mensagem");
            btnEnviar = new JButton("Enviar");
            btnSair = new JButton("Sair");
            btnSair.setToolTipText("Sair do jogo");
            btnEnviar.setToolTipText("Enviar mensagem");
            btnEnviar.addActionListener(this);
            btnSair.addActionListener(this);
            btnEnviar.addKeyListener(this);
            btnSair.addKeyListener(this);
            JScrollPane scroll = new JScrollPane(texto);
            texto.setLineWrap(true);
            pnlContent.add(lblHistorico);
            pnlContent.add(scroll);
            pnlContent.add(lblMsg);
            pnlContent.add(btnEnviar);
            pnlContent.add(btnSair);
            pnlContent.add(txtMsg);
            pnlContent.setBackground(new Color(227,73,71));
            texto.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.LIGHT_GRAY));
            txtMsg.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.LIGHT_GRAY));
            setTitle(txtNome.getText());
            setContentPane(pnlContent);
            setLocationRelativeTo(null);
            setResizable(false);
            setSize(250,300);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }
        
    /**
     *
     * @throws java.io.IOException
     */
    public void conectar() throws IOException{
        socket = new Socket("127.0.0.1", 12345);
        output = socket.getOutputStream();
        outwriter = new OutputStreamWriter(output);
        bfwriter = new BufferedWriter(outwriter);
        bfwriter.write(txtNome.getText());
        bfwriter.flush();
    }
    
    /**
     *
     * @param msg
     * @throws IOException
     */
    public void enviarMensagem(String msg) throws IOException {
        if(msg.equals("Sair")){
            bfwriter.write("Desconectado \r \n");
            bfwriter.append("Desconectado \r \n");
        }else{
            bfwriter.write(msg + "\r \n");
            bfwriter.append( txtNome.getText() + ":  " + msg + "\r \n");            
        }
        bfwriter.flush();
        txtMsg.setText("");
    }
    
    /**
     *
     * @throws IOException
     */
    public void escutar() throws IOException{
        InputStream input = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(input);
        BufferedReader bfr = new BufferedReader(inr);
        String msg = "";
        
        while(!"Sair".equalsIgnoreCase(msg)){
            if(bfr.ready()){
                msg = bfr.readLine();
            if(msg.equals("Sair"))
                texto.append("Servidor caiu! \r \n");
             else
                texto.append(msg + "\r \n");              
            }   
        }
    }
    
    public void sair() throws IOException{
        enviarMensagem("Sair");
        bfwriter.close();
        outwriter.close();
        output.close();
        socket.close();
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         
        Cliente app = new Cliente();
        app.conectar();
        app.escutar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getActionCommand().equals(btnEnviar.getActionCommand())){
                enviarMensagem(txtMsg.getText());
            } else if(e.getActionCommand().equals(btnSair.getActionCommand())){
                sair();
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                enviarMensagem(txtMsg.getText());
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
