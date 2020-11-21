/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Beans.Tutor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andriatiana Victor
 */
public class TutorDAOImpl implements TutorDAO{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Tutor TutorUser;
    
    @Override
    public ResultSet getByCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        
        conn = DB.getCo();
        stmt = conn.createStatement();
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = '" + userLoginInput + "' and PASSWORD = '" + userPasswordInput + "'";
        return stmt.executeQuery(queryCount);
    }
}
