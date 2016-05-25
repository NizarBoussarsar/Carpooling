package team.esprit.Idao;

import java.util.List;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Ville;

public interface IDetourDAO {

    public List<Ville> afficherDetours(Covoiturage covoiturage);
}
