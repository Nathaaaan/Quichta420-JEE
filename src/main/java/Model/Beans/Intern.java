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

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "INTERN")
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
    private SchoolGroup schoolgroupName;
    @OneToMany(mappedBy = "internId")
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

    public SchoolGroup getSchoolgroupName() {
        return schoolgroupName;
    }

    public void setSchoolgroupName(SchoolGroup schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public Collection<Assign> getAssignCollection() {
        return assignCollection;
    }

    public void setAssignCollection(Collection<Assign> assignCollection) {
        this.assignCollection = assignCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internId != null ? internId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intern)) {
            return false;
        }
        Intern other = (Intern) object;
        if ((this.internId == null && other.internId != null) || (this.internId != null && !this.internId.equals(other.internId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Beans.Intern[ internId=" + internId + " ]";
    }
    
}
