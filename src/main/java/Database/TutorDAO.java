/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Beans.Tutor;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Andriatiana Victor
 */
public interface TutorDAO {
    public ResultSet getByCredentials(String userLoginInput, String userPasswordInput)throws RuntimeException,SQLException;
}
