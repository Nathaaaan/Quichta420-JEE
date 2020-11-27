package Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
            throw new RuntimeException ("Couldn't get connection to database\n"+ex.getMessage());
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
    
    public static void HikaruConfig(InputStream properties)throws IOException{
        
        Properties props = new Properties();
        Properties prop = new Properties();
        InputStream input = properties;
        prop.load(input);
        
        props.setProperty("dataSourceClassName", "org.apache.derby.jdbc.ClientDataSource");
        props.setProperty("dataSource.user", prop.getProperty("db_user"));
        props.setProperty("dataSource.password", prop.getProperty("db_pass"));
        props.setProperty("dataSource.databaseName", "ST2EEDB");
        props.put("dataSource.logWriter", new PrintWriter(System.out));

        HikariConfig config = new HikariConfig(props);
        HikariDataSource ds = new HikariDataSource(config);
    }
    
}
