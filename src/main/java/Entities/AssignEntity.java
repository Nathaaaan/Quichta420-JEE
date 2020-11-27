/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "ASSIGN")
@NamedQueries({
    @NamedQuery(name = "AssignEntity.findAll", query = "SELECT a FROM AssignEntity a"),
    @NamedQuery(name = "AssignEntity.findByInternshipId", query = "SELECT a FROM AssignEntity a WHERE a.internshipId = :internshipId"),
    @NamedQuery(name = "AssignEntity.findByInternshipYear", query = "SELECT a FROM AssignEntity a WHERE a.internshipYear = :internshipYear")})
public class AssignEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INTERNSHIP_ID")
    private Integer internshipId;
    @Column(name = "INTERNSHIP_YEAR")
    private Integer internshipYear;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "assignEntity")
    private ExcelEntity excelEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "assignEntity")
    private InternshipinfoEntity internshipinfoEntity;
    @JoinColumn(name = "INTERN_ID", referencedColumnName = "INTERN_ID")
    @ManyToOne
    private InternEntity internId;
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID")
    @ManyToOne
    private TutorEntity tutorId;

    public AssignEntity() {
    }

    public AssignEntity(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Integer getInternshipYear() {
        return internshipYear;
    }

    public void setInternshipYear(Integer internshipYear) {
        this.internshipYear = internshipYear;
    }

    public ExcelEntity getExcelEntity() {
        return excelEntity;
    }

    public void setExcelEntity(ExcelEntity excelEntity) {
        this.excelEntity = excelEntity;
    }

    public InternshipinfoEntity getInternshipinfoEntity() {
        return internshipinfoEntity;
    }

    public void setInternshipinfoEntity(InternshipinfoEntity internshipinfoEntity) {
        this.internshipinfoEntity = internshipinfoEntity;
    }

    public InternEntity getInternId() {
        return internId;
    }

    public void setInternId(InternEntity internId) {
        this.internId = internId;
    }

    public TutorEntity getTutorId() {
        return tutorId;
    }

    public void setTutorId(TutorEntity tutorId) {
        this.tutorId = tutorId;
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
        if (!(object instanceof AssignEntity)) {
            return false;
        }
        AssignEntity other = (AssignEntity) object;
        if ((this.internshipId == null && other.internshipId != null) || (this.internshipId != null && !this.internshipId.equals(other.internshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AssignEntity[ internshipId=" + internshipId + " ]";
    }
    
}
