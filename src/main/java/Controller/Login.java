package Controller;

import Model.JDBC_Util_Class;
import Model.Registration_DB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/loginUser")
public class Login extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
    {
        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");

        Registration_DB registrationDb = new Registration_DB();
        boolean unique_email = registrationDb.Check_Email_Present_Or_Not(email);

        if(unique_email)
        {
            try
            {
                response.sendRedirect("login-success.html");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                response.sendRedirect("login-unsuccess.html");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }




    }
}
