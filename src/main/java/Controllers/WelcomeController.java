/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Beans.Assign;
import Model.Beans.InternshipInfo;
import Model.Beans.KeyWord;
import Model.Beans.Tutor;
import Model.Services.AssignService;
import Model.Services.KeyWordService;
import java.io.IOException;
import java.sql.SQLException;
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
//        processRequest(request, response);
        Tutor tutor = (Tutor)request.getSession().getAttribute("user");

        ArrayList<Assign> assignList = new AssignService().getAllByTutorId(tutor.getTutorId());

        request.setAttribute("keyExcel", assignList);

        //request.getRequestDispatcher(Wel).forward(request, response);
        request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String search = request.getParameter("search");
        System.out.println(search);
        Tutor tutor = (Tutor)request.getSession().getAttribute("user");
        ArrayList<Assign> assignList = new AssignService().getAllByTutorId(tutor.getTutorId());

        ArrayList<Assign> assignSearch = searchPerform(search.toLowerCase(),assignList);

        request.setAttribute("keyExcel", assignSearch);
        request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
    }

    public ArrayList<Assign> searchPerform(String search,ArrayList<Assign> assignList){
        if(search.equals("")){
            return assignList;
        }

        ArrayList<Integer> internshipIds = new ArrayList<Integer>();
        KeyWordService keyWordService = new KeyWordService();
        ArrayList<KeyWord> keyWords = keyWordService.getAllKeyWords();

        for(KeyWord keyWord : keyWords){
            if(keyWord.getKeyWord().toLowerCase().contains(search) || search.contains(keyWord.getKeyWord().toLowerCase())){
                for(InternshipInfo info : keyWord.getInternshipinfoCollection()){
                    internshipIds.add(info.getInternshipId());
                }
            }
        }

        ArrayList assignSearch = new ArrayList<Assign>();

        for(Assign assign : assignList){
            String firstName = assign.getInternId().getFirstName().toLowerCase();
            String lastName = assign.getInternId().getLastName().toLowerCase();
            String companyName = assign.getInternshipInfo().getCompanyId().getCompanyName().toLowerCase();
            String master = assign.getInternshipInfo().getMaster().toLowerCase();
            String startYear = ""+(assign.getInternshipInfo().getStartDate().getYear()+1900);
            String endYear = ""+(assign.getInternshipInfo().getEndDate().getYear()+1900);

            if(internshipIds.contains(assign.getInternshipInfo().getInternshipId())){
                assignSearch.add(assign);
            }
            else if(firstName.contains(search) || search.contains(firstName)){
                assignSearch.add(assign);
            }
            else if(lastName.contains(search) || search.contains(lastName)){
                assignSearch.add(assign);
            }
            else if(companyName.contains(search) || search.contains(companyName)){
                assignSearch.add(assign);
            }
            else if(master.contains(search) || search.contains(master)){
                assignSearch.add(assign);
            }
            else if(search.contains(startYear)){
                assignSearch.add(assign);
            }
            else if(search.contains(endYear)){
                assignSearch.add(assign);
            }
        }

        return assignSearch;
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
