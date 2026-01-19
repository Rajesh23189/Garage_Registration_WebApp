package Controller;

import Model.Registration_DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Registration_DB;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/registerUser")
public class Registration extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
    {
            String fullname = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");





        try
        {
            Registration_DB registrationDb = new Registration_DB();
            boolean unique_email = registrationDb.Check_Email_Present_Or_Not(email);

            if(unique_email)
            {

                //set data
                registrationDb.setEmail(email);
                registrationDb.setFullName(fullname);
                registrationDb.setPhone(phone);
                registrationDb.setPassword(password);

                //executed Update
                int row  = registrationDb.Register();
                System.out.println(row);
                if(row != 0)
                {
                    response.sendRedirect("register-success.html");
                }
                else
                {
                    response.sendRedirect("register-unsuccess.html");
                }

            }
            else
            {
                response.sendRedirect("register-unsuccess.html");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}

