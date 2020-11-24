package Utils;

/**
 * Provides a set of static final constant Strings that should make the rest of
 * the code cleaner and more maintainable.
 * @author Andriatiana Victor
 */
public class Constants {
    //jsp field name
    public static final String LOGIN_USER = "UsernameForm";
    public static final String LOGIN_PWD = "PassForm";
    public static final String SEARCH_INPUT = "SearchInput";
    
    public static final String UP_CDC = "cdc";
    public static final String UP_FICHE_VISITE = "ficheVisite";
    public static final String UP_FICHE_EVAL = "ficheEval";
    public static final String UP_SONDAGE_WEB = "sondageWeb";
    public static final String UP_RAPPORT_RENDU = "rapportRendu";
    public static final String UP_SOUT = "sout";
    public static final String UP_PLANIF = "planif";
    public static final String UP_FAITE = "faite";
    public static final String UP_NOTE_COM = "noteCom";
    public static final String UP_NOTE_TECH = "noteTech";
    public static final String UP_EXCEL_ID = "excelId";
    
    public static final String UP_DESCRIPTION = "description";
    public static final String UP_TUTOR_COMMENT = "tutorComment";
    public static final String UP_INTERNSHIP_ID = "internshipId";
    
    //web pages path
    public static final String LOGIN_PAGE = "/WEB-INF/index.jsp";
    public static final String WELCOME_PAGE = "/WEB-INF/Welcome.jsp";
    public static final String STUDENT_PAGE = "/WEB-INF/StudentInfo.jsp";
    public static final String HEADER = "/WEB-INF/Header.jspf";
    public static final String ADD_STUDENT_PAGE = "/WEB-INF/NewStudent.jsp";
    
    //controllers
    public static final String LOGIN_CONTROLLER = "/LoginController";
    public static final String WELCOME_CONTROLLER = "/WelcomeController";
    public static final String STUDENT_CONTROLLER = "/ViewStudentInfo";
    public static final String LOGOUT_CONTROLLER = "/LogOut";
    
    //database access credentials
    public static final String DB_CRED="/WEB-INF/db.properties";
}
