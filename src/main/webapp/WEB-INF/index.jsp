<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style_index.css" rel="stylesheet">
    </head>


    <body>
        <div class="container">
            <div id="FramePanel"> 
                <div id="FrameBorder">
                    <div id="AuthentificationBar">
                        <img src='images/efrei.png' id="EFREILOGO"> 
                        <div id="AuthentificationText">Authentification</div>
                    </div>


                    <form name="FormIndex" action="LoginController" method="POST" id="FORM">
                        <div class="inputLabalContainer">
                            <div class="inputLabal">
                                <label>Username :</label>
                                <input type="text" name="UsernameForm"/>
                            </div>
                            <div class="inputLabal">
                                <label>Password :</label>
                                <input type="password" name="PassForm"/>
                            </div>
                        </div>
                        
                        <div class="buttonContainer">
                            <c:choose>
                                <c:when test="${not empty requestScope.KeyErrMess}">
                                    <div id="errorMsgContainer">
                                        <div id="errorMsg">
                                            <c:out value= "${requestScope.KeyErrMess}"/>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div></div>
                                </c:otherwise>
                            </c:choose>
                        
                            <input id="SendButton" type="submit" name="SendButton" value="LOGIN" /> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
