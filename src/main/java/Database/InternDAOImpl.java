package Database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A Data access object used for doing basic CRUD operations on Interns and 
 * the related tables.
 * Provides methods for running operations on the database using queries.
 * Implementation of the InternDAO interface.
 * @author Andriatiana Victor
 */
public class InternDAOImpl implements InternDAO {
    private final Connection conn;
    private Statement stmt;
    
    public InternDAOImpl(){
        conn = DB.getCo();
    }
    
    /**
     * Runs a query to get a tutor's interns and their internship information.
     * @param id - Which is the id of the tutor.
     * @return Raw ResultSet object.
     * @throws SQLException
     * @see Model.Services.AssignService
     */
    @Override
    public ResultSet getAllByTutorId(int id) throws SQLException {
        //the try catch close will automatically close the connection 
        stmt = conn.createStatement();
        String queryCount = "SELECT INTERN.*, INTERNSHIPINFO.*, EXCEL.*, COMPANY.* "
            + "FROM ASSIGN "
            + "INNER JOIN INTERN ON ASSIGN.INTERN_ID = INTERN.INTERN_ID "
            + "INNER JOIN INTERNSHIPINFO ON ASSIGN.INTERNSHIP_ID = INTERNSHIPINFO.INTERNSHIP_ID "
            + "INNER JOIN EXCEL ON INTERNSHIPINFO.EXCEL_ID = EXCEL.EXCEL_ID "
            + "INNER JOIN COMPANY ON INTERNSHIPINFO.COMPANY_ID = COMPANY.COMPANY_ID "
            + "WHERE ASSIGN.TUTOR_ID = "+ id;
        return stmt.executeQuery(queryCount);
    }
    

    @Override
    public ResultSet getAssignByInternshipId(int id) throws SQLException {
        Statement stmt = conn.createStatement();
        String queryCount = "SELECT INTERN.*, INTERNSHIPINFO.*, EXCEL.*, COMPANY.* "
            + "FROM ASSIGN "
            + "INNER JOIN INTERN ON ASSIGN.INTERN_ID = INTERN.INTERN_ID "
            + "INNER JOIN INTERNSHIPINFO ON ASSIGN.INTERNSHIP_ID = INTERNSHIPINFO.INTERNSHIP_ID "
            + "INNER JOIN EXCEL ON INTERNSHIPINFO.EXCEL_ID = EXCEL.EXCEL_ID "
            + "INNER JOIN COMPANY ON INTERNSHIPINFO.COMPANY_ID = COMPANY.COMPANY_ID "
            + "WHERE ASSIGN.Internship_Id = "+ id;
        return stmt.executeQuery(queryCount);
    }
}
