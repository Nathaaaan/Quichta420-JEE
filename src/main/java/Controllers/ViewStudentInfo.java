package Controllers;

import Database.InternDAOImpl;
import Model.Beans.Assign;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Beans.Intern;
import Model.Beans.InternshipInfo;
import Model.Services.AssignService;
import static Utils.Constants.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gohu
 */
@WebServlet(name = "ViewStudentInfo", urlPatterns = {"/ViewStudentInfo"})
public class ViewStudentInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //On doit recuperer les infos dans la database grace a cet ID
        System.out.println("Internship ID in ViewStudentInfo: "+request.getParameter("internshipId"));
        
        int internshipId = Integer.parseInt(request.getParameter("internshipId"));
       
        
        try {
            InternDAOImpl internDaoImpl = new InternDAOImpl();
            AssignService assignService = new AssignService();
            ResultSet rs = internDaoImpl.getAssignByInternshipId(internshipId);
            rs.next();
            Assign assign = assignService.createAssignModel(rs);
            
            Intern intern = assign.getIntern();
            InternshipInfo info = assign.getInternshipInfo();
        
            request.setAttribute("intern", intern);
            request.setAttribute("info", info);
            request.getRequestDispatcher(STUDENT_PAGE).forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentInfo.class.getName()).log(Level.SEVERE, null, ex);
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
