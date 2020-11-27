package Model.Services;

import Database.TutorDAO;
import Database.TutorDAOImpl;
import Entities.TutorEntity;
import Model.Beans.Tutor;
import java.sql.SQLException;
/**
 * Provides methods used to do CRUD operations on Tutor object (the user)
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class UserService {
    
    
    TutorDAO tutorDAO;
    
    /**
     * Provides a Tutor model from the given credentials information if it 
     * exists in the database. The method will return null if not.
     * @param userLoginInput
     * @param userPasswordInput
     * @return Tutor object (Bean)
     */
    public Tutor getByCredentials(String userLoginInput, String userPasswordInput){
        tutorDAO=new TutorDAOImpl();
        TutorEntity tutorEntity = tutorDAO.getByCredentials(userLoginInput, userPasswordInput);
        System.out.println("tutorEntity :"+ tutorEntity.getFirstName());
        
        if (tutorEntity!=null) {
            Tutor TutorUser = new Tutor();
            TutorUser.setId(tutorEntity.getTutorId());
            TutorUser.setName(tutorEntity.getFirstName());
            TutorUser.setLastName(tutorEntity.getLastName());
            TutorUser.setLogin(tutorEntity.getLogin());
            TutorUser.setPassword(tutorEntity.getPassword());
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
    public boolean isGoodCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException{
        return getByCredentials(userLoginInput, userPasswordInput)!= null;
    }
}
