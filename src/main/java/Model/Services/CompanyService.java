/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAOImpl;
import Model.Beans.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
public class CompanyService {
    
    public Company createCompany(ResultSet rs) throws SQLException{
        Company company = new Company();
        company.setCompanyId(rs.getInt("company_id"));
        company.setCompanyName(rs.getString("company_name"));
        company.setCompanyAddress(rs.getString("company_adress"));
        
        return company;
    }
    
    public ArrayList<Company> getAllCompany() throws SQLException{
        InternDAOImpl intern = new InternDAOImpl();
        ResultSet rs = intern.getAllCompanies();
        
        ArrayList<Company> companies = new ArrayList<Company>();
        while(rs.next()){
            Company company = createCompany(rs);
            companies.add(company);
        }
        
        return companies;
    }
    
    public Company getCompanyById(int id) throws SQLException{
        InternDAOImpl intern = new InternDAOImpl();
        ResultSet rs = intern.getCompanyById(id);
        rs.next();
        return createCompany(rs);
    }
}
