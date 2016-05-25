package team.esprit.presentationClient;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import team.esprit.dao.MessageDAO;
import team.esprit.entities.Message;

public class ConsulterMesMessagesNonLusTable extends AbstractTableModel {
     
    String[] columTab = {"ID", "Nom de l'expéditeur", "Objet du message", "Contenu du message ", "Date d'envoie"};
    private List<Message> listMessages;
    MessageDAO messageDAO = new MessageDAO();
    
    public ConsulterMesMessagesNonLusTable() {
        listMessages = messageDAO.afficherMessageNonLus();
    }

    @Override
    public int getRowCount() {
        return listMessages.size();
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
                return listMessages.get(rowIndex).getId();
            case 1:
                return listMessages.get(rowIndex).getExpediteur().getNom();
            case 2:
                return listMessages.get(rowIndex).getObjet();
            case 3:
                return listMessages.get(rowIndex).getContenu();
            case 4:
                return listMessages.get(rowIndex).getDateEnvoie();
            default:
                return null;
        }
    }  
}