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
@Table(name = "COMPANY")
@NamedQueries({
    @NamedQuery(name = "CompanyEntity.findAll", query = "SELECT c FROM CompanyEntity c"),
    @NamedQuery(name = "CompanyEntity.findByCompanyId", query = "SELECT c FROM CompanyEntity c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "CompanyEntity.findByCompanyName", query = "SELECT c FROM CompanyEntity c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CompanyEntity.findByCompanyAdress", query = "SELECT c FROM CompanyEntity c WHERE c.companyAdress = :companyAdress")})
public class CompanyEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMPANY_ID")
    private Integer companyId;
    @Size(max = 30)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Size(max = 80)
    @Column(name = "COMPANY_ADRESS")
    private String companyAdress;
    @OneToMany(mappedBy = "companyId")
    private Collection<InternshipinfoEntity> internshipinfoEntityCollection;

    public CompanyEntity() {
    }

    public CompanyEntity(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public Collection<InternshipinfoEntity> getInternshipinfoEntityCollection() {
        return internshipinfoEntityCollection;
    }

    public void setInternshipinfoEntityCollection(Collection<InternshipinfoEntity> internshipinfoEntityCollection) {
        this.internshipinfoEntityCollection = internshipinfoEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyEntity)) {
            return false;
        }
        CompanyEntity other = (CompanyEntity) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CompanyEntity[ companyId=" + companyId + " ]";
    }
    
}
