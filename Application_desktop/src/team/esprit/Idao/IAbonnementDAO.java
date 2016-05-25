package team.esprit.Idao;

import java.util.List;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Abonnement;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;

public interface IAbonnementDAO {

    public boolean ajouterAbonnement(Covoitureur covoitureur, CovoiturageDAO.Resultat resultat);

    public List<Abonnement> afficherAbonnement(Covoitureur covoitureur);

    public List<Abonnement> afficherAbonnementByVilleDepartArrivee(Ville villeDepart, Ville villeArrivee);
}
