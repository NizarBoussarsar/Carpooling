package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.NotificationDAO;
import team.esprit.entities.Notification;

public class ConsulterMesNotificationsNonLuesTable extends AbstractTableModel {

    String[] columTab = {"ID", "Notification"};
    List<Notification> listNotifications;
    NotificationDAO notificationDAO = new NotificationDAO();

    public ConsulterMesNotificationsNonLuesTable() {
        listNotifications = notificationDAO.afficherNotificationsNonLus();
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
    public String getColumnName(int column) {
        return columTab[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listNotifications.get(rowIndex).getId();
            case 1:
                return listNotifications.get(rowIndex).getContenu();
            default:
                return null;
        }
    }
}