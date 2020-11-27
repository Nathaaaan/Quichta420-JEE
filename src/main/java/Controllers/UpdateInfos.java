/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.InternDAOImpl;
import Model.Beans.Excel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static Utils.Constants.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gohu
 */
public class UpdateInfos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("internshipId"));
        Excel excel = new Excel();
        excel.setCdc(getValue(request.getParameter(UP_CDC)));
        excel.setFicheVisite(getValue(request.getParameter(UP_FICHE_VISITE)));
        excel.setFicheEvalEntr(getValue(request.getParameter(UP_FICHE_EVAL)));
        excel.setSondageWeb(getValue(request.getParameter(UP_SONDAGE_WEB)));
        excel.setRapportRendu(getValue(request.getParameter(UP_RAPPORT_RENDU)));
        excel.setSout(getValue(request.getParameter(UP_SOUT)));
        excel.setPlanif(getValue(request.getParameter(UP_PLANIF)));
        excel.setFaite(getValue(request.getParameter(UP_FAITE)));
        excel.setNoteCom(Integer.parseInt(request.getParameter(UP_NOTE_COM)));
        excel.setNoteTech(Integer.parseInt(request.getParameter(UP_NOTE_TECH)));
        excel.setInternshipId(Integer.parseInt(request.getParameter(UP_EXCEL_ID)));

        InternDAOImpl internDao = new InternDAOImpl();
        //internDao.updateExcel(excel);

        response.sendRedirect("WelcomeController");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //return a boolean relative to the ceckbox value
    public boolean getValue(String check){
        return check != null;
    }
}
