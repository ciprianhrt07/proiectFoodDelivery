package Model;

/**
 *
 * Clasa intruneste proprietatile unui posibil client memorat in baza de date
 * ca si principale atribute se remarca id-ul (din tabela) , unic
 * numele adresa email ul si varsta
 */

public class Client {

    private int id;
    private String name;
    private String adress;
    private String email;
    private int age;

    public Client(int id, String name, String adress, String email, int age) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Model.Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
