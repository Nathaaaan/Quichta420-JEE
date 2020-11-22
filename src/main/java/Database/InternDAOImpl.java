package Database;


import Model.Beans.Excel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    @Override
    public void updateExcel(Excel e) {
        try {
            String updateQuery = "UPDATE Excel SET cdc= ?, fiche_visite=?, fiche_eval_entr=?,"
                    + " sondage_web=?, rapport_rendu=?, sout=?, planif=?, faite=?, note_tech=?,"
                    + " note_com=? WHERE excel_id = ?";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setBoolean(1, e.isCdc());
            ps.setBoolean(2, e.isFicheVisite());
            ps.setBoolean(3, e.isFicheEvalEntr());
            ps.setBoolean(4, e.isSondageWeb());
            ps.setBoolean(5, e.isRapportRendu());
            ps.setBoolean(6, e.isSout());
            ps.setBoolean(7, e.isPlanif());
            ps.setBoolean(8, e.isFaite());
            ps.setInt(9, e.getNoteTech());
            ps.setInt(10, e.getNoteCom());
            ps.setInt(11, e.getExcelId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InternDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
