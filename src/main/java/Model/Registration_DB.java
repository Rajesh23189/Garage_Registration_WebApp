package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Registration_DB {

    String fullName;
    String email;
    String phone;
    String password;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

   public Registration_DB()
   {

   }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int Register()  throws SQLException
    {

           connection = JDBC_Util_Class.getConnection();
           preparedStatement = connection.prepareStatement("INSERT INTO Register(email,fullname,phone,password) VALUES(?,?,?,?)");
           preparedStatement.setString(1,email);
           preparedStatement.setString(2,fullName);
           preparedStatement.setString(3,phone);
           preparedStatement.setString(4,password);
           int row_effect =  preparedStatement.executeUpdate();
           preparedStatement.close();



           //connection close
           JDBC_Util_Class.closeConnection(connection,preparedStatement);
           return row_effect;
    }



    public boolean Check_Email_Present_Or_Not(String email)
    {
        try
        {
            connection = JDBC_Util_Class.getConnection();
            preparedStatement = connection.prepareStatement("SELECT 1 FROM Register WHERE email = ?");
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                return false;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return true;
    }


    @Override
    public String toString() {
        return "Registration_DB{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", connection=" + connection +
                ", preparedStatement=" + preparedStatement +
                '}';
    }
}
