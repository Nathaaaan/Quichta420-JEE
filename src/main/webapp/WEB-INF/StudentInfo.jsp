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
                                        <%--
        <%
            InternshipInfo info = (InternshipInfo) request.getAttribute("info");
            Intern intern = (Intern) request.getAttribute("intern");
        %>
                                        --%>
        <c:set var="info" value="${requestScope.info}"/>
        <c:set var="intern" value="${requestScope.intern}"/>
        
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
                                    <div>Details du stagiaire : <c:out value="${intern.lastName} ${intern.firstName}"/></div>
                                </div>
                                <div class="containImage"><img class="person" src="images/iconPerson.png"/></div>
                                <div class="content">
                                    <div class="line"><div>Identifiant : </div><div><c:out value="${intern.id}"/></div></div>
                                    <div class="line"><div>Nom : </div><div><c:out value="${intern.lastName}"/></div></div>
                                    <div class="line"><div>Prenom : </div><div><c:out value="${intern.firstName}"/></div></div>
                                    <div class="line"><div>Groupe : </div><div><c:out value="${intern.schoolGroup}"/></div></div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="bar_title">
                                    <div>Details de l'entreprise : <c:out value="${info.company.companyName}"/></div>
                                </div>
                                <div class="content" id="details">
                                    <div class="line"><div>Nom : </div><div><c:out value="${info.company.companyName}"/></div></div>
                                    <div class="line"><div>Adresse de l'entreprise : </div><div><c:out value="${info.company.companyAddress}"/></div></div>
                                    <div class="line"><div>Maitre d'apprentissage : </div><div><c:out value="${info.master}"/></div></div>
                                    <div class="line"><div>Date de début : </div><div><c:out value="${info.dateDebut.toString()}"/></div></div>
                                    <div class="line"><div>Date de fin : </div><div><c:out value="${info.dateFin.toString()}"/></div></div>
                                </div>
                            </div>
                        </div>
                        <div class="third">
                            <div class="container">
                                <div class="bar_title">
                                    <div>Gestion du stage</div>
                                </div>
                                <div class="content">
                                    <div class="line"><div>Description de la mission : </div><textarea name="description"><c:out value="${info.description}"/></textarea></div>
                                    <div class="line"><div>Commentaires : </div><textarea name="tutorComment"><c:out value="${info.tutorComment}"/></textarea></div>
                                    <div class="line"><div>Remplir la fiche de visite  : </div><textarea name="meetingInfo"><c:out value="${info.meetingInfo}"/></textarea></div>
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
