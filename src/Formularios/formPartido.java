/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clacess.Campeonato;
import Clacess.Equipo;
import Clacess.Partido;
import Clacess.Presidente;
import Conexion.Conexion;
import Modelo.CamponatoDAO;
import Modelo.EquipoDAO;
import Modelo.PartidoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aron
 */
public class formPartido extends javax.swing.JInternalFrame {
DefaultComboBoxModel<Object> modelocombo = new DefaultComboBoxModel<>();
     DefaultComboBoxModel<Object> modelo = new DefaultComboBoxModel<>();
    DefaultTableModel model = new DefaultTableModel(); 
    PartidoDAO part= new PartidoDAO();
      int op;
    Conexion cx = new Conexion();
    ArrayList<Partido> listaPartido = new ArrayList(); 
    ArrayList<Equipo>listaEquipo;
    ArrayList<Campeonato> listaCampeoanto;
    ArrayList<Presidente> listaPresidente = new ArrayList(); 
      EquipoDAO equipo = new EquipoDAO();
      CamponatoDAO camp= new CamponatoDAO();
    Connection cn = cx.coneccion();
    public formPartido() {
        initComponents();
        cargarEquipo();
        cargarCampeonato();
        listarPresidente();
        setLocation(200, 20);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        inabilitar();
        
        this.jFP.setEnabled(false);
        this.jFP.getCalendarButton().setEnabled(true);
        txtGC .setDocument(new LimiteJTextField(2));
        txtGV .setDocument(new LimiteJTextField(2));
    }
    final void  cargarEquipo()
    {
        modelocombo.addElement("selc. Equipo");
        cboEquipo.setModel(modelocombo);
        listaEquipo=equipo.listarEquipo();
        for(int i =0;i<listaEquipo.size();i++)
        {
            modelocombo.addElement(listaEquipo.get(i).getNombre());
        }
        cboEquipo.setModel(modelocombo);
    }
     final void  cargarCampeonato()
    {
        modelo.addElement("selc. campeonato");
        cboCampeonato.setModel(modelo);
        listaCampeoanto=camp.listarCampeonatos();
        for(int i =0;i<listaCampeoanto.size();i++)
        {
            modelo.addElement(listaCampeoanto.get(i).getNombre());
        }
        cboCampeonato.setModel(modelo);
    }
   /* void mostrarDatos(String valor)
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("EQUIPO");
        modelo.addColumn("Campeonato");
        modelo.addColumn("Gol_Casa");
        modelo.addColumn("Gol_Visita");
        modelo.addColumn("Fecha Partido");
        //modelo.addColumn("Fecha Nacimiento");
        
       
        jDPartido.setModel(modelo);
        String sql ="";
        if(valor.equals(""))
        {
            sql="SELECT * FROM partido";
        }
        else{
            sql="SELECT * FROM partido WHERE idEquipo='"+valor+"'";
        }
        String [] datos = new  String [6];
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
                //datos[6]=rs.getString(7);
                modelo.addRow(datos);
            }
            jDPartido.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR:"+e);
        }
    }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        cboEquipo = new javax.swing.JComboBox();
        cboCampeonato = new javax.swing.JComboBox();
        txtIDcampeonato = new javax.swing.JTextField();
        txtIDequipo = new javax.swing.JTextField();
        jFP = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGV = new javax.swing.JTextField();
        txtGC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDPartido = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE PARTIDO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("CODIGO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel4.setText("Equipo Casa :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel7.setText("CAMPEONATO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtCod.setEnabled(false);
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 110, 30));

        cboEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(cboEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, -1));

        cboCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCampeonatoActionPerformed(evt);
            }
        });
        jPanel1.add(cboCampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 160, -1));

        txtIDcampeonato.setEnabled(false);
        jPanel1.add(txtIDcampeonato, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 70, -1));

        txtIDequipo.setEnabled(false);
        jPanel1.add(txtIDequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 70, -1));

        jFP.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jFP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 160, -1));

        jLabel5.setText("Fecha_Partido:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel3.setText("Gol_Visita:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        txtGV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGVKeyTyped(evt);
            }
        });
        jPanel1.add(txtGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, -1));

        txtGC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGCKeyTyped(evt);
            }
        });
        jPanel1.add(txtGC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, -1));

        jLabel6.setText("Gol_Casa:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 450, 260));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 80, 70));

        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 70, 70));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 70));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 70));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 500, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Partido"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDPartido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "EQUIPO", "CAMPEONATO", "GOL_CASA", "GOL_VISITA", "FECHA_PARTIDO"
            }
        ));
        jDPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDPartidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jDPartido);
        if (jDPartido.getColumnModel().getColumnCount() > 0) {
            jDPartido.getColumnModel().getColumn(0).setMinWidth(40);
            jDPartido.getColumnModel().getColumn(0).setMaxWidth(30);
            jDPartido.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 550, 150));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 580, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtGCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGCKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
    }//GEN-LAST:event_txtGCKeyTyped

    private void txtGVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGVKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
    }//GEN-LAST:event_txtGVKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        abilitar();
        limpiar();
        btnAgregar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEquipoActionPerformed
        // TODO add your handling code here:
        String equipoa= cboEquipo.getSelectedItem().toString();
        
        int id;
        int x= cboEquipo.getSelectedIndex();
        if(x!=0)
        {
            id=equipo.retornarIDEquipo(equipoa);
            txtIDequipo.setText(""+id);
        }
    }//GEN-LAST:event_cboEquipoActionPerformed

    private void cboCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCampeonatoActionPerformed
        // TODO add your handling code here:
        String equipoa= cboCampeonato.getSelectedItem().toString();
        
        int id;
        int x= cboCampeonato.getSelectedIndex();
        if(x!=0)
        {
            id=camp.retornarIDcampeonato(equipoa);
            txtIDcampeonato.setText(""+id);
        }
    }//GEN-LAST:event_cboCampeonatoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String car= txtGC.getText();
         if(!car.equals(""))//si es diferente de espacio que le exporte un mensaje.
       {
                int ide = Integer.parseInt(txtIDequipo.getText());
                 int idc= Integer.parseInt(txtIDcampeonato.getText());
                int Golcasa = Integer.parseInt(txtGC.getText());
                int Golvisita= Integer.parseInt(txtGV.getText());
                String fechaPar= ((JTextField)jFP.getDateEditor().getUiComponent()).getText();
               

                int z = part.registrarPartido(ide,idc, Golcasa,Golvisita,fechaPar);

                if(z>0){

                    JOptionPane.showMessageDialog(this, "Exitoso");
                    updateComponets();
                    //listarEquipo();
                    limpiar();
                }else{
                JOptionPane.showMessageDialog(this, "No se guardo");
                }
         }else{
         JOptionPane.showMessageDialog(null,"ingrese datos  Para continuar.","Error",JOptionPane.ERROR_MESSAGE);
           txtGC.requestFocus();
         }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jDPartidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDPartidoMouseClicked
        // TODO add your handling code here:
        int fila=jDPartido.rowAtPoint(evt.getPoint());
        txtCod.setText(jDPartido.getValueAt(fila,0).toString());
        txtIDequipo.setText(jDPartido.getValueAt(fila,1).toString());
        txtIDcampeonato.setText(jDPartido.getValueAt(fila,2).toString());
        txtGC.setText(jDPartido.getValueAt(fila,3).toString());
        txtGV.setText(jDPartido.getValueAt(fila,4).toString());
        jFP.setDate(Date.valueOf(jDPartido.getValueAt(fila,5).toString()));
        
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnAgregar.setEnabled(false);
    }//GEN-LAST:event_jDPartidoMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fil = jDPartido.getSelectedRow();
        if(fil<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Partido a MODIFICAR!");
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea MODIFICAR el Presidente? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                   int id = Integer.parseInt(txtCod.getText());
                   int idequi= Integer.parseInt(txtIDequipo.getText());
                   int idcam=Integer.parseInt(txtIDcampeonato.getText());
                    int golcas = Integer.parseInt(txtGC.getText());
                    int golvisita =Integer.parseInt( txtGV.getText());
                     String fechaDirec= ((JTextField)jFP.getDateEditor().getUiComponent()).getText() ;
                     
                    int x = part.modificarPartido(id,idequi,idcam,golcas,golvisita,fechaDirec);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Partido MODIFICADO!");
                        updateComponets();
                        limpiar();
                        btnEliminar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        btnAgregar.setEnabled(false);
                        inabilitar();
                    }else{
                        JOptionPane.showMessageDialog(null, "El Partido no se ha MODIFICADO!");      
                    }                   
            }        
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         int fila = jDPartido.getSelectedRow();
        String cod="";
        cod=jDPartido.getValueAt(fila,0).toString();
        try {
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR el  Partido? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
           
            PreparedStatement pst= cn.prepareStatement("DELETE FROM partido WHERE idPartido='"+cod+"'");
            pst.executeUpdate();
            updateComponets();
            
            }else{
                        JOptionPane.showMessageDialog(null, "Partido no ELIMINADO!");      
                    } 
            
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

void listarPresidente(){
    listaPartido =part.listarPartido();
    model = (DefaultTableModel) jDPartido.getModel();
        Object[] usu = new Object[6];
        for(int i=0;i<listaPartido.size();i++){
            usu[0]=listaPartido.get(i).getIdpartido();
            usu[1]=listaPartido.get(i).getIdequipo();
            usu[2]=listaPartido.get(i).getIdcampeonato();
            usu[3]=listaPartido.get(i).getGolcasa();
            usu[4]=listaPartido.get(i).getGolvisita();
            usu[5]=listaPartido.get(i).getFechapart();
            
            model.addRow(usu);
               
        jDPartido.setModel(model);
        } 
  } 
 void inabilitar()
{
        txtCod.setEnabled(false);
        txtGC.setEnabled(false);
        txtGV.setEnabled(false);
        
        cboEquipo.setEnabled(false); 
        cboCampeonato.setEnabled(false); 
        
       
        
}
 void abilitar()
 {
     txtCod.setEnabled(false);
        txtGC.setEnabled(true);
        txtGV.setEnabled(true);
        
        cboEquipo.setEnabled(true); 
        cboCampeonato.setEnabled(true); 
        
       
 }
 void limpiar(){
        txtCod.setText(null);
        txtGC.setText(null);
        txtGV.setText(null);
       cboCampeonato.setSelectedIndex(0);
        cboEquipo.setSelectedIndex(0);
       jFP.setDate(null);
        }
void updateComponets(){
    LimpiarTabla(model);
    listarPresidente();
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboCampeonato;
    private javax.swing.JComboBox cboEquipo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JTable jDPartido;
    private com.toedter.calendar.JDateChooser jFP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtGC;
    private javax.swing.JTextField txtGV;
    private javax.swing.JTextField txtIDcampeonato;
    private javax.swing.JTextField txtIDequipo;
    // End of variables declaration//GEN-END:variables
}
