package Model.Services;


import Database.InternDAOImpl;
import Entities.InternEntity;
import Model.Beans.Intern;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public Intern createInternModel(InternEntity ie) throws SQLException {
        Intern intern = new Intern();
        intern.setId(ie.getInternId());
        intern.setFirstName(ie.getFirstName());
        intern.setLastName(ie.getLastName());
        intern.setSchoolGroup(ie.getSchoolgroupName().getSchoolgroupName());
        return intern;
    }
    
    public ArrayList<String> getAllGroups() throws SQLException{
        ArrayList<String> groups = new ArrayList<String>();
        InternDAOImpl intern = new InternDAOImpl();
        
        ResultSet rs = intern.getAllGroups();
        while(rs.next()){
            groups.add(rs.getString("schoolGroup_name"));
        }
        return groups;
    }
}
