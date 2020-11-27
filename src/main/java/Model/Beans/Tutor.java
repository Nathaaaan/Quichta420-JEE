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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "TUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t"),
    @NamedQuery(name = "Tutor.findByTutorId", query = "SELECT t FROM Tutor t WHERE t.id = :tutorId"),
    @NamedQuery(name = "Tutor.findByFirstName", query = "SELECT t FROM Tutor t WHERE t.name = :firstName"),
    @NamedQuery(name = "Tutor.findByLastName", query = "SELECT t FROM Tutor t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Tutor.findByLogin", query = "SELECT t FROM Tutor t WHERE t.login = :login"),
    @NamedQuery(name = "Tutor.findByPassword", query = "SELECT t FROM Tutor t WHERE t.password = :password")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TUTOR_ID")
    private Integer id;
    @Size(max = 40)
    @Column(name = "FIRST_NAME")
    private String name;
    @Size(max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 40)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 40)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "tutor")
    private Collection<Assign> assignCollection;

    public Tutor() {
    }

    public Tutor(Integer tutorId) {
        this.id = tutorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String _login) {
        this.login = _login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    
    
}
