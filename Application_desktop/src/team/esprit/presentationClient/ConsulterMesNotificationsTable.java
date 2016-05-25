package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.NotificationDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Notification;
import team.esprit.presentation.Authentification;

public class ConsulterMesNotificationsTable extends AbstractTableModel {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    List<Notification> listNotifications;
    String[] columTab = {"Date", "Contenu"};

    public ConsulterMesNotificationsTable() {
        NotificationDAO notificationDAO = new NotificationDAO();
        listNotifications = notificationDAO.recupererNotification(covoitureurConnecte.getId());
    }

    @Override
    public int getRowCount() {
        return listNotifications.size();
    }

    @Override
    public int getColumnCount() {
        return columTab.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listNotifications.get(rowIndex).getDateCreation();
            case 1:
                return listNotifications.get(rowIndex).getContenu();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columTab[column];
    }
}
