/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public interface InternshipInfoDAO {
    public ResultSet getInfoByTutorID(int tutorId) throws SQLException;
    public ResultSet getCompanyById (int companyId) throws SQLException;
    public ResultSet getExcelById(int excelId) throws SQLException;
}
