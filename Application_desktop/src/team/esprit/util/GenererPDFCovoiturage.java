package team.esprit.util;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GenererPDFCovoiturage {

    private static File directoryCovoiturage = new File("./report/rapportCovoiturage");
    private static String date;

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = MyConnection.getInstance();

            directoryCovoiturage.mkdirs();
            date = new Date().toString();
            date = date.substring(4, 10);
            date = date.replaceAll("\\s+", "");

            JasperDesign jasperDesign1 = JRXmlLoader.load(directoryCovoiturage + "/nbeCovoiturageAnnee.jrxml");
            JasperDesign jasperDesign2 = JRXmlLoader.load(directoryCovoiturage + "/nbeCovoiturageMois.jrxml");
            JasperDesign jasperDesign3 = JRXmlLoader.load(directoryCovoiturage + "/frequenceVisite.jrxml");

            JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
            JasperReport jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);
            JasperReport jasperReport3 = JasperCompileManager.compileReport(jasperDesign3);

            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");

            JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, connection);
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, connection);
            JasperPrint jasperPrint3 = JasperFillManager.fillReport(jasperReport3, parameters, connection);

            JasperExportManager.exportReportToPdfFile(jasperPrint1, directoryCovoiturage + "\\" + date + "_nbeCovoiturageAnnee.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint2, directoryCovoiturage + "\\" + date + "_nbeCovoiturageMois.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint3, directoryCovoiturage + "\\" + date + "_frequenceVisite.pdf");           
        } catch (JRException e) {
            System.out.println("erreur de compilation" + e.getMessage());
        }
    }
}