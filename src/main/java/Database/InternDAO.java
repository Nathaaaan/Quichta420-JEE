/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public ResultSet getAllByTutorId (int id) throws SQLException;
    //public ResultSet getInternByTutorId (int Id) throws SQLException;
    //public ResultSet getCompanyById (int companyId) throws SQLException;
    public ResultSet getAssignByInternshipId(int id) throws SQLException;
}
