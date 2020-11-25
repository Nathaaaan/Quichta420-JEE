package Model.Services;

import Model.Beans.Company;
import Model.Beans.InternshipInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides methods used to do CRUD operations on InternshipInfo object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class InternshipInfoService {
    
    /**
     * Creates an Company model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet object
     * @return Company object (Bean)
     * @throws SQLException 
     */
    public Company createCompanyModel(ResultSet rs) throws SQLException{
        Company company = new Company();
        company.setCompanyId(rs.getInt("COMPANY_ID"));
        company.setCompanyName(rs.getString("COMPANY_NAME"));
        company.setCompanyAddress(rs.getString("COMPANY_ADRESS"));
        return company;
    }
    
    /**
     * Creates an InternshipInfo model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet object
     * @return InternshipInfo object (Bean)
     * @throws SQLException 
     */
    public InternshipInfo createInternshipModel(ResultSet rs) throws SQLException{
        InternshipInfo Internship = new InternshipInfo();
        Internship.setInternshipId(rs.getInt("INTERNSHIP_ID"));
        Internship.setMaster(rs.getString("MASTER"));
        Internship.setDateDebut(rs.getDate("START_DATE"));
        Internship.setDateFin(rs.getDate("END_DATE"));
        Internship.setDescription(rs.getString("DESCRIPTION"));
        Internship.setMeetingInfo(rs.getString("MEETING_INFO"));
        Internship.setTutorComment(rs.getString("TUTOR_COMMENT"));
        
        Internship.setCompany(createCompanyModel(rs));
        return Internship;
    }
}
