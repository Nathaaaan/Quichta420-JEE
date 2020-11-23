# Quichta420-JEE


Configuration : GlassFish Server - Java EE 8 Web (jdk 1.8.0_271)


--- DATABASE ---

1) create a new database
      - in netbeans go to service
      - in database, right click on "javadb"
      - click on create database
      - Database name = ST2EEDB
      - username = adm
      - password = adm
      
2) implement the database
      - still in service and database
      - right click on "jdbc/derby://localhost:1527/ST2EEDB
      - click on execute command
      - execute all the command of the Creation Script
      
      
3) inside the java code you can use the model BD. To create a new connection just have to do
      - import Model.DB
      - import java.sql.connection
      
      - Connection conn = DB.getCo()
   
      //the url of the db and username and password are stored inside the db.properties file
