package Model.Services;

import Model.Beans.Assign;
import Model.Beans.Excel;
import static Utils.Constants.PERSISTENCE_UNIT;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Provides methods used to do CRUD operations on Assign object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class AssignService {
    
    /**
     * Returns the list of all interns assigned to a tutor.
     * @param id
     * @return ArrayList of Assign object. 
     */
    public static ArrayList<Assign> getAllByTutorId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Assign> query = em.createQuery("SELECT a FROM Assign a WHERE a.tutor.id = :id",Assign.class);
        query.setParameter("id", id);
        List<Assign> res = query.getResultList();
        em.clear();
        emf.close();
        //returns list
        return new ArrayList<>(res);
    }

    public static void insertAssign(Assign assign){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        Assign assignIns = new Assign();
        em.persist(assign.getIntern());
        assignIns.setIntern(assign.getIntern());
        assignIns.setTutor(assign.getTutor());
        em.persist(assignIns);
        em.flush();
        assign.setInternshipId(assignIns.getInternshipId());
        assign.setExcel(new Excel());
        assign.getExcel().setInternshipId(assignIns.getInternshipId());
        assign.getInternshipInfo().setInternshipId(assignIns.getInternshipId());
        System.out.println(assign.getTutor().getId());
        System.out.println(assign.getIntern().getInternId());
        em.persist(assign.getExcel());
        em.persist(assign.getInternshipInfo());
        em.flush();
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Assign getAssignByInternshipId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        return em.find(Assign.class, id);
    }
}
