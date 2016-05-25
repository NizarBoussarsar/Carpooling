package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Message;

public interface IMessageDAO {

    public boolean envoyerMessage(Covoitureur covoitureur, Message message);

    public List<Message> afficherMessage();

    public List<Message> afficherMessageNonLus();

    public int afficherNombreMessagesNonLus(Covoitureur covoitureurConnecte);

    public Message afficherUnMessage(int id);

    public void rendreLu(Message message);
}