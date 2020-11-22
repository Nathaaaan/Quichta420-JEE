package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A Data access object used for doing basic CRUD operations on Tutor table from
 * the database.
 * Provides methods for running operations on the database using queries.
 * Implementation of the TutorDAO interface.
 * @author Andriatiana Victor
 */
public class TutorDAOImpl implements TutorDAO{
    private final Connection conn;
    private Statement stmt;
    
    public TutorDAOImpl(){
        conn = DB.getCo();
    }
    
    /**
     * Return a row (if any) from the Tutor table of the Database, based on the given 
     * credentials.
     * @param userLoginInput
     * @param userPasswordInput
     * @return ResultSet : Tutor table row that has the same username and password as given in the parameters
     * @throws RuntimeException
     * @throws SQLException 
     */
    @Override
    public ResultSet getByCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        
        stmt = conn.createStatement();
        
        //SQL Injection protection using prepared statement
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = ? AND PASSWORD = ?";
        PreparedStatement ps = conn.prepareStatement(queryCount);
        ps.setString(1,userLoginInput);
        ps.setString(2, userPasswordInput);
        
        return ps.executeQuery();
    }
}
