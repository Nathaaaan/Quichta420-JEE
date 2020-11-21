/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;

import Model.Beans.Assign;
import Model.Beans.Tutor;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public class AssignService {
    public Assign getInternInfo(Tutor tutor) throws SQLException{
        
        Assign assign = new Assign();
        InternshipInfoService internship = new InternshipInfoService();
        InternService intern = new InternService();
        
        assign.setTutor(tutor);
        assign.setInternshipInfo(internship.getInternshipInfoById(tutor.getId()));
        assign.setIntern(intern.getInternById(tutor.getId()));
        
        return assign;
    }
}
