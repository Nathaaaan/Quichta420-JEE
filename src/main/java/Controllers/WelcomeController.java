/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.DB;
import Model.Beans.Excel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Utils.Constants.*;

/**
 *
 * @author seedy
 */
@WebServlet(name = "WelcomeController", urlPatterns = {"/WelcomeController"})
public class WelcomeController extends HttpServlet {
    
    private ArrayList<Excel> excelList;        
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

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
//        processRequest(request, response);

try {
            // processRequest(request, response);
            
            // init DB values
            conn = DB.getCo();
            stmt = conn.createStatement();
            
            String getAll = "SELECT * FROM EXCEL";
            
            rs = stmt.executeQuery(getAll);
            excelList = new ArrayList<Excel>();

            while(rs.next()){ // get all the excels
                System.out.println("hahaha: "+rs.getInt("EXCEL_ID"));
                
                Excel studentInfo = new Excel();
                
                studentInfo.setExcelId(rs.getInt("EXCEL_ID"));
                studentInfo.setCdc(rs.getBoolean("CDC"));
                studentInfo.setFicheVisite(rs.getBoolean("FICHE_VISITE"));
                studentInfo.setFicheEvalEntr(rs.getBoolean("FICHE_EVAL_ENTR"));
                studentInfo.setSondageWeb(rs.getBoolean("SONDAGE_WEB"));
                studentInfo.setRapportRendu(rs.getBoolean("RAPPORT_RENDU"));
                studentInfo.setSout(rs.getBoolean("SOUT"));
                studentInfo.setPlanif(rs.getBoolean("PLANIF"));
                studentInfo.setFaite(rs.getBoolean("FAITE"));
                studentInfo.setNoteTech(rs.getInt("NOTE_TECH"));
                studentInfo.setNoteCom(rs.getInt("NOTE_COM"));
                
                        
                excelList.add(studentInfo);
            }
            
            request.setAttribute("keyExcel", excelList);
            
            //request.getRequestDispatcher(Wel).forward(request, response);
            request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);

                    
            
        }
         catch (SQLException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
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
        processRequest(request, response);
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
