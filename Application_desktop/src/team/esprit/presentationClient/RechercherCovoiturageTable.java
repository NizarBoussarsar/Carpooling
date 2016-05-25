package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoiturage;

public class RechercherCovoiturageTable extends AbstractTableModel {

    String villeDepart;
    String villeArrivee;
    List<Covoiturage> listCovoiturages;
    String[] columTab = {"ID", "Conducteur", "Date de départ", "Ville de départ", "Ville d'arrivée", "Nombres de places restantes"};
    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();

    public RechercherCovoiturageTable(String villeDepart, String villeArrivee) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        listCovoiturages = covoiturageDAO.afficherCovoituragesRecherche(villeDepart, villeArrivee);
    }

    public RechercherCovoiturageTable() {
        listCovoiturages = covoiturageDAO.afficherCovoituragesDisponibles();
    }

    public RechercherCovoiturageTable(Covoiturage covoiturage) {
        listCovoiturages = covoiturageDAO.rechercheAvanceeCovoiturages(covoiturage);
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listCovoiturages.get(rowIndex).getId();
            case 1:
                return listCovoiturages.get(rowIndex).getCreateur().getNomUtilisateur();
            case 2:
                return listCovoiturages.get(rowIndex).getDateDepart();
            case 3:
                return listCovoiturages.get(rowIndex).getVilleDepart().getGouvernorat();
            case 4:
                return listCovoiturages.get(rowIndex).getVilleArrivee().getGouvernorat();
            case 5:
                return listCovoiturages.get(rowIndex).getNombrePlaces();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columTab[column];
    }
}
