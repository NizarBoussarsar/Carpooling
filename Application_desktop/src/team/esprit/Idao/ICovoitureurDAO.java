package team.esprit.Idao;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;

public interface ICovoitureurDAO {

    public Covoitureur afficherCovoitureur_IdFacebook(String IdFacebook);

    public void modifierAvatar(int id, FileInputStream fis, int len);

    public int IDCovoitureur_IDCovoiturage(int id);

    public Covoitureur afficherCovoitureur_ID(int id);

    public boolean afficherCovoitureur_EMAIL(String email) throws SQLException;

    public Covoitureur afficherCovoitureurEMAIL(String email);

    public List<Covoitureur> afficherCovoitureurs();

    public void ajouterCovoitureur(Covoitureur covoitureur);

    public boolean ajouterCovoitureur1(Covoitureur covoitureur);

    public List<Covoitureur> afficherCovoitureurSexe(char sexe);

    public List<Covoitureur> afficherCovoitureurEtat(int etat);

    public List<Covoitureur> afficherCovoitureurFumeur(boolean fumeur);

    public boolean authentifierCovoitureur(String email, String mdp) throws SQLException;

    public boolean authentifierCovoitureurFacebook(String id_facebook) throws SQLException;

    public boolean afficherCovoitureur_IDFACEBOOK(String id_facebook) throws SQLException;

    public void ajouterCovoitureurFacebook(Covoitureur covoitureur);

    public Map<Integer, Integer> afficherCovoitureurMois();

    public Map<Integer, Integer> afficherCovoitureurAnnee();

    public List<Covoitureur> rechercherCovoitureurs(String critere);

    public boolean bloquerCovoitureur(int id);

    public boolean modifierCovoitureur(Covoitureur covoitureur);

    public Covoitureur afficherCovoitureur_NomUtilisateur(String nomUtilisateur);

    public void modifierEtat(Covoitureur covoitureur);

    public boolean modifierMotPasse(Covoitureur covoitureur, String newPass);

    public boolean EvaluerCovoitureur(int note, int id);

    public int participerEnsemble(Covoitureur covoitureur1, Covoitureur covoitureur2, Covoiturage covoiturage);
}
