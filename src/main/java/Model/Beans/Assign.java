/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

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
    @NamedQuery(name = "Assign.findAll", query = "SELECT a FROM Assign a"),
    @NamedQuery(name = "Assign.findByInternshipId", query = "SELECT a FROM Assign a WHERE a.internshipId = :internshipId"),
    @NamedQuery(name = "Assign.findByInternshipYear", query = "SELECT a FROM Assign a WHERE a.internshipYear = :internshipYear")})
public class Assign implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INTERNSHIP_ID")
    private Integer internshipId;
    @Column(name = "INTERNSHIP_YEAR")
    private Integer internshipYear;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "assign")
    private Excel excel;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "assign")
    private InternshipInfo internshipinfo;
    @JoinColumn(name = "INTERN_ID", referencedColumnName = "INTERN_ID")
    @ManyToOne
    private Intern internId;
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID")
    @ManyToOne
    private Tutor tutorId;

    public Assign() {
    }

    public Assign(Integer internshipId) {
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

    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel excel) {
        this.excel = excel;
    }

    public InternshipInfo getInternshipinfo() {
        return internshipinfo;
    }

    public void setInternshipinfo(InternshipInfo internshipinfo) {
        this.internshipinfo = internshipinfo;
    }

    public Intern getInternId() {
        return internId;
    }

    public void setInternId(Intern internId) {
        this.internId = internId;
    }

    public Tutor getTutorId() {
        return tutorId;
    }

    public void setTutorId(Tutor tutorId) {
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
        if (!(object instanceof Assign)) {
            return false;
        }
        Assign other = (Assign) object;
        if ((this.internshipId == null && other.internshipId != null) || (this.internshipId != null && !this.internshipId.equals(other.internshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Beans.Assign[ internshipId=" + internshipId + " ]";
    }
    
}
