package team.esprit.presentationAdministrateur;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoiturage;

public class AfficherLesCovoituragesTable extends AbstractTableModel {

    List<Covoiturage> listCovoiturages;
    String columnTab[] = {"ID", "Créateur", "Ville de départ", "Ville d'arrivée", "Date de départ"};

    public AfficherLesCovoituragesTable() {
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        listCovoiturages = covoiturageDAO.afficherCovoiturages();
    }

    @Override
    public int getRowCount() {
        return listCovoiturages.size();
    }

    @Override
    public int getColumnCount() {
        return columnTab.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnTab[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listCovoiturages.get(rowIndex).getId();
            case 1:
                return listCovoiturages.get(rowIndex).getCreateur().getNomUtilisateur();
            case 2:
                return listCovoiturages.get(rowIndex).getVilleDepart().getGouvernorat() + ", " + listCovoiturages.get(rowIndex).getVilleDepart().getDelegation() + ", " + listCovoiturages.get(rowIndex).getVilleDepart().getLocalite();
            case 3:
                return listCovoiturages.get(rowIndex).getVilleArrivee().getGouvernorat() + ", " + listCovoiturages.get(rowIndex).getVilleArrivee().getDelegation() + ", " + listCovoiturages.get(rowIndex).getVilleArrivee().getLocalite();
            case 4:
                return listCovoiturages.get(rowIndex).getDateDepart();
            default:
                return null;
        }
    }
}