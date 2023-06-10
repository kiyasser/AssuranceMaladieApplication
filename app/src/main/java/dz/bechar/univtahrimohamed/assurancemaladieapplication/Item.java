package dz.bechar.univtahrimohamed.assurancemaladieapplication;

public class Item {

    String nom;
    String email;
    int image;

    String analyseDate;
    String file1;
    String file2;
    String file3;

    public Item(String nom, String email, int image, String analyseDate, String file1, String file2, String file3) {
        this.nom = nom;
        this.email = email;
        this.image = image;
        this.analyseDate = analyseDate;
        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
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

    public String getAnalyseDate() {
        return analyseDate;
    }

    public void setAnalyseDate(String analyseDate) {
        this.analyseDate = analyseDate;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public String getFile3() {
        return file3;
    }

    public void setFile3(String file3) {
        this.file3 = file3;
    }
}
