/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Conexion.Conexion;
import Imagenes.ImgenFondoLogueo;
import Modelo.UsuarioDAO;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author Aron
 */
public class Logueo extends javax.swing.JFrame {
    int res=0;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql ;
    

//-------------------------------
     private Timer  tiempo;
      int cont;
  public final static int TWO_SECOND=5;
    //------------------------------------
    int op;
     UsuarioDAO ud= new UsuarioDAO();
    public Logueo() {
        initComponents();
        //jlogueodeskotpane.setBorder(   new ImgenFondoLogueo());
        txtUs.requestFocus();
        setLocationRelativeTo(null);
    }
     public void imagenDP(Graphics g){
        Dimension tam = getSize();
        ImageIcon fondo = new ImageIcon(new ImageIcon(getClass().getResource("")).getImage());
        g.drawImage(fondo.getImage(), 0, 0, tam.width,tam.height,null);
    }
    void acceder(String usuario,String clave)
    {
        sql="SELECT  * FROM  usuario WHERE  usuario='"+usuario+"' AND clave='"+clave+"'";
        try {
            cx = Conexion.coneccion(); 
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next())
            {
                res=1;
            }else{
                res=2;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        
        
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlogueodeskotpane = new javax.swing.JDesktopPane();
        btnIr = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        JPas = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtUs = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/crnMA.gif"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 310, 248));

        btnIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/forward.gif"))); // NOI18N
        btnIr.setText("IR");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USUARIO:");

        javax.swing.GroupLayout jlogueodeskotpaneLayout = new javax.swing.GroupLayout(jlogueodeskotpane);
        jlogueodeskotpane.setLayout(jlogueodeskotpaneLayout);
        jlogueodeskotpaneLayout.setHorizontalGroup(
            jlogueodeskotpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                .addGroup(jlogueodeskotpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3))
                    .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtUs, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4))
                    .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(JPas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnIr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jlogueodeskotpaneLayout.setVerticalGroup(
            jlogueodeskotpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlogueodeskotpaneLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(JPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jlogueodeskotpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIr, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jlogueodeskotpane.setLayer(btnIr, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlogueodeskotpane.setLayer(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlogueodeskotpane.setLayer(JPas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlogueodeskotpane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlogueodeskotpane.setLayer(txtUs, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlogueodeskotpane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jlogueodeskotpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
            String usuario=txtUs.getText();
            String c=new String (JPas.getPassword());
       // JOptionPane.showMessageDialog(null,"Datos :"+u+"/"+c);
        if(usuario.equals("")|c.equals(""))
        {
          JOptionPane.showMessageDialog(null,"DEVE INGRESAR SUS  DATOS ");
          txtUs.requestFocus();
        }else{
                op=ud.ValidarUsuario(usuario, c);
                if(op==1)
                {
                    // se va a abrir le otro formulario.
                    AElegir ae= new AElegir();
                    ae.setVisible(true);

                    setVisible(false);
                   AElegir.lblusuario.setText(""+usuario);
                }else{
                   JOptionPane.showMessageDialog(null,"USUARIO Y CLAVE INCORRECTO.","Error",JOptionPane.ERROR_MESSAGE);
                   txtUs.requestFocus();
                   txtUs.setText(null);
                   JPas.setText(null);
                }
        } 
    }//GEN-LAST:event_btnIrActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Portada p = new Portada();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
/*
     class TimerListener implements ActionListener{
       
        public void actionPerformed(ActionEvent e) 
        {
            cont++;
            Barra.setValue(cont);
            if(cont==100)
            {
                tiempo.stop();
                esconder();
                 Menu p= new Menu();
                p.setVisible(true);
                setVisible(false);
            }
        }
    }
     public void esconder(){this.setVisible(false);}
    public void activar(){tiempo.start();}
    
    public void inicioSecion()
    {
        String us=txtUs.getText();
        String pas= String.valueOf(JPas.getPassword());
        if(us.equals("aron")&& pas.compareTo("abc")==0)
        {
            Barra.setVisible(true);
            
            //LOGEO.setVisible(true);
            cont=-1;
            Barra.setValue(0);
            Barra.setStringPainted(true);
            tiempo= new Timer(TWO_SECOND,new TimerListener());
            activar();
            
            
            
            /*
            Principal p= new Principal();
            p.setVisible(true);
            this.dispose();//para que se cierre la ventana actual
            
        
       }
        else
        {
            JOptionPane.showMessageDialog(null,"ERROR al ingresar, verifique su usuario y password");
                JPas.setText(null);
                txtUs.setText(null);
                  txtUs.requestFocus();         
        }
    }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPas;
    private javax.swing.JButton btnIr;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JDesktopPane jlogueodeskotpane;
    private javax.swing.JTextField txtUs;
    // End of variables declaration//GEN-END:variables


}
