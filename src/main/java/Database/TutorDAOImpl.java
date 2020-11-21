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
    public Tutor getByCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        
        conn = DB.getCo();
        stmt = conn.createStatement();
        String queryCount = "SELECT * FROM TUTOR WHERE LOGIN = '" + userLoginInput + "' and PASSWORD = '" + userPasswordInput + "'";
        rs = stmt.executeQuery(queryCount);

        //Si le nombre de rows est supérieur à 0, alors ça signifie que l'input est bon
        if (rs.next()) {
            
            TutorUser = new Tutor();
            TutorUser.setId(rs.getInt("TUTOR_ID"));
            TutorUser.setName(rs.getString("FIRST_NAME"));
            TutorUser.setLastName(rs.getString("LAST_NAME"));
            TutorUser.setLogin(rs.getString("LOGIN"));
            TutorUser.setPassword(rs.getString("PASSWORD"));
            System.out.println("File found");
            return TutorUser;
            
        } else {
            return null;
        }
    }
}
