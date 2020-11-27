package Model.Services;

import Entities.InternshipinfoEntity;
import Model.Beans.Company;
import Model.Beans.InternshipInfo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides methods used to do CRUD operations on InternshipInfo object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class InternshipInfoService {
    
    
    
    /**
     * Creates an InternshipInfo model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet object
     * @return InternshipInfo object (Bean)
     * @throws SQLException 
     */
    public InternshipInfo createInternshipModel(InternshipinfoEntity infoEntity) throws SQLException{
        InternshipInfo Internship = new InternshipInfo();
        Internship.setInternshipId(infoEntity.getInternshipId());
        Internship.setMaster(infoEntity.getMaster());
        Internship.setDateDebut((Date) infoEntity.getStartDate());
        Internship.setDateFin((Date) infoEntity.getEndDate());
        Internship.setDescription(infoEntity.getDescription());
        Internship.setMeetingInfo(infoEntity.getMeetingInfo());
        Internship.setTutorComment(infoEntity.getTutorComment());
        
        Internship.setCompany(CompanyService.createCompany(infoEntity.getCompanyId()));
        return Internship;
    }
}
