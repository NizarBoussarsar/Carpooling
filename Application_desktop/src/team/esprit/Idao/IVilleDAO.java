package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Ville;

public interface IVilleDAO {

    public List<Ville> afficherVilles();

    public List<Ville> afficheLocalite(String gouvernorat, String delegation);

    public List<Ville> afficheDelegation(String gouvernorat);

    public List<Ville> afficheGouvernorat();

    public Ville afficheVille_ID(int id);

    public Ville afficherVille_Localite(String localite);

    public Ville localiserVille_nom(String nom);
}
