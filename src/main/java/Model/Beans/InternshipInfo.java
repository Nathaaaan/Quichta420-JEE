package Model.Beans;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
public class InternshipInfo {

    private int internshipId;
    private Company company;
    private ArrayList<String> keywords;
    private String description;
    private String meetingInfo;
    private String internComment;
    private String tutorComment;
    private String linkedinProfile;
    private String master;
    private Date dateDebut;
    private Date dateFin;
    private Excel excel;


    public InternshipInfo() {
        System.out.println("");
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeetingInfo() {
        return meetingInfo;
    }

    public void setMeetingInfo(String meetingInfo) {
        this.meetingInfo = meetingInfo;
    }

    public String getInternComment() {
        return internComment;
    }

    public void setInternComment(String internComment) {
        this.internComment = internComment;
    }

    public String getTutorComment() {
        return tutorComment;
    }

    public void setTutorComment(String tutorComment) {
        this.tutorComment = tutorComment;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }
    
    public String getMaster(){
        return master;
    }
    
    public void setMaster(String master){
        this.master = master;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel excel) {
        this.excel = excel;
    }
}
