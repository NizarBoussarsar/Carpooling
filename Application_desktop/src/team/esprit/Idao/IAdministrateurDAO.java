package team.esprit.Idao;

import team.esprit.entities.Administrateur;

public interface IAdministrateurDAO {

    public Administrateur afficherInformations();

    public boolean modifierMotPasse(Administrateur administrateur, String newPass);
}