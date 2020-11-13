<%-- 
    Document   : StudentInfo
    Created on : 13 nov. 2020, 15:52:16
    Author     : Gohu
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Intern"%>
<%@page import="Model.InternshipInfo"%>
<%@page import="Model.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            InternshipInfo info = (InternshipInfo) request.getAttribute("info");
            out.println(info.getMeetingInfo());
        %>
    </body>
</html>
