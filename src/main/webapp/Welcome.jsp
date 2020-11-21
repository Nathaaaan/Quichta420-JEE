<%-- 
    Document   : Welcome
    Created on : 4 nov. 2020, 15:02:55
    Author     : natha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="style_welcome.css" rel="stylesheet">


    </head>
    <body>
        <header>
            <div class="logo">
                <h2>LOGO HERE</h2>
            </div>

            <nav>
                <ul>
                    <li> <a href="#">Add Student</a> </li>
                    <li> <a href="#">M. Nom</a> </li>
                    <li> <a href="#">Logout</a></li>
                </ul>
            </nav>
        </header>
        <h1>Hello World!</h1>
        <p>Si j'arrive à cette page, c'est que le login marche</p>


        <div class="container-content">
            <div class="container-header">
                <h2>student list</h2>
                <div class="search">
                    <input type="text" placeholder="search box" />
                </div>
            </div>

            <div class="container-list">
                <table class="list-table">

                    <tr>
                        <th>#excelId</th>
                        <th>cdc</th>
                        <th>ficheVisite</th>
                        <th>sondageWeb</th>
                        <th>rapportRendu</th>
                        <th>sout</th>
                        <th>planif</th>
                        <th>faite</th>
                        <th>ENTR</th>
                        <th>MdS</th>
                        <th>Adresse</th>
                        <th>note_tech</th>
                        <th>note_com</th>
                    </tr>
              

                     <c:forEach items="${keyExcel}" var="excelInfo">
                     <tr>
                    <td>${excelInfo.excelId}</td>
                    <td>${excelInfo.cdc}</td>
                    <td>${excelInfo.ficheVisite}</td>
                    <td>${excelInfo.sondageWeb}</td>
                    <td> <input type="checkbox" checked=${excelInfo.rapportRendu} /> </td>
                    <td>${excelInfo.sout}</td>
                    <td>${excelInfo.planif}</td>
                    <td>${excelInfo.faite}</td>
                    <td>${excelInfo.ENTR}</td>
                    <td>${excelInfo.mds}</td>
                    <td>${excelInfo.adresse}</td>
                    <td>${excelInfo.noteTech}</td>
                    <td> <input type="checkbox" checked="${excelInfo.noteCom}" /> </td>
                </tr>
            </c:forEach>
       
                </table>
            </div>

            <div class="container-buttons">
                <button>AJOUTER</button>
                <button>VALIDER</button>
                <button>DETAILS</button>
                
           
            </div>
            
           
                
        </div>

    </body>
</html>
