package Model.Beans;


/**
 *
 * @author Gohu
 */
public class Excel {
    
    private int excelId;
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

    
    public int getExcelId() {
        return excelId;
    }

    public void setExcelId(int excelId) {
        this.excelId = excelId;
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
