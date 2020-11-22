/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Services;


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
    public Excel createExcelModel (ResultSet rs)throws SQLException{
        Excel studentInfo = new Excel();
        studentInfo.setExcelId(rs.getInt("EXCEL_ID"));
        studentInfo.setCdc(rs.getBoolean("CDC"));
        studentInfo.setFicheVisite(rs.getBoolean("FICHE_VISITE"));
        studentInfo.setFicheEvalEntr(rs.getBoolean("FICHE_EVAL_ENTR"));
        studentInfo.setSondageWeb(rs.getBoolean("SONDAGE_WEB"));
        studentInfo.setRapportRendu(rs.getBoolean("RAPPORT_RENDU"));
        studentInfo.setSout(rs.getBoolean("SOUT"));
        studentInfo.setPlanif(rs.getBoolean("PLANIF"));
        studentInfo.setFaite(rs.getBoolean("FAITE"));
        studentInfo.setNoteTech(rs.getInt("NOTE_TECH"));
        studentInfo.setNoteCom(rs.getInt("NOTE_COM"));
        
        return studentInfo;
    }
    
    /*public Excel getExcelById (int excelId) throws SQLException{
        InternshipInfoDAO internshipDAO = new InternshipInfoDAOImpl();
        ResultSet rs= internshipDAO.getExcelById(excelId);
        if(rs.next()){
            Excel studentInfo = new Excel();
            studentInfo.setExcelId(rs.getInt("EXCEL_ID"));
            studentInfo.setCdc(rs.getBoolean("CDC"));
            studentInfo.setFicheVisite(rs.getBoolean("FICHE_VISITE"));
            studentInfo.setFicheEvalEntr(rs.getBoolean("FICHE_EVAL_ENTR"));
            studentInfo.setSondageWeb(rs.getBoolean("SONDAGE_WEB"));
            studentInfo.setRapportRendu(rs.getBoolean("RAPPORT_RENDU"));
            studentInfo.setSout(rs.getBoolean("SOUT"));
            studentInfo.setPlanif(rs.getBoolean("PLANIF"));
            studentInfo.setFaite(rs.getBoolean("FAITE"));
            studentInfo.setNoteTech(rs.getInt("NOTE_TECH"));
            studentInfo.setNoteCom(rs.getInt("NOTE_COM"));
            
            return studentInfo;
        } else{
            return null;
        }
    }*/
}
