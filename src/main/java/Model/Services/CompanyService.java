/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Model.Beans.Company;
import static Utils.Constants.PERSISTENCE_UNIT;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gohu
 */
public class CompanyService {
    
    /**
     * Creates an Company model from a CompanyEntity.
     * @param ce ompanyEntity object
     * @return Company object (Bean)
     */
    /*public static Company createCompany(CompanyEntity ce){
        Company company = new Company();
        company.setCompanyId(ce.getCompanyId());
        company.setCompanyName(ce.getCompanyName());
        company.setCompanyAddress(ce.getCompanyAdress());
        
        return company;
    }*/
    
    public static ArrayList<Company> getAllCompany(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Company> query = em.createNamedQuery("Company.findAll",Company.class);
        List<Company> res = query.getResultList();
        //returns list
        return new ArrayList<>(res);
    }
    
    public static Company getCompanyById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        return em.find(Company.class, id);
    }
}
