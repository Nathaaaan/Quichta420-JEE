/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Services.KeyWordService;
import Utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ManageKeyWords extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int action = Integer.parseInt(request.getParameter("action"));
        if(action == Constants.ACTION_DELETE){
            try {
                String keyWord = request.getParameter("key_word");
                int internshipId = Integer.parseInt(request.getParameter("internship_id"));

                KeyWordService keyWordService = new KeyWordService();
                keyWordService.removeKeyWord(keyWord,internshipId);

                response.sendRedirect("ViewKeyWords?internship_id="+internshipId);
            } catch (SQLException ex) {
                Logger.getLogger(ManageKeyWords.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action == Constants.ACTION_ADD){
            try {
                String keyWord = request.getParameter("key_word");
                int internshipId = Integer.parseInt(request.getParameter("internship_id"));

                KeyWordService keyWordService = new KeyWordService();
                keyWordService.addKeyWord(keyWord,internshipId);

                response.sendRedirect("ViewKeyWords?internship_id="+internshipId);
            } catch (SQLException ex) {
                Logger.getLogger(ManageKeyWords.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String keyWord = request.getParameter("newKeyWord");
            int internshipId = Integer.parseInt(request.getParameter("internshipId"));
            
            KeyWordService keyWordService = new KeyWordService();
            keyWordService.insertKeyWord(keyWord,internshipId);
            
            response.sendRedirect("ViewKeyWords?internship_id="+internshipId);
        } catch (SQLException ex) {
            Logger.getLogger(ManageKeyWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
