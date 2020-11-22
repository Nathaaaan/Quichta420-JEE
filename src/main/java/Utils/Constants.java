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
    
    //web pages path
    public static final String LOGIN_PAGE = "/WEB-INF/index.jsp";
    public static final String WELCOME_PAGE = "/WEB-INF/Welcome.jsp";
    public static final String STUDENT_PAGE = "/WEB-INF/StudentInfo.jsp";
    public static final String HEADER = "/WEB-INF/Header.jspf";
    
    //controllers
    public static final String LOGIN_CONTROLLER = "/LoginController";
    public static final String WELCOME_CONTROLLER = "/WelcomeController";
    public static final String STUDENT_CONTROLLER = "/ViewStudentInfo";
    public static final String LOGOUT_CONTROLLER = "/LogOut";
    
    //database access credentials
    public static final String DB_CRED="/WEB-INF/db.properties";
}
