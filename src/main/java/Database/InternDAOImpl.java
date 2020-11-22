/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andriatiana Victor
 */
public class InternDAOImpl implements InternDAO {
    private final Connection conn;
    private Statement stmt;
    
    public InternDAOImpl(){
        conn = DB.getCo();
    }
    
    @Override
    public ResultSet getInternByTutorId(int tutorId) throws SQLException{
        stmt = conn.createStatement();
        String queryCount = "SELECT INTERN.* FROM ASSIGN "
                + "INNER JOIN INTERN "
                + "ON ASSIGN.INTERN_ID = INTERN.INTERN_ID "
                + "WHERE ASSIGN.TUTOR_ID = "+ tutorId;
        return stmt.executeQuery(queryCount);
    }
    
    @Override
    public ResultSet getAllByTutorId(int id) throws SQLException {
        stmt = conn.createStatement();
        String queryCount = "SELECT INTERN.*, INTERNSHIPINFO.*, EXCEL.* "
                + "FROM ASSIGN "
                + "INNER JOIN INTERN ON ASSIGN.INTERN_ID = INTERN.INTERN_ID "
                + "INNER JOIN INTERNSHIPINFO ON ASSIGN.INTERNSHIP_ID = INTERNSHIPINFO.INTERNSHIP_ID "
                + "INNER JOIN EXCEL ON INTERNSHIPINFO.EXCEL_ID = EXCEL.EXCEL_ID "
                + "WHERE ASSIGN.TUTOR_ID = "+ id;
        return stmt.executeQuery(queryCount);
    }
}
