package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Reclamation;

public interface IReclamationDAO {

    public boolean envoyerReclamation(Covoitureur c, Reclamation reclamation);

    public void modifierReclamation(int id);

    public List<Reclamation> afficherReclamations();

    public Reclamation afficherReclamation(int idReclamation);
}