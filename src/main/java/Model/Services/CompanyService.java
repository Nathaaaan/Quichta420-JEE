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
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gohu
 */
public class CompanyService {
    
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
    
    public static void insertCompany(Company company){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(company);
        trans.commit();
    }
}
