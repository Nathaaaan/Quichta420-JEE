package Database;


import Model.Beans.Company;
import Model.Beans.Excel;
import Model.Beans.Intern;
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
        
        String updateQuery = "UPDATE InternshipInfo SET description=?, tutor_comment=?, meeting_info=? WHERE internship_id=?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, info.getDescription());
        ps.setString(2, info.getTutorComment());
        ps.setString(3, info.getMeetingInfo());
        ps.setInt(4, info.getInternshipId());

        ps.executeUpdate();
    }
    
    public ResultSet getAllCompanies() throws SQLException{
        Statement st = conn.createStatement();
        String query = "SELECT * FROM Company";
        
        return st.executeQuery(query);
    }
    
    public ResultSet getAllGroups() throws SQLException{
        Statement st = conn.createStatement();
        String query = "SELECT * FROM SchoolGroup";
        
        return st.executeQuery(query);
    }
    
    public int insertCompany(Company c) throws SQLException{
        String query = "INSERT INTO Company(company_name, company_adress) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, c.getCompanyName());
        ps.setString(2, c.getCompanyAddress());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        
        return (int) rs.getLong(1);
    }
    
    public int insertIntern(Intern intern) throws SQLException{
        String query = "INSERT INTO Intern(first_name, last_name,schoolGroup_name) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, intern.getFirstName());
        ps.setString(2, intern.getLastName());
        ps.setString(3, intern.getSchoolGroup());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        
        return (int) rs.getLong(1);
    }
    
    public int insertExcel() throws SQLException{
        String query = "INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)"
                + " VALUES('false','false','false','false','false','false','false','false')";
        PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        
        return (int) rs.getLong(1);
    }
    
    public ResultSet getCompanyById(int id) throws SQLException{
        String query = "SELECT * FROM Company WHERE company_id = "+id;
        Statement st = conn.createStatement();
        return st.executeQuery(query);
    }
    
    public int insertAssign(int internId, int tutorId) throws SQLException{
        String query = "INSERT INTO Assign(intern_id,tutor_id) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, internId);
        ps.setInt(2, tutorId);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        
        return (int) rs.getLong(1);
    }
    
    public void insertInternshipInfo(InternshipInfo info) throws SQLException{
        String query = "INSERT INTO InternshipInfo(internship_id,company_id,master,start_date,end_date,excel_id) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, info.getInternshipId());
        ps.setInt(2, info.getCompany().getCompanyId());
        ps.setString(3, info.getMaster());
        ps.setDate(4, info.getDateDebut());
        ps.setDate(5, info.getDateFin());
        ps.setInt(6, info.getExcel().getExcelId());
        ps.executeUpdate();
    }
}
