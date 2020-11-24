<%-- 
    Document   : NewStudent
    Created on : Nov 24, 2020, 3:35:04 PM
    Author     : seedy
--%>

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
            <label>First Name <input type="text" name="firstname" /></label>
            <label>Last Name <input type="text" name="lastname" /></label>
            <label ><span>Group Name</span><select name="schoolGroup" class="select-field">
                    <!--get all from db-->
                <option disabled>Select a school group</option>
                <option value="l3">L3</option>
                <option value="m1">M1</option>
                <option value="m2">M2</option>
</select></label>
        </div>

        <div class="section"><span>2</span>Intern Assign Info</div>
        <div class="inner-wrap">
            
            <label ><span>Subject</span><select name="company" class="select-field">
                    <!--get all from db-->
                <option disabled>Select a company</option>
                <option value="amz">Amazon</option>
                <option value="goog">Google</option>
                <option value="gb">Facebook</option>
</select></label>
            
            <label><span>Subject</span><select name="schoolGroup" class="select-field">
                    <!--get all from db-->
                <option disabled>Select a company</option>
                <option value="Appointment">L3</option>
                <option value="Interview">M1</option>
                <option value="Interview">M2</option>
</select></label>
            
            <label for="dateofbirth">Start Date
            <input type="date" name="startDate" id="dateofbirth">
            </label>
            
            <label for="dateofbirth">End Date
                <input type="date" name="endDate" id="dateofbirth">
            </label>
        </div>

 <!--<label>First Name <input type="text" name="firstname" /></label>-->

        
        <div class="button-section">
            <span>
         <input type="submit" name="Add Student" />
         </span>
        </div>
    </form>
</div>

        
    </body>
</html>
