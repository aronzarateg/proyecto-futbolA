/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clacess;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import Formularios.frmEquipoInforme;

/**
 *
 * @author aron
 */
public class Reportes 
{
    
    Connection conex;
    public void  reportespdf(String ruta, String archi)
    {
        try {
            String  rutainforme= ruta;
            JasperPrint informe= JasperFillManager.fillReport(rutainforme,null,conex);
            JasperExportManager.exportReportToPdfFile(informe,archi);
            
            /*
            JasperViewer.ventanavisor= new JasperViewer(informe,false);
            ventanavisor.setTitle("Informe");
            ventanavisor.setVisible(true);
            */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL EXPORTAR DOCUMENTO");
        }
    
    
        
    
    }
}
