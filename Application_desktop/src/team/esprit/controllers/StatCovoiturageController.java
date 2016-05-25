package team.esprit.controllers;

import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoitureur;

public class StatCovoiturageController {

    public JFreeChart statistiqueCovoiturageFrequenceVilleCovoitureur(Covoitureur covoitureur) {
        Map<String, Integer> mapCovoiturageFrequenceVilleCovoitureur = new HashMap<String, Integer>();
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        mapCovoiturageFrequenceVilleCovoitureur = covoiturageDAO.afficherFrequenceVilleCovoitureur(covoitureur);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : mapCovoiturageFrequenceVilleCovoitureur.entrySet()) {
            String ville = entry.getKey();
            Integer frequence = entry.getValue();
            dataset.setValue(frequence, "Frequence", ville);
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Fréquence des villes visitées", "Ville", "Frequence", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }

    public JFreeChart statistiqueCovoiturageFrequenceVille() {
        Map<String, Integer> mapCovoiturageFrequenceVille = new HashMap<String, Integer>();
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        mapCovoiturageFrequenceVille = covoiturageDAO.afficherFrequenceVille();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : mapCovoiturageFrequenceVille.entrySet()) {
            String ville = entry.getKey();
            Integer frequence = entry.getValue();
            dataset.setValue(frequence, "Frequence", ville);
        }
        JFreeChart chart = ChartFactory.createBarChart3D("Fréquence des villes visitées", "Ville", "Frequence", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }

    public JFreeChart statistiqueCovoiturageParMois() {
        Map<Integer, Integer> mapCovoiturageParMois = new HashMap<Integer, Integer>();
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        mapCovoiturageParMois = covoiturageDAO.afficherCovoituragesMois();

        TimeSeries series = new TimeSeries("Covoiturages/Mois", Month.class);
        for (Map.Entry<Integer, Integer> entry : mapCovoiturageParMois.entrySet()) {
            Integer nbreCovoiturage = entry.getValue();
            Integer anneeMois = entry.getKey();
            String annee = anneeMois.toString().substring(0, 4);
            System.out.println(annee);
            String mois = anneeMois.toString().substring(4);
            System.out.println(annee);
            System.out.println(mois);
            series.add(new Month(Integer.parseInt(mois), Integer.parseInt(annee)), nbreCovoiturage);
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        dataset.setDomainIsPointsInTime(false);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Covoiturage par Mois", " Mois ", "Nombre Covoiturage", dataset, true, true, true);
        return chart;
    }

    public JFreeChart statistiqueCovoiturageParAn() {
        Map<Integer, Integer> mapCovoiturageParAn = new HashMap<Integer, Integer>();
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        mapCovoiturageParAn = covoiturageDAO.afficherCovoituragesAnnee();

        TimeSeries series = new TimeSeries("Covoiturages/Année", Year.class);
        for (Map.Entry<Integer, Integer> entry : mapCovoiturageParAn.entrySet()) {
            Integer nbreCovoiturage = entry.getValue();
            System.out.println(nbreCovoiturage);
            Integer anneeCovoiturage = entry.getKey();
            System.out.println(anneeCovoiturage);
            series.add(new Year(anneeCovoiturage), nbreCovoiturage.byteValue());
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        dataset.setDomainIsPointsInTime(false);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Covoiturage par année", " Année ", "Nombre Covoiturage", dataset, true, true, true);
        return chart;
    }
}