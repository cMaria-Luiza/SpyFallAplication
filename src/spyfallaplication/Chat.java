package spyfallaplication;

<<<<<<< HEAD
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
=======
>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd
import javax.swing.JTextField;

/**
 *
<<<<<<< HEAD
 * @author Vanessa Pessoa
 */
    public class Chat extends javax.swing.JFrame implements ActionListener , KeyListener  {
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
        private Menu menu;
        
        public Chat(){
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
    
=======
 * @author Vanessa
 */
public class Chat extends javax.swing.JFrame {
    private Jogador jogador;
    
    public Chat() {
        initComponents();
     }

    /**
     *
     * @param jogador
     */
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        time = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        exibirMsg = new javax.swing.JTextPane();

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Pictures\\spy (1).png")); // NOI18N

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Pictures\\spy (1).png")); // NOI18N

        msg.setColumns(20);
        msg.setRows(5);
        jScrollPane1.setViewportView(msg);

        btnEnviar.setText("Enviar");

        jScrollPane3.setViewportView(exibirMsg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnEnviar))
                                .addComponent(jScrollPane1)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(54, 54, 54)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         
        Chat app = new Chat();
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

<<<<<<< HEAD
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                enviarMensagem(txtMsg.getText());
            } catch(IOException ex){
                ex.printStackTrace();
=======
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
           //   new Chat().setVisible(true);
                
             
              
>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd
            }
        }
        
    }
<<<<<<< HEAD

    @Override
    public void keyPressed(KeyEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
=======
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTextPane exibirMsg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea msg;
    private javax.swing.JProgressBar time;
    // End of variables declaration//GEN-END:variables
>>>>>>> b40082d8dbcb2a83f22825644b50bf8c90907cbd
}
