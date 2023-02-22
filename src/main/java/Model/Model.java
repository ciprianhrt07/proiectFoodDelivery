package Model;

import java.util.ArrayList;
import java.util.HashMap;
import Presentation.Controller;

public class Model {

    private ArrayList<Client> clients;
    private ArrayList<Orders> orders;
    private ArrayList<Product> products;

    public Model ()
    {
        clients = new ArrayList<Client>();
        orders  = new ArrayList<Orders>();
        products = new ArrayList<Product>();

    }

    public void addClient(Client client)
    {
       this.clients.add(client);

    }

    public void addProduct(Product product)
    {
       this.products.add(product);

    }

    public void removeClient(Client client)
    {
        this.clients.remove(client);
    }
    public void removeProduct(Product product)
    {
        this.products.remove(product);
    }

    public boolean addOrder(Orders order)
    {
        int stoc=0,poz=-1;

        for(int i=0;i<orders.size();i++)
        {
            if(orders.get(i).getId()==order.getId())
            {
                poz=i;
                break;
            }
        }

        if(orders.get(poz).getNumberOfProducts()>=order.getNumberOfProducts())
        {
            orders.add(order);
            this.products.get(poz).setStoc(this.products.get(poz).getStoc()-order.getNumberOfProducts());
            if(this.products.get(poz).getStoc()==0)
                this.products.remove(poz);
        }else
         poz=-1;




        if(poz==-1)
          return false;
            else
          return true;

    }


    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
