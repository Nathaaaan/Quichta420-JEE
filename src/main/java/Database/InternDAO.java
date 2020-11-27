package Database;

import Entities.AssignEntity;
import Entities.CompanyEntity;
import Model.Beans.Excel;
import Model.Beans.InternshipInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * A Data access object used for doing basic CRUD operations on Interns and 
 * the related tables.
 * Provides methods for running operations on the database using queries.
 * @author Andriatiana Victor
 */
public interface InternDAO {
    
    /**
     * Runs a query to get a tutor's interns and their internship information.
     * @param id - Which is the id of the tutor.
     * @return Raw ResultSet object.
     * @throws SQLException
     * @see Model.Services.AssignService Database.InternDAOImpl
     */
    public List<AssignEntity> getAllByTutorId(int id);
    public ResultSet getAssignByInternshipId(int id) throws SQLException;
    public List<AssignEntity> getAllByTutorIdAndYear(int id, String year);
    public void updateExcel(Excel e)throws SQLException;
    public void updateInternshipInfo(InternshipInfo info) throws SQLException;
    public CompanyEntity getCompanyById(int id) throws SQLException;
}
