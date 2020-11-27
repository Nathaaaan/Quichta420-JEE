/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
    @NamedQuery(name = "InternEntity.findAll", query = "SELECT i FROM InternEntity i"),
    @NamedQuery(name = "InternEntity.findByInternId", query = "SELECT i FROM InternEntity i WHERE i.internId = :internId"),
    @NamedQuery(name = "InternEntity.findByFirstName", query = "SELECT i FROM InternEntity i WHERE i.firstName = :firstName"),
    @NamedQuery(name = "InternEntity.findByLastName", query = "SELECT i FROM InternEntity i WHERE i.lastName = :lastName")})
public class InternEntity implements Serializable {

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
    private SchoolgroupEntity schoolgroupName;
    @OneToMany(mappedBy = "internId")
    private Collection<AssignEntity> assignEntityCollection;

    public InternEntity() {
    }

    public InternEntity(Integer internId) {
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

    public SchoolgroupEntity getSchoolgroupName() {
        return schoolgroupName;
    }

    public void setSchoolgroupName(SchoolgroupEntity schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public Collection<AssignEntity> getAssignEntityCollection() {
        return assignEntityCollection;
    }

    public void setAssignEntityCollection(Collection<AssignEntity> assignEntityCollection) {
        this.assignEntityCollection = assignEntityCollection;
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
        if (!(object instanceof InternEntity)) {
            return false;
        }
        InternEntity other = (InternEntity) object;
        if ((this.internId == null && other.internId != null) || (this.internId != null && !this.internId.equals(other.internId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.InternEntity[ internId=" + internId + " ]";
    }
    
}
