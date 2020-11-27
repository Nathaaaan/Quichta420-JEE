/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Andriatiana Victor
 */
public class DataSource {
    //private static HikariConfig config = new HikariConfig("/WEB-INF/dataSource.properties");
    //private static HikariDataSource ds = new HikariDataSource(config);
    
    //private static HikariConfig config = new HikariConfig();
    //private static HikariDataSource ds;
    

    /*static {
        config.setJdbcUrl( "jdbc:derby://localhost:1527/ST2EEDB" );
        config.setUsername( "adm" );
        config.setPassword( "adm" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }*/

    private DataSource() {
    }

    /*public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }*/
    
    /*public static Properties getProperty(){
        Properties prop = new Properties();
        InputStream input = properties;
        prop.load(input);
        
        URL = prop.getProperty("db_url");
        USER = prop.getProperty("db_user");
        PASS = prop.getProperty("db_pass");
    }*/
}
