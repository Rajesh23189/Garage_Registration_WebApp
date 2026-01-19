package Controller;

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


        try
        {
            response.sendRedirect("login-success.html");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
