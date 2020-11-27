package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Beans.Tutor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Services.UserService;
import static Utils.Constants.*;

/**
 *
 * @author natha
 */
public class LoginController extends HttpServlet {

    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }*/
    
    @Override
    public void init() {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Redirect to index.jsp when GET Method
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {           
        //Retrieve what the user has entered
        String userLoginInput = request.getParameter(LOGIN_USER);
        String userPasswordInput = request.getParameter(LOGIN_PWD);

        //System.out.println("In login, tutor : "+ us.getByCredentials(userLoginInput, userPasswordInput).getName());
        Tutor user = UserService.getByCredentials(userLoginInput, userPasswordInput);
        //If credentials are in database
        if(user != null){

            request.setAttribute("keyTutorUser", user);
            request.getSession().setAttribute("user", user);
            //request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
            response.sendRedirect("WelcomeController");

        } else{
            //Invalid Login : Redirect to the login page and set KeyErrMess in order to display it
            request.setAttribute("KeyErrMess", "Invalid Login or Password");
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
