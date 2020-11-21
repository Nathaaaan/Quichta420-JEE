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

/**
 * Provides a set of services used for data processing on the user data
 * (here tutor).
 * @author Andriatiana Victor
 */
public class UserService {
    
    public static boolean isGoodCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        return getByCredentials(userLoginInput, userPasswordInput)!= null;
    }
    
    public static Tutor getByCredentials(String userLoginInput, String userPasswordInput) throws RuntimeException,SQLException{
        
        TutorDAO tutorDAO = new TutorDAOImpl();
        return tutorDAO.getByCredentials(userLoginInput, userPasswordInput);
    }
}
