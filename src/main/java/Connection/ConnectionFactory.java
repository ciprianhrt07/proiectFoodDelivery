package Connection;

import java.sql.*;

/**
 * Clasa realizeaza conexiunea la baza de date MYSQL
 * folosind credentialele si validandu-le
 *
 */

public class ConnectionFactory {


    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String DB_NAME = "schooldb";
    private final static String CONNECTION_LINK = "jdbc:mysql://localhost:3306/";
    private static Connection connection = null;

    /**
     * Metoda verifica introducerea corecta a credentialelor si in caz  de succes face conexiunea
     * altfel arunca o exceptie
     */
    public ConnectionFactory()
    {
         try {
            connection = DriverManager.getConnection(CONNECTION_LINK+DB_NAME, USERNAME, PASSWORD);
            System.out.println("Connection succeded");
          } catch (SQLException e) {
            System.out.println("An error occured while trying to connect to the database");
            e.printStackTrace();
         }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionFactory.connection = connection;
    }

    public static void close(Statement statement) {

       if(statement!=null) {
           try {
               statement.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    public static void close(ResultSet resultSet)
    {
       if(resultSet!=null) {
           try {
               resultSet.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

    }

    public static void close(Connection connection)
    {
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Inchiderea conexiunii variabila in functie de parametrii de pe intrarea doriti
     */
    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Eroare la inchiderea conexiunii");
            e.printStackTrace();
        }

    }
}
