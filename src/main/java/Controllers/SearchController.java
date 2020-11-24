/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.SearchRS;
import Model.Beans.Assign;
import Model.Beans.Tutor;
import Model.Services.AssignService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static Utils.Constants.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class SearchController extends HttpServlet {

    
    private SearchRS srrs = new SearchRS();
    private ArrayList<Assign> assignList;
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
        //processRequest(request, response);
        //We use the search for a POST method, so we don't really care about this method
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //TODO : Search analyse
       //Get the input in a String value;
       String UserInput;
       UserInput = request.getParameter(SEARCH_INPUT);
       
       //If the user has at least input something
       if(!UserInput.equals("")){
       
           //Now we have 2 cases : One for the year, and another one for names and keywords
           //So for the year stuff
           
//If it contains ONLY numbers
           if (UserInput.matches("[0-9]+") && UserInput.length() > 2) {
               //Now we need
                //- Search the Assign where Internship_Year is equal to the input
                Tutor tutor = (Tutor)request.getSession().getAttribute("user");
               try {
                   //List of Assign
                   assignList = new AssignService().getAllByTutorIdAndYear(tutor.getId(), UserInput);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
               }
                ResultSet rs_year;
                //- We can now gather Internship ID of the stuff
               //- We can now select that Internship Info
               
               
           }
       
       }
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
