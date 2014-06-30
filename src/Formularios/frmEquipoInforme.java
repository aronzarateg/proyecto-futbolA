/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Clacess.Equipo;
import Conexion.Conexion;
import Modelo.EquipoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aron
 */
public class frmEquipoInforme extends javax.swing.JInternalFrame {

    Connection conex;
    ArrayList<Equipo> lista = new ArrayList();
    EquipoDAO jd = new EquipoDAO();
    DefaultComboBoxModel<Object> combomodel = new DefaultComboBoxModel<>();
    public frmEquipoInforme() {
        initComponents();
        cargarCombo();
    }
         final void cargarCombo()
    {
        lista = jd.listarEquipo();
        combomodel.addElement("Seleccionar Equipo");
        cboequipo.setModel(combomodel);
        for(int i=0; i<lista.size();i++){
        combomodel.addElement(lista.get(i).getNombre());
            }
        cboequipo.setModel(combomodel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboequipo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("EQUIPO:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cboequipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboequipoActionPerformed(evt);
            }
        });
        jPanel1.add(cboequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 180, -1));

        jButton1.setText("Generar  Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboequipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboequipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboequipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Equipo =null;
        JasperReport jasperReport = null;
        conex = Conexion.coneccion();
        Equipo = cboequipo.getSelectedItem().toString();
        Map parametro = new HashMap();
        parametro.put("equipo", Equipo);
        try{
            jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportess/report4.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, conex);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);

        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, "JasperReport:"+ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboequipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
