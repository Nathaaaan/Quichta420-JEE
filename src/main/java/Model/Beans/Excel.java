/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gohu
 */
@Entity
@Table(name = "EXCEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Excel.findAll", query = "SELECT e FROM Excel e"),
    @NamedQuery(name = "Excel.findByInternshipId", query = "SELECT e FROM Excel e WHERE e.internshipId = :internshipId"),
    @NamedQuery(name = "Excel.findByCdc", query = "SELECT e FROM Excel e WHERE e.cdc = :cdc"),
    @NamedQuery(name = "Excel.findByFicheVisite", query = "SELECT e FROM Excel e WHERE e.ficheVisite = :ficheVisite"),
    @NamedQuery(name = "Excel.findByFicheEvalEntr", query = "SELECT e FROM Excel e WHERE e.ficheEvalEntr = :ficheEvalEntr"),
    @NamedQuery(name = "Excel.findBySondageWeb", query = "SELECT e FROM Excel e WHERE e.sondageWeb = :sondageWeb"),
    @NamedQuery(name = "Excel.findByRapportRendu", query = "SELECT e FROM Excel e WHERE e.rapportRendu = :rapportRendu"),
    @NamedQuery(name = "Excel.findBySout", query = "SELECT e FROM Excel e WHERE e.sout = :sout"),
    @NamedQuery(name = "Excel.findByPlanif", query = "SELECT e FROM Excel e WHERE e.planif = :planif"),
    @NamedQuery(name = "Excel.findByFaite", query = "SELECT e FROM Excel e WHERE e.faite = :faite"),
    @NamedQuery(name = "Excel.findByNoteTech", query = "SELECT e FROM Excel e WHERE e.noteTech = :noteTech"),
    @NamedQuery(name = "Excel.findByNoteCom", query = "SELECT e FROM Excel e WHERE e.noteCom = :noteCom")})
public class Excel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERNSHIP_ID")
    private Integer internshipId;
    @Column(name = "CDC")
    private Boolean cdc;
    @Column(name = "FICHE_VISITE")
    private Boolean ficheVisite;
    @Column(name = "FICHE_EVAL_ENTR")
    private Boolean ficheEvalEntr;
    @Column(name = "SONDAGE_WEB")
    private Boolean sondageWeb;
    @Column(name = "RAPPORT_RENDU")
    private Boolean rapportRendu;
    @Column(name = "SOUT")
    private Boolean sout;
    @Column(name = "PLANIF")
    private Boolean planif;
    @Column(name = "FAITE")
    private Boolean faite;
    @Column(name = "NOTE_TECH")
    private Integer noteTech;
    @Column(name = "NOTE_COM")
    private Integer noteCom;
    @JoinColumn(name = "INTERNSHIP_ID", referencedColumnName = "INTERNSHIP_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Assign assign;

    public Excel() {
    }

    public Excel(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Boolean getCdc() {
        return cdc;
    }

    public void setCdc(Boolean cdc) {
        this.cdc = cdc;
    }

    public Boolean getFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(Boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public Boolean getFicheEvalEntr() {
        return ficheEvalEntr;
    }

    public void setFicheEvalEntr(Boolean ficheEvalEntr) {
        this.ficheEvalEntr = ficheEvalEntr;
    }

    public Boolean getSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(Boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public Boolean getRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(Boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public Boolean getSout() {
        return sout;
    }

    public void setSout(Boolean sout) {
        this.sout = sout;
    }

    public Boolean getPlanif() {
        return planif;
    }

    public void setPlanif(Boolean planif) {
        this.planif = planif;
    }

    public Boolean getFaite() {
        return faite;
    }

    public void setFaite(Boolean faite) {
        this.faite = faite;
    }

    public Integer getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(Integer noteTech) {
        this.noteTech = noteTech;
    }

    public Integer getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(Integer noteCom) {
        this.noteCom = noteCom;
    }
    
}
