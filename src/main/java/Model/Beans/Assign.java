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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "ASSIGN")
@XmlRootElement
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
    private InternshipInfo internshipInfo;
    @JoinColumn(name = "INTERN_ID", referencedColumnName = "INTERN_ID")
    @ManyToOne
    private Intern intern;
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "TUTOR_ID")
    @ManyToOne
    private Tutor tutor;

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

    public InternshipInfo getInternshipInfo() {
        return internshipInfo;
    }

    public void setInternshipInfo(InternshipInfo internshipInfo) {
        this.internshipInfo = internshipInfo;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
}
