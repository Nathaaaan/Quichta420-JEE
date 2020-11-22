/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Model.Beans.Assign;
import Model.Beans.Tutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andriatiana Victor
 */
public class AssignService {
    /*public Assign getInternInfo(Tutor tutor) throws SQLException{
        
        Assign assign = new Assign();
        InternshipInfoService internship = new InternshipInfoService();
        InternService intern = new InternService();
        
        assign.setTutor(tutor);
        assign.setInternshipInfo(internship.getInternshipInfoById(tutor.getId()));
        assign.setIntern(intern.getInternById(tutor.getId()));
        
        return assign;
    }*/
    
    public Assign createAssignModel(ResultSet rs) throws SQLException{
        Assign assign = new Assign();
        
        assign.setIntern(new InternService().createInternModel(rs));
        assign.setInternshipInfo(new InternshipInfoService().createInternshipModel(rs));
        return assign;
    }
    
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
}
