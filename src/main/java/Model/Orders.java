package Model;

/**
 * Clasa intruneste proprietatile unei posibile comenzi
 * atributele sale sunt identice cu cele din tabelul din baza de date la care corespunde
 * id-ul unic , numarul de produse achizitionat id-ul clientului id-ul produsului,total de plata
 *
 */
public class Orders {

    private int id;
    private int numberOfProducts;
    private int idClient;
    private int idProdus;
    private int total;

    public Orders(int id, int numberOfProducts, int idClient, int idProdus) {
        this.id = id;
        this.numberOfProducts = numberOfProducts;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Model.Orders{" +
                "id=" + id +
                ", numberOfProducts=" + numberOfProducts +
                ", idClient=" + idClient +
                ", idProdus=" + idProdus +
                ", total=" + total +
                '}';
    }
}
