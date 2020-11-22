/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
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
