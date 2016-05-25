package team.esprit.Idao;

import java.sql.SQLException;
import java.util.List;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Reservation;

public interface IReservationDAO {

    public Reservation afficherReservation(int id);

    public boolean envoyerDemande(Covoitureur covoitureur, Covoiturage covoiturage);

    public int reservationParCovoitureur(Covoitureur covoitureur, Covoiturage covoiturage);

    public boolean afficherEtat(Covoitureur covoitureur, Covoiturage covoiturage) throws SQLException;

    public List<Covoitureur> afficherCovoitureurs(Covoiturage covoiturage);

    public boolean annulerReseration(Covoiturage covoiturage);

    public List<Reservation> afficherReservationsCovoitureur(Covoitureur covoitureur);

    public boolean modifierEtat(Covoitureur covoitureur, Covoiturage covoiturage, boolean etat);
}