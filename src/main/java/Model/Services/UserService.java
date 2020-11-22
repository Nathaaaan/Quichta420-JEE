/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.TutorDAO;
import Database.TutorDAOImpl;
import Model.Beans.Tutor;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Provides a set of services used for data processing on the user data
 * (here tutor).
 * @author Andriatiana Victor
 */
public class UserService {
    
    
    public static Tutor getByCredentials(String userLoginInput, String userPasswordInput) throws RuntimeException,SQLException{
        
        TutorDAO tutorDAO = new TutorDAOImpl();
        ResultSet rs = tutorDAO.getByCredentials(userLoginInput, userPasswordInput);
        //Si le nombre de rows est supérieur à 0, alors ça signifie que l'input est bon
        if (rs.next()) {
            
            Tutor TutorUser = new Tutor();
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
    
    public static boolean isGoodCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        return getByCredentials(userLoginInput, userPasswordInput)!= null;
    }
}
