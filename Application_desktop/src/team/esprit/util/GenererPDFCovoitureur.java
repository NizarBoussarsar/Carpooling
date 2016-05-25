package team.esprit.util;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GenererPDFCovoitureur {

    private static File directoryCovoitureur = new File("./report/rapportCovoitureur");
    private static String date;

    public static void main(String[] args) {
        Connection connection;
        try {
            connection = MyConnection.getInstance();

            directoryCovoitureur.mkdirs();
            date = new Date().toString();
            date = date.substring(4, 10);
            date = date.replaceAll("\\s+", "");

            JasperDesign jasperDesign1 = JRXmlLoader.load(directoryCovoitureur + "/afficherCovoitureurEtat.jrxml");
            JasperDesign jasperDesign2 = JRXmlLoader.load(directoryCovoitureur + "/afficherCovoitureurMois.jrxml");
            JasperDesign jasperDesign3 = JRXmlLoader.load(directoryCovoitureur + "/afficherCovoitureurSexe.jrxml");
            JasperDesign jasperDesign5 = JRXmlLoader.load(directoryCovoitureur + "/afficherCovoitureurFumeur.jrxml");
            JasperDesign jasperDesign6 = JRXmlLoader.load(directoryCovoitureur + "/afficherMCovoitureurs.jrxml");

            JasperReport jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
            JasperReport jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);
            JasperReport jasperReport3 = JasperCompileManager.compileReport(jasperDesign3);
            JasperReport jasperReport5 = JasperCompileManager.compileReport(jasperDesign5);
            JasperReport jasperReport6 = JasperCompileManager.compileReport(jasperDesign6);

            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");

            JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, connection);
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, connection);
            JasperPrint jasperPrint3 = JasperFillManager.fillReport(jasperReport3, parameters, connection);
            JasperPrint jasperPrint5 = JasperFillManager.fillReport(jasperReport5, parameters, connection);
            JasperPrint jasperPrint6 = JasperFillManager.fillReport(jasperReport6, parameters, connection);

            JasperExportManager.exportReportToPdfFile(jasperPrint1, directoryCovoitureur + "\\" + date + "_afficherCovoitureurEtat.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint2, directoryCovoitureur + "\\" + date + "_afficherCovoitureurMois.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint3, directoryCovoitureur + "\\" + date + "_afficherCovoitureurSexe.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint5, directoryCovoitureur + "\\" + date + "_afficherCovoitureurFumeur.pdf");
            JasperExportManager.exportReportToPdfFile(jasperPrint6, directoryCovoitureur + "\\" + date + "_afficherMCovoitureurs.pdf");
        } catch (JRException e) {
            System.out.println("erreur de compilation" + e.getMessage());
        }
    }
}
