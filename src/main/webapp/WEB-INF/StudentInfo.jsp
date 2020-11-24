<%--
    Document   : StudentInfo
    Created on : 13 nov. 2020, 15:52:16
    Author     : Gohu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Beans.Intern"%>
<%@page import="Model.Beans.InternshipInfo"%>
<%@page import="Model.Beans.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style_studentInfo.css"/> 
    </head>
    <body>
        <%@include file="Header.jspf"%>
        <%
            InternshipInfo info = (InternshipInfo) request.getAttribute("info");
            Intern intern = (Intern) request.getAttribute("intern");
        %>
        <form action="UpdateInternshipInfos" method="POST">
            <div class="pageContainer">
                <div class="page">
                    <div class="pageHeader">
                        <div>Fiche de détails</div>
                        <img class="logoEfrei" src="images/efreiBlue.png"/>
                    </div>
                    <hr/>
                    <div class="pageContent">
                        <div class="firstTwo">
                            <div class="container">
                                <div class="bar_title">
                                    <div>Details du stagiaire : <% out.println(intern.getFirstName()); %></div>
                                </div>
                                <div class="containImage"><img class="person" src="images/iconPerson.png"/></div>
                                <div class="content">
                                    <div class="line"><div>Identifiant : </div><div><% out.println(intern.getId()); %></div></div>
                                    <div class="line"><div>Nom : </div><div><% out.println(intern.getLastName()); %></div></div>
                                    <div class="line"><div>Prenom : </div><div><% out.println(intern.getFirstName()); %></div></div>
                                    <div class="line"><div>Groupe : </div><div><% out.println(intern.getSchoolGroup()); %></div></div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="bar_title">
                                    <div>Details de l'entreprise : <% out.println(info.getCompany().getCompanyName()); %></div>
                                </div>
                                <div class="content" id="details">
                                    <div class="line"><div>Nom : </div><div><% out.println(info.getCompany().getCompanyName()); %></div></div>
                                    <div class="line"><div>Adresse de l'entreprise : </div><div><% out.println(info.getCompany().getCompanyAddress()); %></div></div>
                                    <div class="line"><div>Maitre d'apprentissage : </div><div><% out.println(info.getMaster()); %></div></div>
                                    <div class="line"><div>date de debut : </div><div><% out.println(info.getDateDebut().toString()); %></div></div>
                                    <div class="line"><div>date de fin : </div><div><% out.println(info.getDateFin().toString()); %></div></div>
                                </div>
                            </div>
                        </div>
                        <div class="third">
                            <div class="container">
                                <div class="bar_title">
                                    <div>Gestion du stage</div>
                                </div>
                                <div class="content">
                                    <div class="line"><div>Description de la mission : </div><textarea name="description"><% out.println(info.getDescription()); %></textarea></div>
                                    <div class="line"><div>Commentaires : </div><textarea name="tutorComment"><% out.println(info.getTutorComment()); %></textarea></div>
                                    <div class="line"><div>Remplir la fiche de visite  : </div><textarea name="ficheVisite"></textarea></div>
                                </div>
                            </div>
                        </div>
                    </div>            
                    <div class="container-buttons">
                        <a href="WelcomeController">Retour</a>
                        <input type="hidden" name="internshipId" value="<c:out value="${info.internshipId}"/>" />
                        <input type="submit" value="Valider"/>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
