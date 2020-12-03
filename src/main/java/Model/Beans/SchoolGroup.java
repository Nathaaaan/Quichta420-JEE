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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "SCHOOLGROUP")
@NamedQueries({
    @NamedQuery(name = "SchoolGroup.findAll", query = "SELECT s FROM SchoolGroup s"),
    @NamedQuery(name = "SchoolGroup.findBySchoolgroupName", query = "SELECT s FROM SchoolGroup s WHERE s.schoolgroupName = :schoolgroupName")})
public class SchoolGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SCHOOLGROUP_NAME")
    private String schoolgroupName;
    @OneToMany(mappedBy = "schoolgroupName")
    private Collection<Intern> internCollection;

    public SchoolGroup() {
    }

    public SchoolGroup(String schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public String getSchoolgroupName() {
        return schoolgroupName;
    }

    public void setSchoolgroupName(String schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public Collection<Intern> getInternCollection() {
        return internCollection;
    }

    public void setInternCollection(Collection<Intern> internCollection) {
        this.internCollection = internCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolgroupName != null ? schoolgroupName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolGroup)) {
            return false;
        }
        SchoolGroup other = (SchoolGroup) object;
        if ((this.schoolgroupName == null && other.schoolgroupName != null) || (this.schoolgroupName != null && !this.schoolgroupName.equals(other.schoolgroupName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Beans.Schoolgroup[ schoolgroupName=" + schoolgroupName + " ]";
    }
    
}
