/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Model.Beans.Intern;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public class InternService {
    
    public Intern createInternModel(ResultSet rs) throws SQLException {
        Intern intern = new Intern();
        intern.setId(rs.getInt("INTERN_ID"));
        intern.setFirstName(rs.getString("FIRST_NAME"));
        intern.setLastName(rs.getString("LAST_NAME"));
        intern.setSchoolGroup(rs.getString("SCHOOLGROUP_NAME"));
        return intern;
    }
    
    /*public Intern getInternById(int id)throws SQLException{
        InternDAO internDAO = new InternDAOImpl();
        ResultSet rs = internDAO.getInternByTutorId(id);
        if(rs.next()){
            Intern intern = new Intern();
            intern.setId(rs.getInt("INTERN_ID"));
            intern.setFirstName(rs.getString("FIRST_NAME"));
            intern.setLastName(rs.getString("LAST_NAME"));
            intern.setSchoolGroup(rs.getString("SCHOOLGROUP_NAME"));
            return intern;
        }else{
            return null;
        }
    }*/
}
