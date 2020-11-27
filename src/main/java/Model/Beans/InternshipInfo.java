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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "INTERNSHIPINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternshipInfo.findAll", query = "SELECT i FROM InternshipInfo i"),
    @NamedQuery(name = "InternshipInfo.findByInternshipId", query = "SELECT i FROM InternshipInfo i WHERE i.internshipId = :internshipId")})
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
    private Date dateDebut;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "MEETING_INFO")
    private String meetingInfo;
    @Size(max = 200)
    @Column(name = "TUTOR_COMMENT")
    private String tutorComment;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
    @ManyToOne
    private Company company;
    @ManyToMany(mappedBy = "internshipInfoCollection")
    private Collection<KeyWord> keywordCollection;
    @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Assign assign;

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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
