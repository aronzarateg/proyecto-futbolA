/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;
//aron
import Clacess.Campeonato;
import Clacess.Equipo;
import Conexion.Conexion;
import Modelo.CamponatoDAO;
import Modelo.EquipoDAO;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aron
 */
public class FormEquipo extends javax.swing.JInternalFrame {
 DefaultTableModel model = new DefaultTableModel();
 ArrayList<Equipo> listaequipo = new ArrayList();
 EquipoDAO ed = new EquipoDAO();  
 CamponatoDAO cd=  new CamponatoDAO();
 int op;
 DefaultComboBoxModel<Object> modelocombo = new DefaultComboBoxModel<>();
    ArrayList<Campeonato>listacampeonato;
     DefaultTableModel modelo;
     //---------------------
     Conexion cx = new Conexion();
    Connection cn = cx.coneccion();
     //---------------------
 /**
     * Creates new form FormEquipo
     */
    public FormEquipo() {
        initComponents();
        
        setLocation(200, 10);
        listarEquipo();
        this.jFFundacion.setEnabled(false);
        this.jFFundacion.getCalendarButton().setEnabled(true);
        //botones al iniciar  bloqueados
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnBuscar.setEnabled(false);
        //txtBuscar.setEnabled(false);
        cargarCampeonato();
        inabilitar();
        //BuscarEquipo("");
        //buscar("");
    }
         final void  cargarCampeonato()
    {
        modelocombo.addElement("seleccionar campeonato");
        cboEquipo.setModel(modelocombo);
        listacampeonato=cd.listarCampeonatos();
        for(int i =0;i<listacampeonato.size();i++)
        {
            modelocombo.addElement(listacampeonato.get(i).getNombre());
        }
        cboEquipo.setModel(modelocombo);
    }
         
        
         //______________________________------------------------------------
       
         //---------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtN_Estadio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboEquipo = new javax.swing.JComboBox();
        txtCiudad = new javax.swing.JTextField();
        jFFundacion = new com.toedter.calendar.JDateChooser();
        txtidCampeonato = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EQUIPOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Equipo"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 160, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel4.setText("Codigo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 230, -1));

        txtN_Estadio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtN_EstadioKeyTyped(evt);
            }
        });
        jPanel1.add(txtN_Estadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 230, 30));

        jLabel5.setText("Fecha  Fundacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel6.setText("Nom_Estadio:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel8.setText("Ciudad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel9.setText("Campeonato:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        cboEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(cboEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 230, -1));

        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiudadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 230, 30));

        jFFundacion.setDateFormatString("yyyy-MM-dd\n");
        jPanel1.add(jFFundacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, -1));

        txtidCampeonato.setEnabled(false);
        jPanel1.add(txtidCampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 270));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 380, -1));

        btnBuscar.setText("BUSCAR");
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Funciones"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 90, 70));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 70));

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 110, 70));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 100, 70));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 90, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 580, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Equipos"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Campeonato", "Nombre", "Estadio", "Fecha Fundacion", "Ciudad"
            }
        ));
        jtDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtDatos);
        if (jtDatos.getColumnModel().getColumnCount() > 0) {
            jtDatos.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 640, 130));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 670, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        abilitar();
        txtNombre.requestFocus();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(true);
        txtCiudad.setText(null);
        txtCodigo.setText(null);
        txtN_Estadio.setText(null);
        txtNombre.setText(null);
        txtidCampeonato.setText(null);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       /* String car= txtNombre.getText();
         if(!car.equals(""))//si es diferente de espacio que le exporte un mensaje.
       {*/ if(txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Deve ingresar un NOmbre para continuar");
            txtNombre.requestFocus();
        }else if (txtN_Estadio.getText().equals("")){
        JOptionPane.showMessageDialog(null,"Deve ingresar el NOmbre del Estadio para continuar");
            txtN_Estadio.requestFocus();
       
       }else if (txtCiudad.getText().equals("")) {
           JOptionPane.showMessageDialog(null,"Deve ingresar el Nombre de la ciudad de origren del equipo");
            txtCiudad.requestFocus();
       }else if(cboEquipo.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(null,"Deve Elelir el campeonato en el cual participa");
            cboEquipo.requestFocus();
       }else{  
        int idc = Integer.parseInt(txtidCampeonato.getText());
        String nombre = txtNombre.getText();
        String estadio= txtN_Estadio.getText();
        String fechafun= ((JTextField)jFFundacion.getDateEditor().getUiComponent()).getText();
        String ciudad= txtCiudad.getText();
        int z = ed.registrarEquipo(idc, nombre, estadio, fechafun,ciudad);
        
        if(z>0){
             
            JOptionPane.showMessageDialog(this, "Exitoso");
            updateComponets();
            //listarEquipo();
            limpiar();
        }else{
        JOptionPane.showMessageDialog(this, "No se guardo");
        }
         /*}else{
         JOptionPane.showMessageDialog(null,"ingrese El nombre del equipo Para continuar.","Error",JOptionPane.ERROR_MESSAGE);
           txtNombre.requestFocus();
         }
        */
       }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyTyped
        // char a=evt.getKeyChar();
        //if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtCiudadKeyTyped

    private void jtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDatosMouseClicked
       int fila=jtDatos.rowAtPoint(evt.getPoint());
        txtCodigo.setText(jtDatos.getValueAt(fila,0).toString());
        //txtIdEquipo.setText(jtDatos.getValueAt(fila,1).toString());
        txtidCampeonato.setText(jtDatos.getValueAt(fila,1).toString());
        txtNombre.setText(jtDatos.getValueAt(fila,2).toString());
        txtN_Estadio.setText(jtDatos.getValueAt(fila,3).toString());
        jFFundacion.setDate(Date.valueOf(jtDatos.getValueAt(fila,4).toString()));
        txtCiudad.setText(jtDatos.getValueAt(fila,5).toString());
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnAgregar.setEnabled(false);
        
    }//GEN-LAST:event_jtDatosMouseClicked

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
         int key= evt.getKeyCode();
        if(key==KeyEvent.VK_ENTER)
        {
            if(!txtNombre.getText().equals("")){
                op = ed.verificarEquipo(txtNombre.getText());
                if(op==1){
                    JOptionPane.showMessageDialog(null,"ESTE EQUIPO YA  EXISTE" );
                    txtNombre.setText(null);
                    txtNombre.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"EQUIPO  NO EXISTE" );
                    txtN_Estadio.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void cboEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEquipoActionPerformed
        // TODO add your handling code here:
         String campeonato= cboEquipo.getSelectedItem().toString();
        
        int id;
        int x= cboEquipo.getSelectedIndex();
        if(x!=0)
        {
            id=cd.retornarIDcampeonato(campeonato);
            txtidCampeonato.setText(""+id);
        }
    }//GEN-LAST:event_cboEquipoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         int fil = jtDatos.getSelectedRow();
        if(fil<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Equipo a MODIFICAR!");
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea MODIFICAR el Equipo? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                   int id = Integer.parseInt(txtCodigo.getText());
                   int idcam= Integer.parseInt(txtidCampeonato.getText());
                    String nombre = txtNombre.getText();
                    String estadio = txtN_Estadio.getText();//new String(txtclave.getPassword());
                     String fechafun= ((JTextField)jFFundacion.getDateEditor().getUiComponent()).getText() ;
                     String ciudad = txtCiudad.getText();
                    int x = ed.modificarEquipo(id,idcam,nombre,estadio,fechafun,ciudad);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Equipo MODIFICADO!");
                        updateComponets();
                        limpiar();
                        btnEliminar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        btnAgregar.setEnabled(false);
                        inabilitar();
                    }else{
                        JOptionPane.showMessageDialog(null, "El Equipo no se ha MODIFICADO!");      
                    }                   
            }        
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jtDatos.getSelectedRow();
        String cod="";
        cod=jtDatos.getValueAt(fila,0).toString();
        try {
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR el  Equipo? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
           
            PreparedStatement pst= cn.prepareStatement("DELETE FROM equipo WHERE idEquipo='"+cod+"'");
            pst.executeUpdate();
            updateComponets();
            
            }else{
                        JOptionPane.showMessageDialog(null, "Equipo no ELIMINADO!");      
                    } 
            
            
        } catch (Exception e) {
        }
        /*int fila = jtDatos.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Equipo a ELIMINAR");            
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR el  Equipo? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                    int celda = (int) jtDatos.getValueAt(fila, 0);
                    int x = ed.eliminarEquipo(celda);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Equipo ELIMINADO!");
                        updateComponets();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Equipo no ELIMINADO!");      
                    }                   
            }
        }
                */
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        //char a=evt.getKeyChar();
        //if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtN_EstadioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtN_EstadioKeyTyped
        // TODO add your handling code here:
        //char a=evt.getKeyChar();
        //if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtN_EstadioKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String valor = txtBuscar.getText();
        ed.BuscarEquipo(valor);
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    void listarEquipo(){
    listaequipo =ed.listarEquipo();
    model = (DefaultTableModel) jtDatos.getModel();
        Object[] usu = new Object[6];
        for(int i=0;i<listaequipo.size();i++){
            usu[0]=listaequipo.get(i).getIdequipo();
            usu[1]=listaequipo.get(i).getCampeonato();
            usu[2]=listaequipo.get(i).getNombre();
            usu[3]=listaequipo.get(i).getEstadio();
            usu[4]=listaequipo.get(i).getFechafunda();
            usu[5]=listaequipo.get(i).getCiudad();
            //usu[6]=lista.get(i).getFechanaci();
            model.addRow(usu);
               
        jtDatos.setModel(model);
        } 
}void limpiar(){
        txtCodigo.setText(null);
        txtBuscar.setText(null);
        txtCiudad.setText(null);
        txtN_Estadio.setText(null);
        txtNombre.setText(null);
        txtidCampeonato.setText(null);
        cboEquipo.setSelectedIndex(0);
        
        }
void inabilitar()
{
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        txtN_Estadio.setEnabled(false);
        //txtBuscar.setEnabled(false);
        txtCiudad.setEnabled(false);
        cboEquipo.setEnabled(false); 
       /// jFFundacion.setEnabled(false);
}
void abilitar()
{
    txtCodigo.setEnabled(false);
        txtNombre.setEnabled(true);
        txtN_Estadio.setEnabled(true);
        //txtBuscar.setEnabled(true);
        txtCiudad.setEnabled(true);
        cboEquipo.setEnabled(true); 
        //jFFundacion.setEnabled(true);
}
void updateComponets(){
    LimpiarTabla(model);
    listarEquipo();
//    modelocombo.removeAllElements();
    //cargarCombo();
    //modelolista.clear();
    //cargarList();    
    }
    void LimpiarTabla(DefaultTableModel modelo){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){  
            modelo.removeRow(i);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboEquipo;
    private com.toedter.calendar.JDateChooser jFFundacion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtN_Estadio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtidCampeonato;
    // End of variables declaration//GEN-END:variables
}
