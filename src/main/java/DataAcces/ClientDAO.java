package DataAcces;

import Model.Client;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.*;

/**
 * Clasa este responsabila cu realizarea instructiunilor de insert update delte pe tabelul asociat clientului.
 *
 */
public class ClientDAO{

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final String insertStr = "INSERT INTO Client (id,nume,adress ,email,age )"+" VALUES ( ? , ? , ? , ? , ?)";

    private  static final String find  = "SELECT * FROM Client WHERE id = ?";

    private static final String updateString = "UPDATE Client SET  id = ? , nume = ? , adress = ? , email = ? , age = ?  WHERE id = ? ";

    private static final String deleteString = "DELETE from Client where id = ?";

    private static final String displayAll = "SELECT * FROM Client ";

    public static Client findByID(int id)
    {
        Client client = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
             findStatement = connection.prepareStatement(find);
             findStatement.setInt(1,id);

             //System.out.println(findStatement.toString());

             resultSet = findStatement.executeQuery();
             resultSet.next();

             int ID = resultSet.getInt("id");
             int age = resultSet.getInt("age");
             String name = resultSet.getString("nume");
             String adress = resultSet.getString("adress");
             String email  = resultSet.getString("email");

             client=new Client(ID,name,adress,email,age);

           }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ClientDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

      return client;
    }



    public static List<Client> displayAllClients()
    {   Client client = null;
        ArrayList<Client> clients = new ArrayList<>();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
            findStatement = connection.prepareStatement(displayAll);

            //System.out.println(findStatement.toString());

            resultSet = findStatement.executeQuery();


           while( resultSet.next()){

            int ID = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("nume");
            String adress = resultSet.getString("adress");
            String email  = resultSet.getString("email");

            client=new Client(ID,name,adress,email,age);

            clients.add(client);}

        }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ClientDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

        return clients;

    }

    public static int insert(Client client)
    {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedID = -1;

        try{
            insertStatement=connection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,client.getId());
            insertStatement.setString(2,client.getName());
            insertStatement.setString(3, client.getAdress());
            insertStatement.setString(4, client.getEmail());
            insertStatement.setInt(5,client.getAge());

            insertStatement.executeUpdate();

            ResultSet resultSet = insertStatement.getGeneratedKeys();

            if(resultSet.next())
            {
                insertedID=resultSet.getInt(1);
            }

          }catch(SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ClientDAO:findById " + ex.getMessage());
        }finally {

            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(connection);
        }

        return insertedID;

    }

    public static int delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = connection.prepareStatement(deleteString);
            deleteStatement.setInt(1,id);

           deletedID = deleteStatement.executeUpdate();  //returneaza 1 in caz de succes si 0 altfel


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(connection);


        }
        return deletedID;

    }

    public static int update (Client client , int id)
    {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        int updateStatus = -1;
        try {
            updateStatement = connection.prepareStatement(updateString);
            updateStatement.setInt(1,client.getId());
            updateStatement.setString(2, client.getName());
            updateStatement.setString(4, client.getEmail());
            updateStatement.setString(3,client.getAdress());
            updateStatement.setInt(5,client.getAge());
            updateStatement.setInt(6,id);

            updateStatus = updateStatement.executeUpdate();  //returneaza 1 in caz de succes si 0 altfel


        }catch (SQLIntegrityConstraintViolationException ex){

            //ex.printStackTrace();
            return -1;
        }
        catch (SQLException e) {
            //e.printStackTrace();
            return -1;
        }

        finally {


            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(connection);


        }
        return updateStatus;


    }

    public static ArrayList<String> clientProperties(Object object){

        ArrayList<String> strings = new ArrayList<>();

        for(Field field : object.getClass().getDeclaredFields()){

            field.setAccessible(true);

                strings.add(field.getName());

        }

         return strings;
    }

    public static ArrayList<String> clientValues(Object object){

        ArrayList<String> strings = new ArrayList<>();

        for(Field field : object.getClass().getDeclaredFields()){

            field.setAccessible(true);

            Object value;

            try {
                value=field.get(object);
                strings.add(value.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }



        return strings;
    }







}
