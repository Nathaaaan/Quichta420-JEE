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

/**
 *
 * @author natha
 */
public class LoginController extends HttpServlet {
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Tutor TutorUser = new Tutor();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    /*if(request.getMethod().equals("POST")){
    this.doGet(request, response);
    }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This code is executed when the user clicks on the login button
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //processRequest(request, response); : DEFAULT CODE
        
        //Retrieve what the user has entered
        String userLoginInput = request.getParameter("UsernameForm");
        String userPasswordInput = request.getParameter("PassForm");

        //Now, we need to connect on the database and checks if a couple for this login
        //login/password exists
        try {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ST2EEDB", "adm", "adm");
        stmt = conn.createStatement();
        //TODO Eviter l'exception
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = '"+userLoginInput+"' and PASSWORD = '"+userPasswordInput+"'";
        System.out.println(queryCount);
        rs = stmt.executeQuery(queryCount);
        
        //Si le nombre de rows est supérieur à 0, alors ça signifie que l'input est bon
        if(rs.next()){
        //User est logged
        
        TutorUser.setId(rs.getInt("TUTOR_ID"));
        TutorUser.setName(rs.getString("FIRST_NAME"));
        TutorUser.setLastName(rs.getString("LAST_NAME"));
        TutorUser.setLogin(rs.getString("LOGIN"));
        TutorUser.setPassword(rs.getString("PASSWORD"));
        request.setAttribute("keyTutorUser", TutorUser);

        request.getRequestDispatcher("Welcome.jsp").forward(request, response);
        
        }
        
        else { //Login Invalid
                request.setAttribute("KeyErrMess", "Invalid Login");
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        
        }
        catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
        



        

        //Create a Tutor object and fill information
    
    
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
