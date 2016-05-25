package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;

public interface IParticipantDAO {

    public List<Covoitureur> afficherParticipants(Covoiturage covoiturage);

    public boolean ajouterParticipant(Covoitureur covoitureur, Covoiturage covoiturage);

    public boolean supprimerParticipant(Covoitureur covoitureur, Covoiturage covoiturage);
}