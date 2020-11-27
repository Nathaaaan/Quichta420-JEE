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
@Table(name = "TUTOR")
@NamedQueries({
    @NamedQuery(name = "TutorEntity.findAll", query = "SELECT t FROM TutorEntity t"),
    @NamedQuery(name = "TutorEntity.findByTutorId", query = "SELECT t FROM TutorEntity t WHERE t.tutorId = :tutorId"),
    @NamedQuery(name = "TutorEntity.findByFirstName", query = "SELECT t FROM TutorEntity t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TutorEntity.findByLastName", query = "SELECT t FROM TutorEntity t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TutorEntity.findByLogin", query = "SELECT t FROM TutorEntity t WHERE t.login = :login"),
    @NamedQuery(name = "TutorEntity.findByPassword", query = "SELECT t FROM TutorEntity t WHERE t.password = :password")})
public class TutorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TUTOR_ID")
    private Integer tutorId;
    @Size(max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 40)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 40)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "tutorId")
    private Collection<AssignEntity> assignEntityCollection;

    public TutorEntity() {
    }

    public TutorEntity(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (tutorId != null ? tutorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TutorEntity)) {
            return false;
        }
        TutorEntity other = (TutorEntity) object;
        if ((this.tutorId == null && other.tutorId != null) || (this.tutorId != null && !this.tutorId.equals(other.tutorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TutorEntity[ tutorId=" + tutorId + " ]";
    }
    
}
