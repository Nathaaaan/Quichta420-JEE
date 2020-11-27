package Model.Services;

import Database.InternDAO;
import Database.InternDAOImpl;
import Entities.AssignEntity;
import Model.Beans.Assign;
import Model.Beans.InternshipInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Provides methods used to do CRUD operations on Assign object
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class AssignService {
    
    InternDAOImpl internDAO;
    
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
        assign.setExcel(new ExcelService().createExcelModel(rs));
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
        List<AssignEntity> assignEntityList = internDAO.getAllByTutorId(tutorId);
        
        int i = 0;
        while(rs.next()){
            assignList.add(createAssignModel(rs));
        }
        return assignList;
    }
    
    public ArrayList<Assign> getAllByTutorIdAndYear(int tutorId, String userInput) throws SQLException{
        ArrayList<Assign> assignList=new ArrayList<Assign>();
        InternDAO internDAO = new InternDAOImpl();
        
        
        ResultSet rs = internDAO.getAllByTutorIdAndYear(tutorId, userInput);
        int i = 0;
        while(rs.next()){
            assignList.add(createAssignModel(rs));
        }
        return assignList;
    }
    
    public void insertAssign(Assign assign) throws SQLException{
        InternDAOImpl internDAOImpl = new InternDAOImpl();
        int internId = internDAOImpl.insertIntern(assign.getIntern());
        int tutorId = assign.getTutor().getId();
        
        int internshipId = internDAOImpl.insertAssign(internId,tutorId);
        
        internDAOImpl.insertExcel(internshipId);
        
        InternshipInfo info = assign.getInternshipInfo();
        info.setInternshipId(internshipId);
        internDAOImpl.insertInternshipInfo(info);
    }
    
    public Assign getAssignByInternshipId(int id) throws SQLException{
        InternDAOImpl inter = new InternDAOImpl();
        ResultSet rs = inter.getAssignByInternshipId(id);
        rs.next();
        return createAssignModel(rs);
    }
}
