/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "KEYWORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KeyWord.findAll", query = "SELECT k FROM KeyWord k"),
    @NamedQuery(name = "KeyWord.findByKeyWord", query = "SELECT k FROM KeyWord k WHERE k.word = :keyWord")})
public class KeyWord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "KEY_WORD")
    private String word;
    @JoinTable(name = "ISKEYWORD", joinColumns = {
        @JoinColumn(name = "KEY_WORD", referencedColumnName = "KEY_WORD")}, inverseJoinColumns = {
        @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID")})
    @ManyToMany
    private Collection<InternshipInfo> internshipInfoCollection;

    public KeyWord() {
    }

    public KeyWord(String keyWord) {
        this.word = keyWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    @XmlTransient
    public Collection<InternshipInfo> getInternshipInfoCollection() {
        return internshipInfoCollection;
    }

    public void setInternshIpinfoCollection(Collection<InternshipInfo> internshipinfoCollection) {
        this.internshipInfoCollection = internshipinfoCollection;
    }
    
}
