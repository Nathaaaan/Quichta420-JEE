/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Model.Beans.Assign;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Provides methods used to do CRUD operations on Assign object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class AssignService {
    
    /**
     * Creates an Assign model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet object
     * @return Assign object (Bean)
     * @throws SQLException
     * @see Database.InternDAOImpl
     */
    public Assign createAssignModel(ResultSet rs) throws SQLException{
        Assign assign = new Assign();
        assign.setIntern(new InternService().createInternModel(rs));
        assign.setInternshipInfo(new InternshipInfoService().createInternshipModel(rs));
        return assign;
    }
    
    /**
     * Returns the list of all interns assigned to a tutor.
     * @param tutorId Id of the tutor
     * @return ArrayList of Assign object.
     * @throws SQLException 
     */
    public ArrayList<Assign> getAllByTutorId(int tutorId) throws SQLException{
        ArrayList<Assign> assignList=new ArrayList<Assign>();
        InternDAO internDAO = new InternDAOImpl();
        ResultSet rs = internDAO.getAllByTutorId(tutorId);
        int i = 0;
        while(rs.next()){
            assignList.add(createAssignModel(rs));
        }
        return assignList;
    }
    
    /*public Assign getInternInfo(Tutor tutor) throws SQLException{
        
        Assign assign = new Assign();
        InternshipInfoService internship = new InternshipInfoService();
        InternService intern = new InternService();
        
        assign.setTutor(tutor);
        assign.setInternshipInfo(internship.getInternshipInfoById(tutor.getId()));
        assign.setIntern(intern.getInternById(tutor.getId()));
        
        return assign;
    }*/
}
