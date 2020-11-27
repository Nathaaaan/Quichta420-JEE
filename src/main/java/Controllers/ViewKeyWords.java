/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.InternDAOImpl;
import Model.Beans.Assign;
import Model.Beans.KeyWord;
import Model.Services.AssignService;
import Model.Services.KeyWordService;
import Utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gohu
 */
public class ViewKeyWords extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int internshipId = Integer.parseInt(request.getParameter("internship_id"));
        KeyWordService keyWordService = new KeyWordService();
        ArrayList<String> otherkeyWords = keyWordService.getAllKeyWordsExceptOf(internshipId);
        ArrayList<String> myKeyWords = keyWordService.getAllKeyWordsOf(internshipId);

        request.setAttribute("otherKey", otherkeyWords);
        request.setAttribute("myKey", myKeyWords);

        AssignService assignService = new AssignService();
        Assign assign = assignService.getAssignByInternshipId(internshipId);
        request.setAttribute("assign",assign);

        request.getRequestDispatcher(Constants.KEY_WORDS_PAGE).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
