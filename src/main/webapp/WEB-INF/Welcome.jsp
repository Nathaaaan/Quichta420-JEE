<%-- 
    Document   : Welcome
    Created on : 4 nov. 2020, 15:02:55
    Author     : natha
--%>

<%@page import="Utils.Constants"%>
<%@page import="Model.Beans.Company"%>
<%@page import="java.sql.Date"%>
<%@page import="Model.Beans.Intern"%>
<%@page import="Model.Beans.Excel"%>
<%@page import="Model.Beans.InternshipInfo"%>
<%@page import="Model.Beans.Assign"%>
<%@page import="java.util.ArrayList"%>
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
        <!-- This line import header we have to put it in all the jsp page wich have the header instead of copy paste it-->
        <%@include file="Header.jspf"%>
        
        <div class="welcome-container">
            <h2>Bonjour <% out.println(((Tutor) session.getAttribute("user")).getName()); %> <% out.println(((Tutor) session.getAttribute("user")).getLastName()); %> !</h2>
        </div>

        <div class="container-content">
            <div class="container-header">
                <h2>Liste des étudiants :</h2>
                
                <div class="search">
                    <form name="SearchForm" action="SearchController" method="POST">
                        <input type="text" placeholder="search box" name="SearchInput"/>
                        <input type="submit" name="SendButton" value="Search"/>
                    </form>
                </div>
            </div>

            <div class="container-list">
                <table class="list-table">
                    <tr>
                        <th>#</th>
                        <th class="tdGr">Groupe</th>
                        <th class="tdLa">Nom</th>
                        <th class="tdNa">Prenom</th>
                        <th class="tdCb">C.d.C</th>
                        <th class="tdCb">Fiche de visite</th>
                        <th class="tdCb">Fiche evaluation entreprise</th>
                        <th class="tdCb">Sondage web</th>
                        <th class="tdCb">Rapport rendu</th>
                        <th class="tdCb">Soutenance</th>
                        <th class="tdCb">Visite planifié</th>
                        <th class="tdCb">Visite faite</th>
                        <th class="tdEtr">Entreprise</th>
                        <th class="tdMdS">Maitre de stage</th>
                        <th class="tdAddr">Adresse</th>
                        <th class="tdNote">Note tech</th>
                        <th class="tdNote">Note com</th>
                        
                        <th colspan="3">Actions</th>
                      
                        

                    </tr>
                    

                    <%
                        ArrayList<Assign> assigns = (ArrayList<Assign>)request.getAttribute("keyExcel");
                        
                        for(Assign assign : assigns){
                            InternshipInfo info = assign.getInternshipInfo();
                            Excel excel = info.getExcel();
                            Intern intern = assign.getIntern();
                            Company company = info.getCompany();
                            
                            out.println("<form method=\"POST\" action=\"UpdateInfos\">");
                                out.println("<tr>");
                                    out.println("<td><a class=\"detailsBtn\" href=\"ViewStudentInfo?internshipId="+info.getInternshipId()
                                    +"\"><img src=\"images/iconeDetails.png\"/></a></td>");
                                    out.println("<td class=\"tdGr\">"+intern.getSchoolGroup()+"</td>");
                                    out.println("<td class=\"tdLa\">"+intern.getLastName()+"</td>");
                                    out.println("<td class=\"tdNa\">"+intern.getFirstName()+"</td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_CDC+"\" type=\"checkbox\""+Excel.getChecked(excel.isCdc())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_FICHE_VISITE+"\" type=\"checkbox\""+Excel.getChecked(excel.isFicheVisite())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_FICHE_EVAL+"\" type=\"checkbox\""+Excel.getChecked(excel.isFicheEvalEntr())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_SONDAGE_WEB+"\" type=\"checkbox\""+Excel.getChecked(excel.isSondageWeb())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_RAPPORT_RENDU+"\" type=\"checkbox\""+Excel.getChecked(excel.isRapportRendu())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_SOUT+"\" type=\"checkbox\""+Excel.getChecked(excel.isSout())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_PLANIF+"\" type=\"checkbox\""+Excel.getChecked(excel.isPlanif())+"/></td>");
                                    out.println("<td class=\"tdCb\"><input name=\""+Constants.UP_FAITE+"\" type=\"checkbox\""+Excel.getChecked(excel.isFaite())+"/></td>");
                                    out.println("<td class=\"tdEtr\">"+company.getCompanyName()+"</td>");
                                    out.println("<td class=\"tdMdS\">"+info.getMaster()+"</td>");
                                    out.println("<td class=\"tdAddr\">"+company.getCompanyAddress()+"</td>");
                                    out.println("<td class=\"tdNote\"><input type=\"text\" name=\""+Constants.UP_NOTE_TECH+"\" value=\""+excel.getNoteTech()+"\"</td>");
                                    out.println("<td class=\"tdNote\"><input type=\"text\" name=\""+Constants.UP_NOTE_COM+"\" value=\""+excel.getNoteCom()+"\"</td>");
                                    out.println("<td> <input type=\"submit\" value=\"Mis à jour\" /> </td>");
                                  out.println("</tr>");
                                  out.println("<input type=\"hidden\" value=\""+excel.getExcelId()+"\" name=\""+Constants.UP_EXCEL_ID+"\" />");
                              out.println("</form>");
                        }
                    %>
                </table>
            </div>

            <div class="container-buttons" >
                <a href="NewStudent">Ajouter un stagiaire</a>
            </div>
        </div>

    </body>
</html>