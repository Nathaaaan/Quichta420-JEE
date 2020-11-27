package Model.Services;

import Model.Beans.Tutor;
import static Utils.Constants.PERSISTENCE_UNIT;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 * Provides methods used to do CRUD operations on Tutor object (the user)
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class UserService {
    
    /**
     * Provides a Tutor model from the given credentials information if it 
     * exists in the database. The method will return null if not.
     * @param userLoginInput
     * @param userPasswordInput
     * @return Tutor object (Bean)
     */
    public static Tutor getByCredentials(String userLoginInput, String userPasswordInput){
        String jql = "SELECT t FROM Tutor t WHERE t.login = :login AND t.password = :password";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tutor> query = em.createQuery(jql, Tutor.class);
        query.setParameter("login", userLoginInput);
        query.setParameter("password", userPasswordInput);
        try{
            Tutor tutor = query.getSingleResult();
            return tutor;
        }
        catch(NoResultException e){
            System.out.println("Failed authentification");
            return null;
        }
    }

}
