# Quichta420-JEE


Configuration : GlassFish Server - Java EE 8 Web
Test different Branch


--- DATABASE ---

1) create a new database
      - in netbeans go to service
      - in database, right click on "javadb"
      - click on create database
      - Database name = jeeproject
      - username = root
      - password = root
      
3) implement the database
      - still in service and database
      - right click on "jdbc/derby://localhost:1527/jeedb
      - click on execute command
      - copy all the create and insert from scriptjee.sql and execute it
      
2) inside the java code you can use the model BD. To create a new connection just have to do
      - import Model.DB
      - import java.sql.connection
      
      - Connection conn = DB.getCo()
   
      //the url of the db and username and password are stored inside the BD model
