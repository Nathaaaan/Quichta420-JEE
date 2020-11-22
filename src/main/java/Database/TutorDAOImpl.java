/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
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
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = '" + userLoginInput + "' and PASSWORD = '" + userPasswordInput + "'";
        return stmt.executeQuery(queryCount);
    }
}
