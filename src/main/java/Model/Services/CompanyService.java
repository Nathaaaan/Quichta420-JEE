/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Database.TutorDAO;
import Database.TutorDAOImpl;
import Entities.CompanyEntity;
import Model.Beans.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
public class CompanyService {
    
    public Company createCompany(CompanyEntity ce) throws SQLException{
        Company company = new Company();
        company.setCompanyId(ce.getCompanyId());
        company.setCompanyName(ce.getCompanyName());
        company.setCompanyAddress(ce.getCompanyAdress());
        
        return company;
    }
    
    /*public ArrayList<Company> getAllCompany() throws SQLException{
        InternDAOImpl intern = new InternDAOImpl();
        ResultSet rs = intern.getAllCompanies();
        
        ArrayList<Company> companies = new ArrayList<Company>();
        while(rs.next()){
            Company company = createCompany(rs);
            companies.add(company);
        }
        
        return companies;
    }*/
    
    public Company getCompanyById(int id) throws SQLException{
        InternDAO internDAO=new InternDAOImpl();
        CompanyEntity ce = internDAO.getCompanyById(id);
        
        if(ce!= null){
            return createCompany(ce);
        }else{
            return null;
        }
    }
}
