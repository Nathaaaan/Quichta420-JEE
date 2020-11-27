/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "INTERN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intern.findAll", query = "SELECT i FROM Intern i"),
    @NamedQuery(name = "Intern.findByInternId", query = "SELECT i FROM Intern i WHERE i.internId = :internId"),
    @NamedQuery(name = "Intern.findByFirstName", query = "SELECT i FROM Intern i WHERE i.firstName = :firstName"),
    @NamedQuery(name = "Intern.findByLastName", query = "SELECT i FROM Intern i WHERE i.lastName = :lastName")})
public class Intern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INTERN_ID")
    private Integer internId;
    @Size(max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    @JoinColumn(name = "SCHOOLGROUP_NAME", referencedColumnName = "SCHOOLGROUP_NAME")
    @ManyToOne
    private SchoolGroup schoolGroup;
    @OneToMany(mappedBy = "intern")
    private Collection<Assign> assignCollection;

    public Intern() {
    }

    public Intern(Integer internId) {
        this.internId = internId;
    }

    public Integer getInternId() {
        return internId;
    }

    public void setInternId(Integer internId) {
        this.internId = internId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SchoolGroup getSchoolGroup() {
        return schoolGroup;
    }

    public void setSchoolGroup(SchoolGroup schoolGroup) {
        this.schoolGroup = schoolGroup;
    }

    @XmlTransient
    public Collection<Assign> getAssignCollection() {
        return assignCollection;
    }

    public void setAssignCollection(Collection<Assign> assignCollection) {
        this.assignCollection = assignCollection;
    }
    
}
