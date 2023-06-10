package dz.bechar.univtahrimohamed.assurancemaladieapplication;

public class HelperClass {

    String nom, prenom, naissance, email, phone, addresse, password, etatsoc;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEtatsoc() {
        return etatsoc;
    }

    public void setEtatsoc(String etatsoc) {
        this.etatsoc = etatsoc;
    }

    public HelperClass(String nom, String prenom, String naissance, String email, String phone, String addresse, String password, String etatsoc) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.email = email;
        this.phone = phone;
        this.addresse = addresse;
        this.password = password;
        this.etatsoc = etatsoc;
    }

    public HelperClass() {
    }
}
