/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "INTERNSHIPINFO")
@NamedQueries({
    @NamedQuery(name = "Internshipinfo.findAll", query = "SELECT i FROM Internshipinfo i"),
    @NamedQuery(name = "Internshipinfo.findByInternshipId", query = "SELECT i FROM Internshipinfo i WHERE i.internshipId = :internshipId"),
    @NamedQuery(name = "Internshipinfo.findByMaster", query = "SELECT i FROM Internshipinfo i WHERE i.master = :master"),
    @NamedQuery(name = "Internshipinfo.findByStartDate", query = "SELECT i FROM Internshipinfo i WHERE i.startDate = :startDate"),
    @NamedQuery(name = "Internshipinfo.findByEndDate", query = "SELECT i FROM Internshipinfo i WHERE i.endDate = :endDate"),
    @NamedQuery(name = "Internshipinfo.findByDescription", query = "SELECT i FROM Internshipinfo i WHERE i.description = :description"),
    @NamedQuery(name = "Internshipinfo.findByMeetingInfo", query = "SELECT i FROM Internshipinfo i WHERE i.meetingInfo = :meetingInfo"),
    @NamedQuery(name = "Internshipinfo.findByTutorComment", query = "SELECT i FROM Internshipinfo i WHERE i.tutorComment = :tutorComment")})
public class InternshipInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERNSHIP_ID")
    private Integer internshipId;
    @Size(max = 60)
    @Column(name = "MASTER")
    private String master;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "MEETING_INFO")
    private String meetingInfo;
    @Size(max = 200)
    @Column(name = "TUTOR_COMMENT")
    private String tutorComment;
    @ManyToMany(mappedBy = "internshipinfoCollection")
    private Collection<KeyWord> keywordCollection;
    @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Assign assign;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
    @ManyToOne
    private Company companyId;

    public InternshipInfo() {
    }

    public InternshipInfo(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getTutorComment() {
        return tutorComment;
    }

    public void setTutorComment(String tutorComment) {
        this.tutorComment = tutorComment;
    }

    public Collection<KeyWord> getKeywordCollection() {
        return keywordCollection;
    }

    public void setKeywordCollection(Collection<KeyWord> keywordCollection) {
        this.keywordCollection = keywordCollection;
    }

    public Assign getAssign() {
        return assign;
    }

    public void setAssign(Assign assign) {
        this.assign = assign;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internshipId != null ? internshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InternshipInfo)) {
            return false;
        }
        InternshipInfo other = (InternshipInfo) object;
        if ((this.internshipId == null && other.internshipId != null) || (this.internshipId != null && !this.internshipId.equals(other.internshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Beans.Internshipinfo[ internshipId=" + internshipId + " ]";
    }
    
}
