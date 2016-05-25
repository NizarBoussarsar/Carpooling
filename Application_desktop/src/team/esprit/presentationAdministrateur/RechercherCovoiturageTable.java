package team.esprit.presentationAdministrateur;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoiturage;

public class RechercherCovoiturageTable extends AbstractTableModel {

    String ch;
    List<Covoiturage> listCovoiturages;
    String columnTab[] = {"ID", "Createur", "Ville de départ", "Ville d'arrivée", "Date de départ"};

    public RechercherCovoiturageTable(String critere) {
        this.ch = critere;
        CovoiturageDAO covoituragedao = new CovoiturageDAO();
        listCovoiturages = covoituragedao.rechercherCovoiturages(critere);
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

    @Override
    public String getColumnName(int column) {
        return columnTab[column];
    }
}