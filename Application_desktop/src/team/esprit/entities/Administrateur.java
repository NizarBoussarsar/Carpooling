package team.esprit.entities;

public class Administrateur {

    private int _id;
    private String _email;
    private String _mdp;
    private String _nom;

    public void setId(int _id) {
        this._id = _id;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public void setMdp(String _mdp) {
        this._mdp = _mdp;
    }

    public int getId() {
        return _id;
    }

    public String getNom() {
        return _nom;
    }


    public String getEmail() {
        return _email;
    }

    public String getMdp() {
        return _mdp;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "_id=" + _id + ", _email=" + _email + ", _mdp=" + _mdp + ", _nom=" + _nom + '}';
    }
}