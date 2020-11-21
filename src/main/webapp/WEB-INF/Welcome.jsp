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
<%@page import="Model.Services.Assign"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    </tr>

                    <%
                        //This tab should be downlades by the database thanks to the tutorId
                        ArrayList<Assign> assigns = new ArrayList<Assign>();
                        //I'm adding some fake value for testing
                        assigns.add(new Assign(null,new Intern(0,"Antoine", "Banniel", "M1"),
                            new InternshipInfo(0, new Company(0, "Google", "420 rue quichta"), null, null, null, null, null, null, "Hugo", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(false, true, true, false, false, true, true, false, "", ""))));
                        assigns.add(new Assign(null,new Intern(0,"Ryan", "Viehweger", "M1"),
                            new InternshipInfo(0, new Company(0,"Amazon","1 rue amazooo"), null, null, null, null, null, null, "Nathan", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(true, true, false, false, true, true, false, false, "", ""))));
                        assigns.add(new Assign(null,new Intern(0,"Seedy", "Jobe", "M1"),
                            new InternshipInfo(0, new Company(0,"Apple","1 rue des pommes"), null, null, null, null, null, null, "Andriatiana", Date.valueOf("2020-01-01"), Date.valueOf("2020-08-01"),
                            new Excel(true, false, false, true, true, true, false, false, "", ""))));
                        
                        int cmpt = 1;
                        for(Assign assign : assigns){
                            InternshipInfo info = assign.getInternshipInfo();
                            Excel excel = info.getExcel();
                            Intern intern = assign.getIntern();
                            Company company = info.getCompany();
                            
                            out.println("<tr>");
                                out.println("<td>"+cmpt+"</td>");
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
                            out.println("</tr>");
                            
                            cmpt++;
                        }
                    %>
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