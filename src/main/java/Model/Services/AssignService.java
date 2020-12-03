package Model.Services;

import Model.Beans.Assign;
import static Utils.Constants.PERSISTENCE_UNIT;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        TypedQuery<Assign> query = em.createQuery("SELECT a FROM Assign a WHERE a.tutorId.tutorId = :id",Assign.class);
        query.setParameter("id", id);
        List<Assign> res = query.getResultList();
        //returns list
        return new ArrayList<>(res);
    }
    /*
    public void insertAssign(Assign assign) throws SQLException{
        InternDAOImpl internDAOImpl = new InternDAOImpl();
        int internId = internDAOImpl.insertIntern(assign.getIntern());
        int tutorId = assign.getTutor().getId();
        
        int internshipId = internDAOImpl.insertAssign(internId,tutorId);
        
        internDAOImpl.insertExcel(internshipId);
        
        InternshipInfo info = assign.getInternshipInfo();
        info.setInternshipId(internshipId);
        internDAOImpl.insertInternshipInfo(info);
    }*/
    
    public static Assign getAssignByInternshipId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        return em.find(Assign.class, id);
    }
}
