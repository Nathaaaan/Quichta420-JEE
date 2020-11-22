package Database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static String URL;
    private static String USER;
    private static String PASS;
    
    /**
     * A method used to get connection object to the database.
     * @return Connection object
     * @throws RuntimeException
     */
    // TODO: Check thread safety
    public static Connection getCo() throws RuntimeException {
        try{
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex){
            throw new RuntimeException ("Couldn't get connection to database");
        }
    }
    
    
    /**
     * Loads credentials from the properties file into static attributes.
     * @param properties Properties file where database credentials are stored.
     * @throws IOException 
     */
    public static void loadCredentials (InputStream properties)throws IOException{
        
        Properties prop = new Properties();
        InputStream input = properties;
        prop.load(input);
        
        URL = prop.getProperty("db_url");
        USER = prop.getProperty("db_user");
        PASS = prop.getProperty("db_pass");
    }
}
