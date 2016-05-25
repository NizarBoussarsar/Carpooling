package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;

public class ConsulterMesCovoituragesTable extends AbstractTableModel {
    
    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    
    List<Covoiturage> listCovoiturages;
    String[] columTab = {"ID", "Ville de départ", "Ville d'arrivée", "Date de départ", "Nombre de places restants"};

    public ConsulterMesCovoituragesTable() {
        listCovoiturages = covoiturageDAO.afficherCovoituragesCovoitureurConnecte(covoitureurConnecte);
    }

    @Override
    public int getRowCount() {
        return listCovoiturages.size();
    }

    @Override
    public int getColumnCount() {
        return columTab.length;
    }

    @Override
    public String getColumnName(int column) {
        return columTab[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listCovoiturages.get(rowIndex).getId();
            case 1:
                return listCovoiturages.get(rowIndex).getVilleDepart().getGouvernorat();
            case 2:
                return listCovoiturages.get(rowIndex).getVilleArrivee().getGouvernorat();
            case 3:
                return listCovoiturages.get(rowIndex).getHeureDepart();
            case 4:
                return listCovoiturages.get(rowIndex).getNombrePlaces();
            default:
                return null;
        }
    }
}