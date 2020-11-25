/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Beans.Company;
import Model.Services.CompanyService;
import Model.Services.InternService;
import static Utils.Constants.*;
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
 * @author seedy
 */
public class NewStudent extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            InternService internService = new InternService();
            ArrayList<String> schoolGroups = internService.getAllGroups();
            
            CompanyService cs = new CompanyService();
            ArrayList<Company> companies = cs.getAllCompany();

            request.setAttribute("schoolGroups", schoolGroups);
            request.setAttribute("companies", companies);

            request.getRequestDispatcher(ADD_STUDENT_PAGE).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(NewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
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
