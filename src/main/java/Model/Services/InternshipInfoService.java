/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Model.Beans.InternshipInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public class InternshipInfoService {
    public InternshipInfo getInternshipInfoById(int id) throws SQLException{
        InternDAO internDAO = new InternDAOImpl();
        ResultSet rs = internDAO.getInfoByTutorID(id);
        if (rs.next()) {
            InternshipInfo Internship = new InternshipInfo();
            Internship.setInternshipId(rs.getInt("INTERNSHIP_ID"));
            //Internship.setCompany() needs to be implemented in a service
            Internship.setMaster(rs.getString("MASTER"));
            Internship.setDateDebut(rs.getDate("START_DATE"));
            Internship.setDateFin(rs.getDate("END_DATE"));
            Internship.setDescription(rs.getString("DESCRIPTION"));
            Internship.setMeetingInfo(rs.getString("MEETING_INFO"));
            Internship.setInternComment(rs.getString("INTERN_COMMENT"));
            Internship.setTutorComment(rs.getString("TUTOR_COMMENT"));
            Internship.setLinkedinProfile(rs.getString("LINKEDIN_PROFILE"));
            
            return Internship;
            
        } else {
            return null;
        }
    }
}
