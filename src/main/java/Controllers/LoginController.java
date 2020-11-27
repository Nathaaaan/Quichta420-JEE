package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Database.DB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Services.UserService;
import static Utils.Constants.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try{
            DB.loadCredentials(getServletContext().getResourceAsStream(DB_CRED));
        }catch(IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        try{
            UserService us = new UserService();
            
            //Retrieve what the user has entered
            String userLoginInput = request.getParameter(LOGIN_USER);
            String userPasswordInput = request.getParameter(LOGIN_PWD);
            
            System.out.println("In login, tutor : "+ us.getByCredentials(userLoginInput, userPasswordInput).getName());
            //If credentials are in database
            if(us.isGoodCredentials(userLoginInput, userPasswordInput)){
                
                request.setAttribute("keyTutorUser", us.getByCredentials(userLoginInput, userPasswordInput));
                request.getSession().setAttribute("user", us.getByCredentials(userLoginInput, userPasswordInput));
                //request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
                response.sendRedirect("WelcomeController");
                
            } else{
                //Invalid Login : Redirect to the login page and set KeyErrMess in order to display it
                request.setAttribute("KeyErrMess", "Invalid Login or Password");
                request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            }
        }catch(RuntimeException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
