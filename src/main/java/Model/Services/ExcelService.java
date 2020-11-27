package Model.Services;

import Entities.ExcelEntity;
import Model.Beans.Excel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides methods used to do CRUD operations on Excel
 * object to and from the database.
 * @author Andriatiana Victor
 */
public class ExcelService {

    ExcelService() {}
    /**
     * Creates an Excel model from a ResultSet Object.
     * Make sure that the given ResultSet object has all the necessary 
     * information from the tables of the database.
     * @param rs ResultSet Object
     * @return Excel object (Bean)
     * @throws SQLException 
     */
    public Excel createExcelModel (ExcelEntity ee)throws SQLException{
        Excel studentInfo = new Excel();
        studentInfo.setInternshipId(ee.getInternshipId());
        studentInfo.setCdc(ee.getCdc());
        studentInfo.setFicheVisite(ee.getFicheVisite());
        studentInfo.setFicheEvalEntr(ee.getFicheEvalEntr());
        studentInfo.setSondageWeb(ee.getSondageWeb());
        studentInfo.setRapportRendu(ee.getRapportRendu());
        studentInfo.setSout(ee.getSout());
        studentInfo.setPlanif(ee.getPlanif());
        studentInfo.setFaite(ee.getFaite());
        studentInfo.setNoteTech(ee.getNoteTech());
        studentInfo.setNoteCom(ee.getNoteCom());
        
        return studentInfo;
    }
}
