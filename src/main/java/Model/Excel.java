/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author seedy
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
	private String ENTR;
	private String mds;
	private String adresse;
	private int noteTech;
	private int noteCom;
        
        public Excel(){};

    public Excel(int excelId, boolean cdc, boolean ficheVisite, boolean ficheEvalEntr, boolean sondageWeb, boolean rapportRendu, boolean sout, boolean planif, boolean faite, String ENTR, String mds, String adresse, int noteTech, int noteCom) {
        this.excelId = excelId;
        this.cdc = cdc;
        this.ficheVisite = ficheVisite;
        this.ficheEvalEntr = ficheEvalEntr;
        this.sondageWeb = sondageWeb;
        this.rapportRendu = rapportRendu;
        this.sout = sout;
        this.planif = planif;
        this.faite = faite;
        this.ENTR = ENTR;
        this.mds = mds;
        this.adresse = adresse;
        this.noteTech = noteTech;
        this.noteCom = noteCom;
    }
        
  

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

    public String getENTR() {
        return ENTR;
    }

    public void setENTR(String ENTR) {
        this.ENTR = ENTR;
    }

    public String getMds() {
        return mds;
    }

    public void setMds(String mds) {
        this.mds = mds;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    
}
