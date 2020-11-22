<%-- 
    Document   : Welcome
    Created on : 4 nov. 2020, 15:02:55
    Author     : natha
--%>

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
                    <input type="text" placeholder="search box" />
                    <button>Search</button>
                </div>
            </div>

            <div class="container-list">
                <table class="list-table">
                    <tr>
                        <th>#</th>
                        <th>group</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>CDC</th>
                        <th>fiche_visite</th>
                        <th>fiche_eval_entr</th>
                        <th>sondage_web</th>
                        <th>rapport_rendu</th>
                        <th>sout</th>
                        <th>planif</th>
                        <th>faite</th>
                        <th>ENTR</th>
                        <th>MdS</th>
                        <th>Adresse</th>
                        <th>note_tech</th>
                        <th>note_com</th>
                        
                        <th colspan="3">Actions</th>
                      
                        

                    </tr>
                    

                    <%
                        //This tab should be downlades by the database thanks to the tutorId
                        ArrayList<Assign> assigns = (ArrayList<Assign>)request.getAttribute("keyExcel");
                        //I'm adding some fake value for testing
                        /*assigns.add(new Assign(null,new Intern(0,"Antoine", "Banniel", "M1"),
                            new InternshipInfo(1, new Company(0, "Google", "420 rue quichta"), null, null, null, null, null, null, "Hugo", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(1, false, true, true, false, false, true, true, false, 2, 3))));
                        assigns.add(new Assign(null,new Intern(0,"Ryan", "Viehweger", "M1"),
                            new InternshipInfo(2, new Company(0,"Amazon","1 rue amazooo"), null, null, null, null, null, null, "Nathan", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(2,true, true, false, false, true, true, false, false, 2,3))));
                        assigns.add(new Assign(null,new Intern(0,"Seedy", "Jobe", "M1"),
                            new InternshipInfo(3, new Company(0,"Apple","1 rue des pommes"), null, null, null, null, null, null, "Andriatiana", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(3, true, false, false, true, true, true, false, false, 4, 5))));*/
                        
                        for(Assign assign : assigns){
                            InternshipInfo info = assign.getInternshipInfo();
                            Excel excel = info.getExcel();
                            Intern intern = assign.getIntern();
                            Company company = info.getCompany();
                            
                            out.println("<tr>");
                                out.println("<td><a class=\"detailsBtn\" href=\"ViewStudentInfo?internshipId="+assign.getInternshipInfo().getInternshipId()
                                +"\"><img src=\"images/iconeDetails.png\"/></a></td>");
                                out.println("<td>"+intern.getSchoolGroup()+"</td>");
                                out.println("<td>"+intern.getLastName()+"</td>");
                                out.println("<td>"+intern.getFirstName()+"</td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isCdc())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isFicheVisite())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isFicheEvalEntr())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isSondageWeb())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isRapportRendu())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isSout())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isPlanif())+"/></td>");
                                out.println("<td><input type=\"checkbox\""+Excel.getChecked(excel.isFaite())+"/></td>");
                                out.println("<td>"+company.getCompanyName()+"</td>");
                                out.println("<td>"+info.getMaster()+"</td>");
                                out.println("<td>"+company.getCompanyAddress()+"</td>");
                                out.println("<td>"+excel.getNoteTech()+"</td>");
                                out.println("<td>"+excel.getNoteTech()+"</td>");
                              out.println("<td> <a href='#'> <button> Mise à jour </button> </a> </td>");

                              out.println("</tr>");
                        }
                    %>
                </table>
            </div>

            <div class="container-buttons">
                <a href="#">Ajouter un stagiaire</a>
            </div>
        </div>

    </body>
</html>