/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 *
 * @author natha
 */
public class SearchRS {
    
    
    private final Connection conn;
    private Statement stmt;
    
    public SearchRS(){
    conn = DB.getCo();
    }
    
    public ResultSet getByInput(String userInput)throws RuntimeException,SQLException{
        
        stmt = conn.createStatement();
        
        //SQL Injection protection using prepared statement
        //TODO : Set the correct querry
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = ? AND PASSWORD = ?";
        PreparedStatement ps = conn.prepareStatement(queryCount);
        ps.setString(1,userInput);
        
        return ps.executeQuery();
    }
    
    
}
