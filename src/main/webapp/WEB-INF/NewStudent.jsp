<%-- 
    Document   : NewStudent
    Created on : Nov 24, 2020, 3:35:04 PM
    Author     : seedy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
        <link href="style_addStudent.css" rel="stylesheet"">
    </head>
    <body>
        <%@include file="Header.jspf"%>
        <h1>Add New Student</h1>
        
    
        
<div class="form-style-10">
    <h1>Add New Student</h1>
    
    <!--get tutor ID for session-->
    <form  action="NewStudent" method="POST">
        
        <div class="section"><span>1</span>Student Info</div>
        <div class="inner-wrap">
            <div>
                <label>First Name</label>
                <input type="text" name="firstname"/>
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name="lastname" />
            </div>
            <div>
                <label><span>Group Name</span></label>
                <select name="schoolGroup" class="select-field">
                    <option disabled>Select a school group</option>
                    <c:forEach var="year" items="${requestScope.schoolGroups}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="section"><span>2</span>Intern Assign Info</div>
        <div class="inner-wrap">
            <div>
                <label><span>Company</span></label>
                <select name="company" class="select-field">
                    <option disabled>Select a company</option>
                    
                    <c:forEach var="company" items="${requestScope.companies}">
                        <option value="${company.companyName}">${company.companyName}</option>
                    </c:forEach>
                    <option value="new">Autre</option>
                </select>
            </div>
            <div id="newCompany">
                <div>Nouvelle entreprise</div>
                <div>
                    <label>Nom de l'entreprise</label>
                    <input type="text" name="new_name"/>
                </div>
                <div>
                    <label>Adresse de l'entreprise</label>
                    <input type="text" name="new_address"/>
                </div>
            </div>
            <div>
                <label><span>Maitre de stage</span></label>
                <input type="text" name="master"/>
            </div>
            <div>
                <label for="dateofbirth">Start Date</label>
                <input type="date" name="startDate" id="dateofbirth">
            </div>
            <div>
                <label for="dateofbirth">End Date</label>
                <input type="date" name="endDate" id="dateofbirth">
            </div>
        </div>

        
        <div class="button-section">
            <span><input type="submit" name="Add Student" /></span>
        </div>
    </form>
</div>

        
    </body>
</html>

<script>
    var newComp = document.getElementById('newCompany');
    var selectCompany = document.getElementsByName("company");
    
    if(selectCompany[0].value != "new"){
        newComp.style.display = "none";
    }
    
    selectCompany[0].addEventListener('change',function(){
        if(this.value == "new"){
            newComp.style.display = "block";
        }
        else{
            newComp.style.display = "none";
        }
    })
</script>