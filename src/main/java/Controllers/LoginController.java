package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Tutor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.BD;
//import Controllers.WelcomePageController;
/**
 *
 * @author natha
 */
public class LoginController extends HttpServlet {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Tutor TutorUser = new Tutor();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Redirect to index.jsp when GET Method
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //POST METHOD
        //Retrieve what the user has entered
        String userLoginInput = request.getParameter("UsernameForm");
        String userPasswordInput = request.getParameter("PassForm");

        //Now, we need to connect on the database and checks if a couple for this login
        //login/password exists
        try {
            conn = BD.getCo();
            stmt = conn.createStatement();
            //TODO Eviter l'exception
            String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = '" + userLoginInput + "' and PASSWORD = '" + userPasswordInput + "'";
            rs = stmt.executeQuery(queryCount);

            //Si le nombre de rows est supérieur à 0, alors ça signifie que l'input est bon
            if (rs.next()) {
                //User est logged

                TutorUser.setId(rs.getInt("TUTOR_ID"));
                TutorUser.setName(rs.getString("FIRST_NAME"));
                TutorUser.setLastName(rs.getString("LAST_NAME"));
                TutorUser.setLogin(rs.getString("LOGIN"));
                TutorUser.setPassword(rs.getString("PASSWORD"));

                request.setAttribute("keyTutorUser", TutorUser);

                // redirects to welcome page controller 
                response.sendRedirect("WelcomePageController");
                
                //request.getRequestDispatcher("/WelcomePageController").forward(request, response);
            } else { //Invalid Login : Redirect to index.jsp and set KeyErrMess in order to display it
                request.setAttribute("KeyErrMess", "Invalid Login or Password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
