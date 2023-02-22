package DataAcces;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import DataAcces.ClientDAO;
import Model.Orders;
import Model.Product;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.*;

/**
 * Clasa este responsabila cu realizarea instructiunilor de insert view si getOrder  pe tabelul asociat comenzii.
 *
 */
public class OrdersDAO {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final String findOrder = " select * from Orders where id = ?";

    private static final String displayOrders = "select *from Orders";

    private static final String insertStr = "INSERT INTO Orders (id,numberofProducts,id_client ,id_produs,total )"+" VALUES ( ? , ? , ? , ?,?)";

    private static final String pretTotal =  " select sum( total ) from Model.Orders where id_client = ?";

    private static FileWriter myWriter = null;

    static {
        try {
            myWriter = new FileWriter("factura.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;




    public static Orders findByID(int id)
    {
        Orders order = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
            findStatement = connection.prepareStatement(findOrder);
            findStatement.setInt(1,id);

            //System.out.println(findStatement.toString());

            resultSet = findStatement.executeQuery();
            resultSet.next();

            int ID = resultSet.getInt("id");
            int number = resultSet.getInt("numberOfProducts");
            int idC = resultSet.getInt("id_client");
            int idP = resultSet.getInt("id_produs");
            int total = resultSet.getInt("total");

           order = new Orders(ID,number,idC,idP);
           order.setTotal(total);

        }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.OrdersDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

        return order;
    }

    public static List<Orders> displayAllProducts()
    {    Orders order = null;
        ArrayList<Orders> ordersArrayList = new ArrayList<>();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
            findStatement = connection.prepareStatement(displayOrders);

            //System.out.println(findStatement.toString());

            resultSet = findStatement.executeQuery();


            while( resultSet.next()){

                int ID = resultSet.getInt("id");
                int number = resultSet.getInt("numberOfProducts");
                int idC = resultSet.getInt("id_client");
                int idP = resultSet.getInt("id_produs");
                int total = resultSet.getInt("total");
                order = new Orders(ID,number,idC,idP);
                order.setTotal(total);

                ordersArrayList.add(order);}

        }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.OrdersDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

        return ordersArrayList;

    }

    public static int insert(Orders order)
    {
       Product product = ProductDAO.findByID(order.getIdProdus());
        int insertedResult = 1;

      if(product!=null) {
          if (product.getStoc() - order.getNumberOfProducts() < 0) {
              insertedResult = -1;

          } else {
              ConnectionFactory connectionFactory = new ConnectionFactory();
              Connection connection = ConnectionFactory.getConnection();

              PreparedStatement insertStatement = null;


              try {
                  insertStatement = connection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
                  insertStatement.setInt(1, order.getId());
                  insertStatement.setInt(2, order.getNumberOfProducts());
                  insertStatement.setInt(3, order.getIdClient());
                  insertStatement.setInt(4, order.getIdProdus());
                  int totalDePlata = order.getNumberOfProducts() * product.getPret();
                  insertStatement.setInt(5, totalDePlata);

                  insertedResult = insertStatement.executeUpdate();


              } catch (SQLException e) {

                  LOGGER.log(Level.WARNING, "DataAcces.OrdersDAO:findById " + e.getMessage());
                  insertedResult = -1;

              } finally {
                  ConnectionFactory.close(insertStatement);
                  ConnectionFactory.close(connection);
              }


          }

           if (insertedResult != -1 && product != null) {
              //decrementam cantitatea din produs si daca e 0 => stergere

              ConnectionFactory connectionFactory1 = new ConnectionFactory();
              Connection connection1 = ConnectionFactory.getConnection();

              int cantitate = order.getNumberOfProducts();

              if (product.getStoc() - cantitate >= 0) {

                  Product produsNou = new Product(product.getId(), product.getNume(), product.getStoc()-cantitate, product.getPret());
                  ProductDAO.update(produsNou, product.getId());
              } else
              {

                // ProductDAO.delete(product.getId());
                  insertedResult = -1;




              }


          }


      }else
          insertedResult = -1;


    return  insertedResult;


    }

    public static ArrayList<String> productProperties(Object object){

        ArrayList<String> strings = new ArrayList<>();

        for(Field field : object.getClass().getDeclaredFields()){

            field.setAccessible(true);

            strings.add(field.getName());

        }

        return strings;
    }

    public static ArrayList<String> productValues(Object object){

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

    public static void factura ()
    {
        List<Orders> orders = new ArrayList<>();
        orders = displayAllProducts();

        ArrayList<String> strings = new ArrayList<>();

        // nume Client   nume Produs   cantitate cumparata total de plata

        ConnectionFactory connectionFactory =null;

        for(Orders o : orders)
        {   String proba="";
            connectionFactory = new ConnectionFactory();
             proba = (ClientDAO.findByID(o.getIdClient())).getName();

          //  System.out.println(proba);
            connectionFactory = new ConnectionFactory();
            proba = proba +" "+(ProductDAO.findByID(o.getIdProdus())).getNume();

            //System.out.println(proba);

            proba = proba +" "+o.getNumberOfProducts() +" "+o.getTotal()+"\n";

           // System.out.print(proba);
            strings.add(proba);/**/
        }
       String str=" Nume Client  Nume Produs Cantitate  total (lei)    \n";
     for(String s:strings)
        {
           // System.out.print(s.toString());
            str= str +s.toString();
        }  /* */

        PrintWriter printWriter = new PrintWriter(myWriter);
        printWriter.print(str);
        printWriter.close();

    }




}



