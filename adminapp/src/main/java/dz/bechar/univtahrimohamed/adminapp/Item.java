package dz.bechar.univtahrimohamed.adminapp;

public class Item {

    String nom;
    String email;
    int image;

    public Item(String nom, String email, int image) {
        this.nom = nom;
        this.email = email;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
