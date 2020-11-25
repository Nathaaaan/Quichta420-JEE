package Model.Services;

import Database.TutorDAO;
import Database.TutorDAOImpl;
import Model.Beans.Tutor;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Provides methods used to do CRUD operations on Tutor object (the user)
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class UserService {
    
    /**
     * Provides a Tutor model from the given credentials information if it 
     * exists in the database. The method will return null if not.
     * @param userLoginInput
     * @param userPasswordInput
     * @return Tutor object (Bean)
     * @throws RuntimeException
     * @throws SQLException 
     */
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
            return TutorUser;
            
        } else {
            return null;
        }
    }
    
    /**
     * Checks if the given user credentials exists in the database.
     * @param userLoginInput
     * @param userPasswordInput
     * @return Returns true is the user exists in the database. False if not.
     * @throws RuntimeException
     * @throws SQLException 
     */
    public static boolean isGoodCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        return getByCredentials(userLoginInput, userPasswordInput)!= null;
    }
}
