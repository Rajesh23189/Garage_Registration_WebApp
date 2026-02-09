package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Util_Class {



    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Driver Is Register");
    }

    public static Connection getConnection() throws SQLException
    {
        final String URL = "jdbc:mysql://localhost:3306/Garage";
        final String USERNAME = "root";
        final String PASSWORD = "Rajesh@289";


        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection , Statement statement) throws SQLException
    {
        if(connection != null)
        {
            connection.close();
        }
        if(statement != null)
        {
            statement.close();
        }
    }
}
