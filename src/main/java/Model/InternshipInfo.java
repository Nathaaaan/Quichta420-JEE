
package Model;

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

    public InternshipInfo(int internshipId, Company company, ArrayList<String> keywords,
 String description, String meetingInfo, String internComment, String tutorComment, String linkedinProfile){
        this.internshipId = internshipId;
        this.company = company;
        this.keywords = keywords;
        this.description = description;
        this.meetingInfo = meetingInfo;
        this.internComment = internComment;
        this.tutorComment = tutorComment;
        this.linkedinProfile = linkedinProfile;
    }

    public int getInternshipId(){
        return internshipId;
    }

    public void setInternshipId(int internshipId){
        this.internshipId = internshipId;
    }

    public Company getCompany(){
        return company;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    public ArrayList<String> getKeywords(){
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords){
        this.keywords = keywords;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getMeetingInfo(){
        return meetingInfo;
    }

    public void setMeetingInfo(String meetingInfo){
        this.meetingInfo = meetingInfo;
    }

    public String getInternComment(){
        return internComment;
    }

    public void setInternComment(String internComment){
        this.internComment = internComment;
    }

    public String getTutorComment(){
        return tutorComment;
    }

    public void setTutorComment(String tutorComment){
        this.tutorComment = tutorComment;
    }

    public String getLinkedinProfile(){
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile){
        this.linkedinProfile = linkedinProfile;
    }
}
