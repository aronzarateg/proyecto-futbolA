/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Conexion.Conexion;
import Modelo.CamponatoDAO;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Aron
 */
public class FrmCampeonatos extends javax.swing.JFrame {
Connection conex;
    int op;
    Conexion cx = new Conexion();
    Connection cn = cx.coneccion();
    CamponatoDAO  cd = new CamponatoDAO();
    public FrmCampeonatos() {
        initComponents();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnnAgregar.setEnabled(false);
        this.jdFI.setEnabled(false);
        this.jdFI.getCalendarButton().setEnabled(true);
        this.jdFF.setEnabled(false);
        this.jdFF.getCalendarButton().setEnabled(true);
        //this.jdBS.setEnabled(false);
        //this.jdBS.getCalendarButton().setEnabled(true);
        txtCodigo.setEditable(true);
        txtNombre.setEnabled(false);
        setLocationRelativeTo(null);
        mostrarDatos("");
    }

     void mostrarDatos(String valor)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fc.Inicio");
        modelo.addColumn("Fc.Final");
        jDatosCom.setModel(modelo);
        String sql ="";
        if(valor.equals(""))
        {
            sql="SELECT * FROM campeonato";
        }
        else{
            sql="SELECT * FROM campeonato WHERE Nombre_campeonato='"+valor+"'";
        }
        String [] datos = new  String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            jDatosCom.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jModificar = new javax.swing.JMenuItem();
        jEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jdFI = new com.toedter.calendar.JDateChooser();
        jdFF = new com.toedter.calendar.JDateChooser();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDatosCom = new javax.swing.JTable();
        btnnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblusuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jModificar.setText("MODIFICAR");
        jModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jModificar);

        jEliminar.setText("Eliminar");
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL CAMPEONATO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel3.setText("Fc.Inicio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel4.setText("Fc.Fin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 180, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 180, -1));

        jdFI.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdFI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, -1));

        jdFF.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, 220));

        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, -1, -1));

        jDatosCom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jDatosCom.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jDatosCom);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 550, 140));

        btnnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.jpg"))); // NOI18N
        btnnAgregar.setText("AGREGAR");
        btnnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, 60));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ELIMINAR.gif"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, -1, 60));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MODIFICAR.gif"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, 60));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SALIR.gif"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 90, 60));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NUEVO.gif"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 490, -1, 60));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BUSCAR.gif"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 90, 30));

        jButton2.setText("Mostar todos los datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 210, -1));
        getContentPane().add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 90, 20));

        jLabel5.setText("USUARIO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jButton1.setText("REPORTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 150, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        String usua= lblusuario.getText();
        MENU m = new MENU();
        m.setVisible(true);
        MENU.lblusuario.setText(""+usua);
        this.dispose();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnAgregarActionPerformed
        /*if(txtUsuario.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Deve ingresar un usuario");
            txtUsuario.requestFocus();
        }else if (txtContra.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Deve ingresar un Password");
            txtContra.requestFocus();
       }else{
        */
         String car= txtNombre.getText();
         if(!car.equals(""))//si es diferente de espacio que le exporte un mensaje.
       { 
        try {
            //int COD= Integer.parseInt(txtcod.getText());
            //int TOTAL= Integer.parseInt(txtc.getText());
            PreparedStatement pst = cn.prepareStatement("INSERT INTO  campeonato(Nombre_campeonato,Fecha_inicio,Fecha_fin) VALUES (?,?,?)");
           // pst.setString(1, txtcod.getText());
            pst.setString( 1 ,txtNombre.getText());//cboTP.getSelectedItem().toString());
            pst.setString( 2 , ((JTextField)jdFI.getDateEditor().getUiComponent()).getText()) ;
                                    //((JTextField)jdFN.getDateEditor().getUiComponent()).getText()   
            pst.setString( 3 ,((JTextField)jdFF.getDateEditor().getUiComponent()).getText()) ;
            pst.executeUpdate();
            mostrarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error"+e);
        }
         }else{
         JOptionPane.showMessageDialog(null,"ingrese El nombre del equipo Para continuar.","Error",JOptionPane.ERROR_MESSAGE);
           txtNombre.requestFocus();
         }
    
    }//GEN-LAST:event_btnnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        int fila = jDatosCom.getSelectedRow();
        
        String cod="";
        cod=jDatosCom.getValueAt(fila,0).toString();
        if(fila>=0)
        {
        try {
            PreparedStatement pst= cn.prepareStatement("DELETE FROM campeonato WHERE idCampeonato='"+cod+"'");
            pst.executeUpdate();
            mostrarDatos("");
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnnAgregar.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR  "+e);
        }
        }else
        {
            JOptionPane.showMessageDialog(null,"NO SELECCIONO FILA");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String FECFF=(((JTextField)jdFF.getDateEditor().getUiComponent()).getText());
        String FECFI=(((JTextField)jdFI.getDateEditor().getUiComponent()).getText());
        try {
            PreparedStatement pst= cn.prepareStatement("UPDATE campeonato  SET Nombre_campeonato='"+txtNombre.getText()+"',Fecha_inicio='"+FECFI+"',Fecha_fin='"+FECFF+"'WHERE idCampeonato='"+txtCodigo.getText()+"'");
            pst.executeUpdate();
            mostrarDatos("");
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnnAgregar.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActionPerformed
        btnModificar.setEnabled(true); 
        txtCodigo.setEnabled(false);
       // String FECFF=(((JTextField)jdFF.getDateEditor().getUiComponent()).setText());
        int fila= jDatosCom.getSelectedRow();
        if(fila>=0)
        {
            txtCodigo.setText(jDatosCom.getValueAt(fila,0).toString());
            txtNombre.setText(jDatosCom.getValueAt(fila,1).toString());
            jdFI.setDate(Date.valueOf(jDatosCom.getValueAt(fila,2).toString()));
             jdFF.setDate(Date.valueOf(jDatosCom.getValueAt(fila,3).toString()));
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"NO SELECCIONO FILA");
        }
    }//GEN-LAST:event_jModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrarDatos("");
        txtBuscar.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        AElegir ae= new AElegir();
        ae.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        txtBuscar.setText(null);
        txtCodigo.setText(null);
        txtNombre.setText(null);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnnAgregar.setEnabled(true);
        txtNombre.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        // TODO add your handling code here:
        btnModificar.setEnabled(true); 
        txtCodigo.setEnabled(false);
       // String FECFF=(((JTextField)jdFF.getDateEditor().getUiComponent()).setText());
        int fila= jDatosCom.getSelectedRow();
        if(fila>=0)
        {
            txtCodigo.setText(jDatosCom.getValueAt(fila,0).toString());
            txtNombre.setText(jDatosCom.getValueAt(fila,1).toString());
            jdFI.setDate(Date.valueOf(jDatosCom.getValueAt(fila,2).toString()));
             jdFF.setDate(Date.valueOf(jDatosCom.getValueAt(fila,3).toString()));
            btnEliminar.setEnabled(true);
            btnModificar.setEnabled(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"NO SELECCIONO FILA");
        }   
        
    }//GEN-LAST:event_jEliminarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        int key= evt.getKeyCode();
        if(key==KeyEvent.VK_ENTER)
        {
            if(!txtNombre.getText().equals("")){
                op = cd.verificarCampeonato(txtNombre.getText());
                if(op==1){
                    JOptionPane.showMessageDialog(null,"Campeonato EXISTE" );
                    txtNombre.setText(null);
                    txtNombre.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"Campeonato NO EXISTE" );
                    
                }
            }
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JasperReport jasperReport = null;
        conex = Conexion.coneccion();
        //String distrito = cbodistrito.getSelectedItem().toString();
        try{
            jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportess/report2.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conex);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
            
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, "JasperReport:"+ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCampeonatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnnAgregar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTable jDatosCom;
    private javax.swing.JMenuItem jEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFF;
    private com.toedter.calendar.JDateChooser jdFI;
    public static javax.swing.JLabel lblusuario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
