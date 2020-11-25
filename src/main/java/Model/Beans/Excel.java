package Model.Beans;


/**
 *
 * @author Gohu
 */
public class Excel {
    
    private int internshipId;
    private boolean cdc;
    private boolean ficheVisite;
    private boolean ficheEvalEntr;
    private boolean sondageWeb;
    private boolean rapportRendu;
    private boolean sout;
    private boolean planif;
    private boolean faite;
    private int noteTech;
    private int noteCom;
    
    
    public Excel(){}
    
    
    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    
    public boolean getCdc() {
        return cdc;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public boolean getFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public boolean getFicheEvalEntr() {
        return ficheEvalEntr;
    }

    public void setFicheEvalEntr(boolean ficheEvalEntr) {
        this.ficheEvalEntr = ficheEvalEntr;
    }

    public boolean getSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public boolean getRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public boolean getSout() {
        return sout;
    }

    public void setSout(boolean sout) {
        this.sout = sout;
    }

    public boolean getPlanif() {
        return planif;
    }

    public void setPlanif(boolean planif) {
        this.planif = planif;
    }

    public boolean getFaite() {
        return faite;
    }

    public void setFaite(boolean faite) {
        this.faite = faite;
    }

    public int getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(int noteTech) {
        this.noteTech = noteTech;
    }

    public int getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(int noteCom) {
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
