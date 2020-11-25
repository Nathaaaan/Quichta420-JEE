package Database;


import Model.Beans.Excel;
import Model.Beans.InternshipInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    @Override
    public ResultSet getAllByTutorIdAndYear(int id, String year) throws SQLException{
    Statement stmt = conn.createStatement();
    String queryCount = "SELECT INTERN.*, INTERNSHIPINFO.*, EXCEL.*, COMPANY.* "
            + "FROM ASSIGN "
            + "INNER JOIN INTERN ON ASSIGN.INTERN_ID = INTERN.INTERN_ID "
            + "INNER JOIN INTERNSHIPINFO ON ASSIGN.INTERNSHIP_ID = INTERNSHIPINFO.INTERNSHIP_ID "
            + "INNER JOIN EXCEL ON INTERNSHIPINFO.EXCEL_ID = EXCEL.EXCEL_ID "
            + "INNER JOIN COMPANY ON INTERNSHIPINFO.COMPANY_ID = COMPANY.COMPANY_ID "
            + "WHERE ASSIGN.TUTOR_ID = "+ id
            + "AND ASSIGN.INTERNSHIP_YEAR ="+year;
        
        return stmt.executeQuery(queryCount);
    
    }
    
    @Override
    public void updateExcel(Excel e) throws SQLException {
        
        String updateQuery = "UPDATE Excel SET cdc= ?, fiche_visite=?, fiche_eval_entr=?,"
                + " sondage_web=?, rapport_rendu=?, sout=?, planif=?, faite=?, note_tech=?,"
                + " note_com=? WHERE excel_id = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setBoolean(1, e.getCdc());
        ps.setBoolean(2, e.getFicheVisite());
        ps.setBoolean(3, e.getFicheEvalEntr());
        ps.setBoolean(4, e.getSondageWeb());
        ps.setBoolean(5, e.getRapportRendu());
        ps.setBoolean(6, e.getSout());
        ps.setBoolean(7, e.getPlanif());
        ps.setBoolean(8, e.getFaite());
        ps.setInt(9, e.getNoteTech());
        ps.setInt(10, e.getNoteCom());
        ps.setInt(11, e.getExcelId());

        ps.executeUpdate();
    }
    
    @Override
    public void updateInternshipInfo(InternshipInfo info) 
            throws SQLException {
        
        String updateQuery = "UPDATE InternshipInfo SET description=?, tutor_comment=? WHERE internship_id=?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, info.getDescription());
        ps.setString(2, info.getTutorComment());
        ps.setInt(3, info.getInternshipId());

        ps.executeUpdate();
    }
}
