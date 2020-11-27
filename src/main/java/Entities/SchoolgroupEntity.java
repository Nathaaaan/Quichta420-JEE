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
    @NamedQuery(name = "SchoolgroupEntity.findAll", query = "SELECT s FROM SchoolgroupEntity s"),
    @NamedQuery(name = "SchoolgroupEntity.findBySchoolgroupName", query = "SELECT s FROM SchoolgroupEntity s WHERE s.schoolgroupName = :schoolgroupName")})
public class SchoolgroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SCHOOLGROUP_NAME")
    private String schoolgroupName;
    @OneToMany(mappedBy = "schoolgroupName")
    private Collection<InternEntity> internEntityCollection;

    public SchoolgroupEntity() {
    }

    public SchoolgroupEntity(String schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public String getSchoolgroupName() {
        return schoolgroupName;
    }

    public void setSchoolgroupName(String schoolgroupName) {
        this.schoolgroupName = schoolgroupName;
    }

    public Collection<InternEntity> getInternEntityCollection() {
        return internEntityCollection;
    }

    public void setInternEntityCollection(Collection<InternEntity> internEntityCollection) {
        this.internEntityCollection = internEntityCollection;
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
        if (!(object instanceof SchoolgroupEntity)) {
            return false;
        }
        SchoolgroupEntity other = (SchoolgroupEntity) object;
        if ((this.schoolgroupName == null && other.schoolgroupName != null) || (this.schoolgroupName != null && !this.schoolgroupName.equals(other.schoolgroupName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SchoolgroupEntity[ schoolgroupName=" + schoolgroupName + " ]";
    }
    
}
