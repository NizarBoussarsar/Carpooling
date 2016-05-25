package team.esprit.Idao;

import java.util.List;
import java.util.Map;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;

public interface ICovoiturageDAO {

    public Map<String, Integer> afficherFrequenceVilleCovoitureur(Covoitureur covoitureur);

    public Covoiturage afficherCovoiturage_ID(int id);

    public List<Covoiturage> afficherCovoiturages();

    public List<Covoiturage> afficherCovoituragesCovoitureurConnecte(Covoitureur covoitureurConnecte);

    public boolean ajouterCovoiturage(Covoiturage covoiturage);

    public List<Covoiturage> rechercherCovoiturages(String critere);

    public boolean modifierNombrePlaces(Covoiturage covoiturage, int plusMoins);

    public boolean supprimerCovoiturage(int id);

    public Map<Integer, Integer> afficherCovoituragesMois();

    public Map<String, Integer> afficherFrequenceVille();

    public Map<Integer, Integer> afficherCovoituragesAnnee();

    public boolean modifierCovoiturage(Covoiturage covoiturage);

    public List<Covoiturage> afficherCovoituragesDisponibles();

    public List<Covoiturage> afficherCovoituragesRecherche(String c1, String c2);

    public List<Covoiturage> rechercheAvanceeCovoiturages(Covoiturage covoiturage_donnee);

    public List<CovoiturageDAO.Resultat> afficherFrequenceVilleCovoitureurSupDix(Covoitureur covoitureur);
}