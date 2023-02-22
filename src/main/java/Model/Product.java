package Model;

/**
 * Clasa Product sugereaza un produs supus achizitionarii
 * id-ul unic
 * nume produs
 * stoc,pret valori pozitive.
 *
 */
public class Product {

     private int id;
     private String nume;
     private int stoc;
     private int pret;

    public Product(int id, String nume, int stoc, int pret) {
        this.id = id;
        this.nume = nume;
        this.stoc = stoc;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Model.Product{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", stoc=" + stoc +
                ", pret=" + pret +
                '}';
    }
}
