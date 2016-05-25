package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Notification;

public interface INotificationDAO {

    public List<Notification> afficherNotificationsNonLus();

    public boolean envoyerNotification(Covoitureur covoitureur1, Covoitureur covoitureur2, String contenu, int type);

    public List<Notification> recupererNotification(int Id);
    
    public int afficherNombreNotificationsNonLus(Covoitureur covoitureurConnecte);

    public Boolean notificationReservation(Covoitureur covoitureur1, Covoitureur covoitureur2);

    public void rendreLu(Notification notification);
}