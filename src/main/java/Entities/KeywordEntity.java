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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "KEYWORD")
@NamedQueries({
    @NamedQuery(name = "KeywordEntity.findAll", query = "SELECT k FROM KeywordEntity k"),
    @NamedQuery(name = "KeywordEntity.findByKeyWord", query = "SELECT k FROM KeywordEntity k WHERE k.keyWord = :keyWord")})
public class KeywordEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "KEY_WORD")
    private String keyWord;
    @JoinTable(name = "ISKEYWORD", joinColumns = {
        @JoinColumn(name = "KEY_WORD", referencedColumnName = "KEY_WORD")}, inverseJoinColumns = {
        @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID")})
    @ManyToMany
    private Collection<InternshipinfoEntity> internshipinfoEntityCollection;

    public KeywordEntity() {
    }

    public KeywordEntity(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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
        hash += (keyWord != null ? keyWord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeywordEntity)) {
            return false;
        }
        KeywordEntity other = (KeywordEntity) object;
        if ((this.keyWord == null && other.keyWord != null) || (this.keyWord != null && !this.keyWord.equals(other.keyWord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.KeywordEntity[ keyWord=" + keyWord + " ]";
    }
    
}
