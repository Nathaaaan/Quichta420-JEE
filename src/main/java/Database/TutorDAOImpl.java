package Database;

import Entities.TutorEntity;
import static Utils.Constants.PERSISTENCE_UNIT;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * A Data access object used for doing basic CRUD operations on Tutor table from
 * the database.
 * Provides methods for running operations on the database using queries.
 * Implementation of the TutorDAO interface.
 * @author Andriatiana Victor
 */

public class TutorDAOImpl implements TutorDAO{
    
    //@PersistenceContext( unitName = PERSISTENCE_UNIT )
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private static final String JQL_SELECT_BY_CREDENTIAL ="SELECT t FROM TutorEntity t WHERE t.login = :login AND t.password = :password";
    private static final String PARAM_LOGIN ="login";
    private static final String PARAM_PASSWORD ="password";
    public TutorDAOImpl(){
        
    }
    
    /**
     * Return a row (if any) from the Tutor table of the Database, based on the given 
     * credentials.
     * @param userLoginInput
     * @param userPasswordInput
     * @return ResultSet : Tutor table row that has the same username and password as given in the parameters
     * @throws RuntimeException
     */
    @Override
    public TutorEntity getByCredentials(String userLoginInput, String userPasswordInput){
        
        try{
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            em = emf.createEntityManager();
            TypedQuery<TutorEntity> query = em.createQuery(JQL_SELECT_BY_CREDENTIAL,TutorEntity.class);
            query.setParameter(PARAM_LOGIN, userLoginInput);
            query.setParameter (PARAM_PASSWORD, userPasswordInput);
            
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
