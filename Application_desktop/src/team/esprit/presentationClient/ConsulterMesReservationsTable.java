package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.ReservationDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Reservation;
import team.esprit.presentation.Authentification;

public class ConsulterMesReservationsTable extends AbstractTableModel {

    List<Reservation> listReservations;
    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    String columnTab[] = {"ID", "Conducteur", "Titre", "Description", "Date de reservation", "Etat"};

    public ConsulterMesReservationsTable(Covoitureur covoitureurConnecte) {
        this.covoitureurConnecte = covoitureurConnecte;
        ReservationDAO reservatioDAO = new ReservationDAO();
        listReservations = reservatioDAO.afficherReservationsCovoitureur(covoitureurConnecte);
    }

    @Override
    public int getRowCount() {
        return listReservations.size();
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
                return listReservations.get(rowIndex).getId();
            case 1:
                return listReservations.get(rowIndex).getCovoitureur().getNomUtilisateur();
            case 2:
                return listReservations.get(rowIndex).getCovoiturage().getTitre();
            case 3:
                return listReservations.get(rowIndex).getCovoiturage().getDescription();
            case 4:
                return listReservations.get(rowIndex).getDateReservation();
            case 5:
                return listReservations.get(rowIndex).getEtat();
            default:
                return null;
        }
    }
}