package Model.Beans;

import java.sql.Date;

/**
 *
 * @author Gohu
 */
public class Excel {
    private boolean cdc;
    private boolean ficheVisite;
    private boolean ficheEvalEntr;
    private boolean sondageWeb;
    private boolean rapportRendu;
    private boolean sout;
    private boolean planif;
    private boolean faite;
    private String noteTech;
    private String noteCom;

    public Excel(boolean cdc, boolean ficheVisite, boolean ficheEvalEntr, boolean sondageWeb, boolean rapportRendu,
            boolean sout, boolean planif, boolean faite, String noteTech, String noteCom) {
        this.cdc = cdc;
        this.ficheVisite = ficheVisite;
        this.ficheEvalEntr = ficheEvalEntr;
        this.sondageWeb = sondageWeb;
        this.rapportRendu = rapportRendu;
        this.sout = sout;
        this.planif = planif;
        this.faite = faite;
        this.noteTech = noteTech;
        this.noteCom = noteCom;
    }
    
    public Excel(){
        
    }

    public boolean isCdc() {
        return cdc;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public boolean isFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public boolean isFicheEvalEntr() {
        return ficheEvalEntr;
    }

    public void setFicheEvalEntr(boolean ficheEvalEntr) {
        this.ficheEvalEntr = ficheEvalEntr;
    }

    public boolean isSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public boolean isRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public boolean isSout() {
        return sout;
    }

    public void setSout(boolean sout) {
        this.sout = sout;
    }

    public boolean isPlanif() {
        return planif;
    }

    public void setPlanif(boolean planif) {
        this.planif = planif;
    }

    public boolean isFaite() {
        return faite;
    }

    public void setFaite(boolean faite) {
        this.faite = faite;
    }

    public String getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(String noteTech) {
        this.noteTech = noteTech;
    }

    public String getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(String noteCom) {
        this.noteCom = noteCom;
    }
    
    public static String getChecked(boolean bool){
        if(bool){
            return "checked";
        }
        else{
            return "";
        }
    }
}
