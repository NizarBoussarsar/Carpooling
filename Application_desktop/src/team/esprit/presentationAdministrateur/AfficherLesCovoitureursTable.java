package team.esprit.presentationAdministrateur;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;

public class AfficherLesCovoitureursTable extends AbstractTableModel {

    List<Covoitureur> listCovoitureurs;
    String[] columnTab = {"ID", "Nom", "Prenom", "Email", "Nom d'utilisateur", "Etat"};

    public AfficherLesCovoitureursTable() {
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        listCovoitureurs = covoitureurDAO.afficherCovoitureurs();
    }

    @Override
    public int getRowCount() {
        return listCovoitureurs.size();
    }

    @Override
    public int getColumnCount() {
        return columnTab.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listCovoitureurs.get(rowIndex).getId();
            case 1:
                return listCovoitureurs.get(rowIndex).getNom();
            case 2:
                return listCovoitureurs.get(rowIndex).getPrenom();
            case 3:
                return listCovoitureurs.get(rowIndex).getEmail();
            case 4:
                return listCovoitureurs.get(rowIndex).getNomUtilisateur();
            case 5:
                return listCovoitureurs.get(rowIndex).getEtat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnTab[column];
    }
}