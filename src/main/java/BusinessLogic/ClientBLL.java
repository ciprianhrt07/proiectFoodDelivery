package BusinessLogic;

import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import Connection.ConnectionFactory;
import DataAcces.*;

/**
 * Respectand Layered Architecture
 * ClientBLL se ocupa de validarea inputului
 * urmand sa apeleze executarea comezilor
 * in caz de succes , altfel arunca o exceptie.
 *
 */
public class ClientBLL {

    private List<Validator<Client>> validatorList;


    public ClientBLL()
    {
        validatorList = new ArrayList<Validator<Client>>();
        validatorList.add(new EmailValidator());
        validatorList.add(new ClientAgeValidator());
    }

    public Client findClientById(int id)
    {
        Client client = ClientDAO.findByID(id);

        if(client == null)
        {
            throw new NoSuchElementException(" Model.Client with id"+ id +"was not found ");

        }

        return client;
    }

    public int insertClient(Client client)
    {
       boolean ok = true;
        for(Validator<Client> v : validatorList)
        {
            if(v.valideaza(client)==false)
            {   ok =false;
                throw new IllegalArgumentException(" Clientul "+client.toString()+ " nu a putut fi validat");

            }
        }

        ConnectionFactory connectionFactory = new ConnectionFactory();


            return ClientDAO.insert(client);

    }

    public int deleteClient(int id)
    {

        ConnectionFactory connectionFactory = new ConnectionFactory();

       int ok = ClientDAO.delete(id);

         if(ok == 0 )
         {
             throw new NoSuchElementException(" Model.Client with id "+ id +" was not found ");
         }else
         if(ok == -1)
         {
             throw new  NoSuchElementException(" Model.Client with id "+ id +" nu s-a putut sterge ");
         }
         else
            return 1;

    }

    public int update(Client client)
    {
        boolean ok = true;
        for(Validator<Client> v : validatorList)
        {
            if(v.valideaza(client)==false)
            {   ok =false;
                throw new IllegalArgumentException(" Clientul "+client.toString()+ " nu a putut fi validat");

            }
        }

        ConnectionFactory connectionFactory = new ConnectionFactory();

        if(ok==true)
            ClientDAO.update(client,client.getId());

        return 1;
    }

    public List<Client> findAllClients()
    {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        List<Client> clients = ClientDAO.displayAllClients();

        if(clients.size() == 0)
        {
            throw new NoSuchElementException(" Niciun client nu a fost gasit ");

        }

        return clients;
    }

}
