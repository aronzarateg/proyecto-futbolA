

package Formularios;

import Clacess.Equipo;
import Modelo.JugadorDAO;
import Clacess.Jugador;
import Conexion.Conexion;
import Modelo.EquipoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FromJugador extends javax.swing.JInternalFrame {
    //DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    JugadorDAO jd = new JugadorDAO();  
    EquipoDAO eqd =  new EquipoDAO();
    int op;
    Conexion cx = new Conexion();
    Connection cn = cx.coneccion();
    ArrayList<Jugador> lista = new ArrayList();
    DefaultTableModel model = new DefaultTableModel();
//-----------------------------------------------------------------------
    DefaultComboBoxModel<Object> modelocombo = new DefaultComboBoxModel<>();
    ArrayList<Equipo>listaEquipo;
    public FromJugador() {
        initComponents();
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        inabilitar();
        this.jdFN.setEnabled(false);
        this.jdFN.getCalendarButton().setEnabled(true);
         setLocation(20, 90);
        listarJugador();
        //mostrarDatos("");
        this.cboequipo.removeAllItems();
        //filasCombo();
        txtCodigo.setEnabled(false);
        //mostrar("");
        cargarEquipo();
        
    }
    final void  cargarEquipo()
    {
        modelocombo.addElement("seleccionar Equipo");
        cboequipo.setModel(modelocombo);
        listaEquipo=eqd.listarEquipo();
        for(int i =0;i<listaEquipo.size();i++)
        {
            modelocombo.addElement(listaEquipo.get(i).getNombre());
        }
        cboequipo.setModel(modelocombo);
    }
    /*
    private String  accion="guardar";
    void  ocultar_columnas()
    {
        jtDatos.getColumnModel().getColumn(1).setMaxWidth(0);
        jtDatos.getColumnModel().getColumn(1).setMinWidth(0);
        jtDatos.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
     void mostrar(String buscar)
     {
         try {
             DefaultTableModel modelo;
             JugadorDAO j= new JugadorDAO();
             modelo= j.mostrar(buscar);
             jtDatos.setModel(modelo);
             ocultar_columnas();
             
         } catch (Exception e) {
             JOptionPane.showConfirmDialog(null,e);
         }
     }
       //-----------------------
    //MENTODOS
    //
//-------------------------------------------------
*//*
    void mostrarDatos(String valor)
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Equipo");
        model.addColumn("Nombre");
        model.addColumn("AP.Paterno");
        model.addColumn("AP.Materno");
        model.addColumn("Posicion");
        model.addColumn("Fec.Nacimiento");
        
       
        jtDatos.setModel(model);
        String sql ="";
        if(valor.equals(""))
        {
            sql="SELECT * FROM jugador";
        }
        else{
            sql="SELECT * FROM jugador WHERE Nombre='"+valor+"'";
        }
        String [] datos = new  String [7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                model.addRow(datos);
            }
            jtDatos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ^*/
    //---" SELECT  e.Nombre_equipo FROM  jugador j JOIN equipo e  ON  ( j.idEquipo = e.idEquipo)";
    //------------------------------------------------
    //          INSERTAR DATOS AL COMBOBOX
    //------------------------------------------------- 
    
    private void filasCombo()
    {
      try {
          //String sql="select * from equipo";
         // PreparedStatement pst= cn.prepareStatement(sql);
          Statement sent = cn.createStatement();
          ResultSet rs =sent.executeQuery("select * from equipo");
          while(rs.next())
          {
              this.cboequipo.addItem(rs.getString("Nombre_equipo"));
          }
          } catch (SQLException ex) {
          Logger.getLogger(FromJugador.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          }
         /* 
          void cargarCombo(){
   
            lista = jd.listarJugador();
            modelocombo.addElement("Seleccionar equipo");
            cboUsuarios.setModel(modelocombo);
            for(int i=0;i<lista.size();i++){
            modelocombo.addElement(lista.get(i).getUsuario());
            cboUsuarios.setModel(modelocombo);
        }
    
    
 }
          /*
          try {
          String sql="select * from equipo";
          PreparedStatement pst= cn.prepareStatement(sql);
          ResultSet rs =pst.executeQuery();
          
          while(rs.next())
          {
          String dato=rs.getString("Nombre_equipo");
          this.cboJugador.addItem(dato);
          }
          } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"");
          }
          */
      
     
    
    /*
      */ 
    
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
        txtPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaterno1 = new javax.swing.JTextField();
        jdFN = new com.toedter.calendar.JDateChooser();
        txtPoscision = new javax.swing.JTextField();
        txtidEquipo = new javax.swing.JTextField();
        cboequipo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("DATOS JUGADOR");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Jugador"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 160, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel4.setText("Codigo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 230, -1));

        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, 30));

        jLabel5.setText("Fecha  Nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel6.setText("Ap.Paterno:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        jLabel7.setText("Ap Materno:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel8.setText("Posicion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel9.setText("Equipo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtMaterno1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaterno1KeyTyped(evt);
            }
        });
        jPanel1.add(txtMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 230, 30));

        jdFN.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jdFN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 230, 30));
        jPanel1.add(txtPoscision, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 230, 30));

        txtidEquipo.setEnabled(false);
        jPanel1.add(txtidEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 60, 30));

        cboequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboequipoActionPerformed(evt);
            }
        });
        jPanel1.add(cboequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 460, 290));

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipo", "Nombre", "AP.Paterno", "AP.Paterno", "Posicion", "fecha Nacimiento"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 700, 180));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 380, -1));

        btnBuscar.setText("BUSCAR");
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 90, 80));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 80));

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 110, 80));

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 80));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 90, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 630, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        
        abilitar();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAgregar.setEnabled(true);
        //-------------------------
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtPaterno.setText(null);
        txtBuscar.setText(null);
        txtMaterno1.setText(null);
        cboequipo.setSelectedIndex(0); 
        txtPoscision.setText(null);
        jdFN.setDate(null);
        txtidEquipo.setText(null);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      int ideq = Integer.parseInt(txtidEquipo.getText());
        String nombre = txtNombre.getText();
        String paterno= txtPaterno.getText();
        String materno= txtMaterno1.getText();
        String fechaNa= ((JTextField)jdFN.getDateEditor().getUiComponent()).getText();
        String pocicion= txtPoscision.getText();
        int z = jd.registrarJugador(ideq, nombre, paterno,materno, fechaNa,pocicion);
        
        if(z>0){
             
            JOptionPane.showMessageDialog(this, "Exitoso");
            updateComponets();
            //listarEquipo();
            limpiar();
        }else{
        JOptionPane.showMessageDialog(this, "No se guardo");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            int fila = jtDatos.getSelectedRow();
        String cod="";
        cod=jtDatos.getValueAt(fila,0).toString();
        try {
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR a este jugador? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
           
            PreparedStatement pst= cn.prepareStatement("DELETE FROM jugador WHERE idJugador='"+cod+"'");
            pst.executeUpdate();
            updateComponets();
            limpiar();
            }else{
                        JOptionPane.showMessageDialog(null, "Jugador no ELIMINADO!");      
                    } 
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO: "+e);
        }
/*// TODO add your handling code here:
        if(!txtCodigo.getText().equals(""))
        {
            int confirmacion= JOptionPane.showConfirmDialog(rootPane, "estas seguro que desea aliminar el jugador");
            if(confirmacion==1)
            {
                JugadorDAO func= new JugadorDAO();
                Jugador dts= new Jugador();
                
                dts.setIdjugador(Integer.parseInt(txtCodigo.getText()));
                func.eliminar(dts);
                mostrar("");
                
            }
        }
        */
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jtDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDatosMouseClicked
        // TODO add your handling code here:
        int fila=jtDatos.rowAtPoint(evt.getPoint());
        txtCodigo.setText(jtDatos.getValueAt(fila,0).toString());
        //txtIdEquipo.setText(jtDatos.getValueAt(fila,1).toString());
        txtidEquipo.setText(jtDatos.getValueAt(fila,1).toString());
        txtNombre.setText(jtDatos.getValueAt(fila,2).toString());
        txtPaterno.setText(jtDatos.getValueAt(fila,3).toString());
        txtMaterno1.setText(jtDatos.getValueAt(fila,4).toString());
        txtPoscision.setText(jtDatos.getValueAt(fila,5).toString());
        jdFN.setDate(Date.valueOf(jtDatos.getValueAt(fila,6).toString()));
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        
    }//GEN-LAST:event_jtDatosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         int fil = jtDatos.getSelectedRow();
        if(fil<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Jugador a MODIFICAR!");
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea MODIFICAR Los datos? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                   int id = Integer.parseInt(txtCodigo.getText());
                   int idequipo= Integer.parseInt(txtidEquipo.getText());
                    String nombre = txtNombre.getText();
                    String paterno = txtPaterno.getText();//new String(txtclave.getPassword());
                    String materno= txtMaterno1.getText(); 
                    String fechafun= ((JTextField)jdFN.getDateEditor().getUiComponent()).getText() ;
                     String posicion = txtPoscision.getText();
                    int x = jd.modificarJugador(id,idequipo,nombre,paterno,materno,posicion,fechafun);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Jugador MODIFICADO!");
                        updateComponets();
                        limpiar();
                        btnEliminar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        btnAgregar.setEnabled(false);
                        inabilitar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Datos del Jugador no se ha MODIFICADO!");      
                    }                   
            }        
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cboequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboequipoActionPerformed
        // TODO add your handling code here:
         String equipo= cboequipo.getSelectedItem().toString();
        
        int id;
        int x= cboequipo.getSelectedIndex();
        if(x!=0)
        {
            id=eqd.retornarIDEquipo(equipo);
            txtidEquipo.setText(""+id);
        }
    }//GEN-LAST:event_cboequipoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
         char a=evt.getKeyChar();
        if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        // TODO add your handling code here:
         char a=evt.getKeyChar();
        if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaterno1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaterno1KeyTyped
        // TODO add your handling code here:
         char a=evt.getKeyChar();
        if((a<'a' || a>'z')&&(a<'A')|a>'Z')evt.consume();
    }//GEN-LAST:event_txtMaterno1KeyTyped

void listarJugador(){
    lista =jd.listarJugador();
    model = (DefaultTableModel) jtDatos.getModel();
        Object[] usu = new Object[7];
        for(int i=0;i<lista.size();i++){
            usu[0]=lista.get(i).getIdjugador();
            usu[1]=lista.get(i).getIdequipo();
            usu[2]=lista.get(i).getNombre();
            usu[3]=lista.get(i).getApellidop();
            usu[4]=lista.get(i).getApellidom();
            usu[5]=lista.get(i).getPosicion();
            usu[6]=lista.get(i).getFechanaci();
            model.addRow(usu);
               
        jtDatos.setModel(model);
        }
}
void limpiar(){
        txtCodigo.setText(null);
        txtBuscar.setText(null);
        txtMaterno1.setText(null);
        txtPaterno.setText(null);
        txtNombre.setText(null);
        txtPoscision.setText(null);
        cboequipo.setSelectedIndex(0);
        txtidEquipo.setText(null);
        }
void updateComponets(){
    LimpiarTabla(model);
    listarJugador();
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
    void inabilitar()
{
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPaterno.setEnabled(false);
        txtBuscar.setEnabled(false);
        txtMaterno1.setEnabled(false);
        cboequipo.setEnabled(false); 
         
      
        txtPoscision.setEnabled(false);
        
}
void abilitar()
{
    txtCodigo.setEnabled(false);
        txtNombre.setEnabled(true);
        txtPaterno.setEnabled(true);
        txtBuscar.setEnabled(true);
        txtMaterno1.setEnabled(true);
        cboequipo.setEnabled(true); 
        txtPoscision.setEnabled(true);
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboequipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFN;
    private javax.swing.JTable jtDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMaterno1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtPoscision;
    private javax.swing.JTextField txtidEquipo;
    // End of variables declaration//GEN-END:variables
}
