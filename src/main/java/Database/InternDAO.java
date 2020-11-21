/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Beans.Company;
import Model.Beans.Intern;
import Model.Beans.InternshipInfo;
import Model.Beans.Tutor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andriatiana Victor
 */
public interface InternDAO {
    public ResultSet getInfoByTutorID(int tutorId) throws SQLException;
    public Intern getById (int Id);
    public Company getCompanyById (int companyId);
}
