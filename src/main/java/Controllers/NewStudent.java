/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.InternDAOImpl;
import Model.Beans.Assign;
import Model.Beans.Company;
import Model.Beans.Intern;
import Model.Beans.InternshipInfo;
import Model.Beans.SchoolGroup;
import Model.Beans.Tutor;
import Model.Services.AssignService;
import Model.Services.CompanyService;
import Model.Services.InternService;
import static Utils.Constants.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        
        InternService internService = new InternService();
        ArrayList<String> schoolGroups = internService.getAllGroups();

        CompanyService cs = new CompanyService();
        ArrayList<Company> companies=null;// = cs.getAllCompany();

        request.setAttribute("schoolGroups", schoolGroups);
        request.setAttribute("companies", companies);

        request.getRequestDispatcher(ADD_STUDENT_PAGE).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String companyIdStr = request.getParameter("company");
        InternDAOImpl internDAOImpl = new InternDAOImpl();

        int companyId;
        if(companyIdStr.equals("new")){
            Company company = new Company();
            company.setCompanyName(request.getParameter("new_name"));
            company.setCompanyAdress(request.getParameter("new_address"));
            //companyId = internDAOImpl.insertCompany(company);
        }
        else{
            companyId = Integer.parseInt(companyIdStr);
        }

        Intern intern = new Intern();
        intern.setFirstName(request.getParameter("firstname"));
        intern.setLastName(request.getParameter("lastname"));
        intern.setSchoolGroup(new SchoolGroup(request.getParameter("schoolGroup")));

        Tutor tutor = new Tutor();
        tutor.setId(((Tutor)request.getSession().getAttribute("user")).getId());

        CompanyService cs = new CompanyService();
        //Company company = cs.getCompanyById(companyId);

        InternshipInfo info = new InternshipInfo();
        //info.setCompany(company);
        info.setMaster(request.getParameter("master"));
        info.setDateDebut(Date.valueOf(request.getParameter("startDate")));
        info.setDateFin(Date.valueOf(request.getParameter("endDate")));

        Assign assign = new Assign();
        assign.setIntern(intern);
        assign.setTutor(tutor);
        assign.setInternshipInfo(info);

        AssignService assignService = new AssignService();
        //assignService.insertAssign(assign);

        response.sendRedirect("WelcomeController");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
