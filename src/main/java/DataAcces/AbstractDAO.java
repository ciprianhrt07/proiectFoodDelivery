package DataAcces;

import Model.Client;
import Model.Orders;
import Model.Product;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.*;


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    private String createInsertQuery(String parameters , String values) {

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");                             //insert
        sb.append(" INTO ");                              //into
        sb.append(type.getSimpleName());                  //tableName
        sb.append(" ( ");                                  //(

        sb.append(parameters);

        sb.append(" ) ");                                   // )

        sb.append(" values ");

        sb.append(" ( ");

        sb.append(values);

        sb.append(" ) ");

       return sb.toString();

    }

    public String createUpdateQuery(ArrayList<String> parametersToUpdate, ArrayList<String> values,String parametersToSearch){

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");

        for(int i=0;i<parametersToUpdate.size();i++)
        {sb.append(parametersToUpdate.get(i)+" = ");
         sb.append(values.get(i)+" ");

         if(i< parametersToUpdate.size()-1)
             sb.append(" , ");
        }

        sb.append(" WHERE ");

        sb.append(parametersToSearch);



        return sb.toString();
    }



    public List<T> findAll() {
        // TODO:
        Connection connection = null;                             // face conexiunea la BD
        PreparedStatement statement = null;                       // preia query-ul ce va fi executat
        ResultSet resultSet = null;                               // memoreaza rezultatul
        List<T> returnedList;
        String query = createSelectQuery("");                // select* from type.Name where =?

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            returnedList = createObjects(resultSet);
            return returnedList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public T insert(T t) {
        // TODO:

        Connection connection = null;
        PreparedStatement statement = null;

        String parameters="";
        String values ="";

        if(t.getClass().getName().equals("Model.Client"))
        {

           parameters=" id , name , adress , email , age ";

           values=" "+((Client)t).getId()+" , '"+((Client)t).getName()+"' , '"+((Client)t).getAdress()+"' , '"+((Client)t).getEmail()+"' , "+((Client)t).getAge();

        }else
        if(t.getClass().getName().equals("Model.Product"))
        {

            parameters=" id , nume , stoc , pret";

            values=" "+((Product)t).getId()+" , '"+ ((Product)t).getNume()+"' , "+ ((Product)t).getStoc()+" , "+ ((Product)t).getPret();

        }else
        if(t.getClass().getName().equals("Model.Orders"))
        {

            parameters= " id , numberOfProducts , idClient , idProdus , total";
            values =((Orders)t).getId()+" , "+((Orders)t).getNumberOfProducts()+" , "+((Orders)t).getIdClient()+" , "+((Orders)t).getIdProdus()+" , "+((Orders)t).getTotal();
        }


        String query = createInsertQuery(parameters,values);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeQuery();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {

            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }


        return null;
    }

  /*  public T update(T t,String newValues) {
        // TODO:

        Connection connection = null;
        PreparedStatement statement = null;

    //    String query = createUpdateQuery("id",);
        try {
            connection = Connection.ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            Connection.ConnectionFactory.close(resultSet);
            Connection.ConnectionFactory.close(statement);
            Connection.ConnectionFactory.close(connection);
        }
        return null;
        */


    //    return null;
    //}

    public Class<T> getType() {
        return type;
    }
}
