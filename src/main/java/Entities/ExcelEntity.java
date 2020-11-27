/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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

/**
 *
 * @author Andriatiana Victor
 */
@Entity
@Table(name = "EXCEL")
@NamedQueries({
    @NamedQuery(name = "ExcelEntity.findAll", query = "SELECT e FROM ExcelEntity e"),
    @NamedQuery(name = "ExcelEntity.findByInternshipId", query = "SELECT e FROM ExcelEntity e WHERE e.internshipId = :internshipId"),
    @NamedQuery(name = "ExcelEntity.findByCdc", query = "SELECT e FROM ExcelEntity e WHERE e.cdc = :cdc"),
    @NamedQuery(name = "ExcelEntity.findByFicheVisite", query = "SELECT e FROM ExcelEntity e WHERE e.ficheVisite = :ficheVisite"),
    @NamedQuery(name = "ExcelEntity.findByFicheEvalEntr", query = "SELECT e FROM ExcelEntity e WHERE e.ficheEvalEntr = :ficheEvalEntr"),
    @NamedQuery(name = "ExcelEntity.findBySondageWeb", query = "SELECT e FROM ExcelEntity e WHERE e.sondageWeb = :sondageWeb"),
    @NamedQuery(name = "ExcelEntity.findByRapportRendu", query = "SELECT e FROM ExcelEntity e WHERE e.rapportRendu = :rapportRendu"),
    @NamedQuery(name = "ExcelEntity.findBySout", query = "SELECT e FROM ExcelEntity e WHERE e.sout = :sout"),
    @NamedQuery(name = "ExcelEntity.findByPlanif", query = "SELECT e FROM ExcelEntity e WHERE e.planif = :planif"),
    @NamedQuery(name = "ExcelEntity.findByFaite", query = "SELECT e FROM ExcelEntity e WHERE e.faite = :faite"),
    @NamedQuery(name = "ExcelEntity.findByNoteTech", query = "SELECT e FROM ExcelEntity e WHERE e.noteTech = :noteTech"),
    @NamedQuery(name = "ExcelEntity.findByNoteCom", query = "SELECT e FROM ExcelEntity e WHERE e.noteCom = :noteCom")})
public class ExcelEntity implements Serializable {

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
    private AssignEntity assignEntity;

    public ExcelEntity() {
    }

    public ExcelEntity(Integer internshipId) {
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

    public AssignEntity getAssignEntity() {
        return assignEntity;
    }

    public void setAssignEntity(AssignEntity assignEntity) {
        this.assignEntity = assignEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internshipId != null ? internshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExcelEntity)) {
            return false;
        }
        ExcelEntity other = (ExcelEntity) object;
        if ((this.internshipId == null && other.internshipId != null) || (this.internshipId != null && !this.internshipId.equals(other.internshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ExcelEntity[ internshipId=" + internshipId + " ]";
    }
    
}
