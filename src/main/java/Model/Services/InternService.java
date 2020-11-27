package Model.Services;


import Model.Beans.SchoolGroup;
import static Utils.Constants.PERSISTENCE_UNIT;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Provides methods used to do CRUD operations on Intern object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class InternService {
    
    public static ArrayList<String> getAllGroups(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<SchoolGroup> query = em.createNamedQuery("SchoolGroup.findAll",SchoolGroup.class);
        List<SchoolGroup> res = query.getResultList();
        
        ArrayList<String> groups = new ArrayList<String>();
        for(SchoolGroup group : res){
            groups.add(group.getSchoolgroupName());
        }
        
        return groups;
    }
}
