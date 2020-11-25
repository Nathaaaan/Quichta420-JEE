package Controllers;

import Database.InternDAOImpl;
import Model.Beans.InternshipInfo;
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
 * @author RyanVHG
 */

public class UpdateInternshipInfos extends HttpServlet {

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
        
        try {
            InternshipInfo internshipInfo = new InternshipInfo();
            
            internshipInfo.setDescription(request.getParameter(UP_DESCRIPTION));
            internshipInfo.setTutorComment(request.getParameter(UP_TUTOR_COMMENT));
            internshipInfo.setMeetingInfo(request.getParameter(UP_MEETING_INFO));
            internshipInfo.setInternshipId(Integer.parseInt(request.getParameter(UP_INTERNSHIP_ID)));
            
            
            InternDAOImpl internDao = new InternDAOImpl();
            internDao.updateInternshipInfo(internshipInfo);
            
            response.sendRedirect("WelcomeController");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateInternshipInfos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}