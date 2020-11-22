package Model.Services;

import Model.Beans.Intern;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides methods used to do CRUD operations on Intern object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class InternService {
    
    /**
     * Creates an Intern model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet Object
     * @return Intern object (Bean)
     * @throws SQLException 
     */
    public Intern createInternModel(ResultSet rs) throws SQLException {
        Intern intern = new Intern();
        intern.setId(rs.getInt("INTERN_ID"));
        intern.setFirstName(rs.getString("FIRST_NAME"));
        intern.setLastName(rs.getString("LAST_NAME"));
        intern.setSchoolGroup(rs.getString("SCHOOLGROUP_NAME"));
        return intern;
    }
}
