package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Gohu
 */
//TODO : This is not a Java Bean class actually
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

    public InternshipInfo(int internshipId, Company company, ArrayList<String> keywords,
            String description, String meetingInfo, String internComment, String tutorComment, String linkedinProfile, String master, Date dateDebut, Date dateFin) {
        this.internshipId = internshipId;
        this.company = company;
        this.keywords = keywords;
        this.description = description;
        this.meetingInfo = meetingInfo;
        this.internComment = internComment;
        this.tutorComment = tutorComment;
        this.linkedinProfile = linkedinProfile;
        this.master = master;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
    
    
}
