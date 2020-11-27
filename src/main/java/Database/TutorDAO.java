package Database;

import Entities.TutorEntity;
import java.sql.SQLException;
import javax.ejb.Local;

/**
 * A Data access object used for doing basic CRUD operations on Tutor table from
 * the database.
 * Provides methods for running operations on the database using queries.
 * @author Andriatiana Victor
 */

public interface TutorDAO {
    
    /**
     * Return a row (if any) from the Tutor table of the Database, based on the given 
     * credentials.
     * @param userLoginInput
     * @param userPasswordInput
     * @return ResultSet : Tutor table row that has the same username and password as given in the parameters
     * @throws RuntimeException
     * @throws SQLException 
     */
    public TutorEntity getByCredentials(String userLoginInput, String userPasswordInput);
}
