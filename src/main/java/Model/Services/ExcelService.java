package Model.Services;

import Model.Beans.Excel;
import static Utils.Constants.PERSISTENCE_UNIT;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Provides methods used to do CRUD operations on Excel
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class ExcelService {

    ExcelService() {}
    
    public static void updateExcel(Excel excel){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(excel);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
