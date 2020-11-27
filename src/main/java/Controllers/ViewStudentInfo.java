package Controllers;

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
        Assign assign = AssignService.getAssignByInternshipId(internshipId);

        Intern intern = assign.getIntern();
        InternshipInfo info = assign.getInternshipInfo();

        request.setAttribute("intern", intern);
        request.setAttribute("info", info);
        request.getRequestDispatcher(STUDENT_PAGE).forward(request, response);
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
