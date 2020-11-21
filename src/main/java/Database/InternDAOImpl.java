/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Beans.Company;
import Model.Beans.Intern;
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
    private ResultSet rs;
    
    public InternDAOImpl(){
        conn = DB.getCo();
    }
    
    
    @Override
    public ResultSet getInfoByTutorID(int tutorId) throws SQLException{
        stmt = conn.createStatement();
        String queryCount = "SELECT INTERNSHIPINFO.* FROM ASSIGN "
                + "INNER JOIN INTERNSHIPINFO "
                + "ON ASSIGN.INTERNSHIP_ID = INTERSHIPINFO.INTERNSHIP_ID "
                + "WHERE ASSIGN.TUTOR_ID = '" +tutorId+ "'";
        return stmt.executeQuery(queryCount);
    }
    
    
    @Override
    public Intern getById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company getCompanyById(int companyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
