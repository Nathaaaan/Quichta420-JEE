<%-- 
    Document   : StudentInfo
    Created on : 13 nov. 2020, 15:52:16
    Author     : Gohu
--%>
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
        <%
            InternshipInfo info = (InternshipInfo) request.getAttribute("info");
            Intern intern = (Intern) request.getAttribute("intern");
            //out.println(info.getMeetingInfo());
            //out.println(intern.getFirstName());
        %>
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
                        <div class="content">
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
                            <div class="line"><div>Description de la mission : </div><div><% out.println(info.getDescription()); %></div></div>
                            <div class="line"><div>Commentaires : </div><div><% out.println(info.getTutorComment()); %></div></div>
                            <div class="line"><div>Remplir la fiche de visite  : </div><div></div></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
