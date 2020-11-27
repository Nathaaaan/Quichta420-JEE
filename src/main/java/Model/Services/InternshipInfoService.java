package Model.Services;

import Model.Beans.InternshipInfo;
import static Utils.Constants.PERSISTENCE_UNIT;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Provides methods used to do CRUD operations on InternshipInfo object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class InternshipInfoService {
    
    
    public static void updateInternshipInfo(InternshipInfo info){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(info);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
