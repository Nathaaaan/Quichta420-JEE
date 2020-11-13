# Quichta420-JEE


Configuration : GlassFish Server - Java EE 8 Web
Test different Branch


--- DATABASE ---

1) create a new database
      in netbeans go to service
      in database, right click on "javadb"
      click on create database
      Database name = jeeproject
      username = root
      password = root
      
2) inside the java code you can use the model BD. To create a new connection just have to do
      import Model.DB
      import java.sql.connection
      
      Connection conn = DB.getCo()
   
      //the url of the db and username and password are stored inside the BD model
