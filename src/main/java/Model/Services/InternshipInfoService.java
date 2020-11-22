/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;



import Database.InternDAO;
import Database.InternDAOImpl;
import Model.Beans.Company;
import Model.Beans.InternshipInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public class InternshipInfoService {
    
    
    public Company createCompanyModel(ResultSet rs) throws SQLException{
        Company company = new Company();
        company.setCompanyId(rs.getInt("COMPANY_ID"));
        company.setCompanyName(rs.getString("COMPANY_NAME"));
        company.setCompanyAddress(rs.getString("COMPANY_ADRESS"));
        return company;
    }
    
    public InternshipInfo createInternshipModel(ResultSet rs) throws SQLException{
        InternshipInfo Internship = new InternshipInfo();
        Internship.setInternshipId(rs.getInt("INTERNSHIP_ID"));
        Internship.setMaster(rs.getString("MASTER"));
        Internship.setDateDebut(rs.getDate("START_DATE"));
        Internship.setDateFin(rs.getDate("END_DATE"));
        Internship.setDescription(rs.getString("DESCRIPTION"));
        Internship.setMeetingInfo(rs.getString("MEETING_INFO"));
        Internship.setInternComment(rs.getString("INTERN_COMMENT"));
        Internship.setTutorComment(rs.getString("TUTOR_COMMENT"));
        Internship.setLinkedinProfile(rs.getString("LINKEDIN_PROFILE"));
        
        Internship.setCompany(createCompanyModel(rs));
        Internship.setExcel(new ExcelService().createExcelModel(rs));
        return Internship;
    }
    
    /*public InternshipInfo getInternshipInfoById(int tutorId) throws SQLException{
        InternshipInfoDAO internDAO = new InternshipInfoDAOImpl();
        ResultSet rs = internDAO.getInfoByTutorID(tutorId);
        if (rs.next()) {
            InternshipInfo Internship = new InternshipInfo();
            Internship.setInternshipId(rs.getInt("INTERNSHIP_ID"));
            Internship.setMaster(rs.getString("MASTER"));
            Internship.setDateDebut(rs.getDate("START_DATE"));
            Internship.setDateFin(rs.getDate("END_DATE"));
            Internship.setDescription(rs.getString("DESCRIPTION"));
            Internship.setMeetingInfo(rs.getString("MEETING_INFO"));
            Internship.setInternComment(rs.getString("INTERN_COMMENT"));
            Internship.setTutorComment(rs.getString("TUTOR_COMMENT"));
            Internship.setLinkedinProfile(rs.getString("LINKEDIN_PROFILE"));
            
            //Internship.setCompany() takes a Company object as a parameter
            Internship.setCompany(getCompanyById(rs.getInt("COMPANY_ID")));
            
            return Internship;
            
        } else {
            return null;
        }
    }*/
    
    /*public Company getCompanyById(int companyId)throws SQLException{
        InternDAO internDAO = new InternDAOImpl();
        ResultSet rs = internDAO.getCompanyById(companyId);
        if(rs.next()){
            Company company = new Company();
            company.setCompanyId(rs.getInt("COMPANY_ID"));
            company.setCompanyName(rs.getString("COMPANY_NAME"));
            company.setCompanyAddress(rs.getString("COMPANY_ADRESS"));
            return company;
        }else{
            return null;
        }
    }*/
}
