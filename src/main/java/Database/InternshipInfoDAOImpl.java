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
public class InternshipInfoDAOImpl implements InternshipInfoDAO {
    private final Connection conn;
    private Statement stmt;
    
    public InternshipInfoDAOImpl(){
        conn = DB.getCo();
    }
    
    @Override
    public ResultSet getInfoByTutorID(int tutorId) throws SQLException{
        stmt = conn.createStatement();
        String queryCount = "SELECT INTERNSHIPINFO.* FROM ASSIGN "
                + "INNER JOIN INTERNSHIPINFO "
                + "ON ASSIGN.INTERNSHIP_ID = INTERNSHIPINFO.INTERNSHIP_ID "
                + "WHERE ASSIGN.TUTOR_ID = " + tutorId;
        return stmt.executeQuery(queryCount);
    }
    
    @Override
    public ResultSet getCompanyById(int companyId) throws SQLException{
        stmt = conn.createStatement();
        // TODO: SQL query for company
        String queryCount = "SELECT * FROM COMPANY WHERE COMPANY_ID = " + companyId;
        return stmt.executeQuery(queryCount);
    }
    
    @Override
    public ResultSet getExcelById(int excelId) throws SQLException{
        stmt = conn.createStatement();
        String getAll = "SELECT EXCEL.* FROM ASSIGN EXCEL ";
        
        return stmt.executeQuery(getAll);
    }
}
