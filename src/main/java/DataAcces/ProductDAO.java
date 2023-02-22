package DataAcces;

import DataAcces.ClientDAO;
import Model.Product;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.*;

/**
 * Clasa este responsabila cu realizarea instructiunilor de insert update delte pe tabelul asociat produsului.
 *
 */
public class ProductDAO {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final String findProduct = " select * from Product where id = ?";

    private static final String displayProducts = "select *from Product";

    private static final String insertStr = "INSERT INTO Product (id,nume,stoc ,pret )"+" VALUES ( ? , ? , ? , ?)";

    private static final String deleteString = "DELETE from Product where id = ?";

    private static final String updateString = "UPDATE Product SET  id = ? , nume = ? , stoc = ? , pret = ?  WHERE id = ? ";


    public static Product findByID(int id)
    {
        Product product = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
            findStatement = connection.prepareStatement(findProduct);
            findStatement.setInt(1,id);

            //System.out.println(findStatement.toString());

            resultSet = findStatement.executeQuery();
            resultSet.next();

            int ID = resultSet.getInt("id");
            int stoc = resultSet.getInt("stoc");
            int pret = resultSet.getInt("pret");
            String name = resultSet.getString("nume");

            product=new Product(ID,name,stoc,pret);

        }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ProductDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

        return product;
    }

    public static List<Product> displayAllProducts()
    {   Product product = null;
        ArrayList<Product> products = new ArrayList<>();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;

        try{
            findStatement = connection.prepareStatement(displayProducts);

            //System.out.println(findStatement.toString());

            resultSet = findStatement.executeQuery();


            while( resultSet.next()){

                int ID = resultSet.getInt("id");
                int stoc = resultSet.getInt("stoc");
                int pret = resultSet.getInt("pret");
                String name = resultSet.getString("nume");

                product=new Product(ID,name,stoc,pret);


                products.add(product);}

        }catch (SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ProductDAO:findById " + ex.getMessage());

        }finally{

            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(connection);

        }

        return products;

    }

    public static int insert(Product product)
    {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedID = -1;

        try{
            insertStatement=connection.prepareStatement(insertStr, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,product.getId());
            insertStatement.setString(2,product.getNume());
            insertStatement.setString(4, String.valueOf(product.getPret()));
            insertStatement.setString(3, String.valueOf(product.getStoc()));

            insertStatement.executeUpdate();

            ResultSet resultSet = insertStatement.getGeneratedKeys();

            if(resultSet.next())
            {
                insertedID=resultSet.getInt(1);
            }

        }catch(SQLException ex)
        {
            LOGGER.log(Level.WARNING,"DataAcces.ProductDAO:findById " + ex.getMessage());
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
    public static int update (Product product , int id)
    {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        int updateStatus = -1;
        try {
            updateStatement = connection.prepareStatement(updateString);
            updateStatement.setInt(1,product.getId());
            updateStatement.setString(2,product.getNume());
            updateStatement.setString(3, String.valueOf(product.getStoc()));
            updateStatement.setString(4, String.valueOf(product.getPret()));
            updateStatement.setInt(5,id);

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



}
