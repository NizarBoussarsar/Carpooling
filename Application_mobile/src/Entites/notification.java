package Entites;

/**
 *
 * @author Wael Mallek
 */
public class notification {
    private String nom ;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    private int id;
    private int id_expediteur;
    private int id_destinataire;
    private int lu;
    private String contenu;

    public notification(int id,int id_expediteur,int id_destinataire,int lu, String nom) {
        this.id = id;
        this.id_expediteur = id_expediteur;
        this.id_destinataire = id_destinataire;
        this.lu=lu;
        this.contenu= contenu;
        this.nom=nom;
    }
    
     public notification()
     {
     }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setId_expediteur(int id_expediteur) {
        this.id_expediteur = id_expediteur;
    }

    public void setId_destinataire(int id_destinataire) {
        this.id_destinataire = id_destinataire;
    }

    public void setLu(int lu) {
        this.lu = lu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public int getId_expediteur() {
        return id_expediteur;
    }

    public int getId_destinataire() {
        return id_destinataire;
    }

    public int getLu() {
        return lu;
    }

    public String getContenu() {
        return contenu;
    }
    public String toString() {
        return "Notification{nom="+nom+"id=" + id + ", id_expediteur=" + id_expediteur + ", id_destinataire=" + id_destinataire+ ", =" +", contenu= "+contenu+" lu: "+lu;
    }

}
