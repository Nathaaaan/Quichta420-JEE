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
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByTutorId", query = "SELECT t FROM Tutor t WHERE t.tutorId = :tutorId"),
    @NamedQuery(name = "Tutor.findByFirstName", query = "SELECT t FROM Tutor t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Tutor.findByLastName", query = "SELECT t FROM Tutor t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Tutor.findByLogin", query = "SELECT t FROM Tutor t WHERE t.login = :login"),
    @NamedQuery(name = "Tutor.findByPassword", query = "SELECT t FROM Tutor t WHERE t.password = :password")})
public class Tutor implements Serializable {

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
    private Collection<Assign> assignCollection;

    public Tutor() {
    }

    public Tutor(Integer tutorId) {
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

    public Collection<Assign> getAssignCollection() {
        return assignCollection;
    }

    public void setAssignCollection(Collection<Assign> assignCollection) {
        this.assignCollection = assignCollection;
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
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.tutorId == null && other.tutorId != null) || (this.tutorId != null && !this.tutorId.equals(other.tutorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Beans.Tutor[ tutorId=" + tutorId + " ]";
    }
    
}
