<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style_index.css" rel="stylesheet">
    </head>
    
    
    <body>
        <div id="FramePanel"> 
            <div id="FrameBorder">
                <div id="AuthentificationBar">
                    <img src='images/efrei.png' id="EFREILOGO"> 
                    <p id="AuthentificationText">Authentification</p>
                </div>
                
                    
                    <form name="FormIndex" action="LoginController" method="POST" id="FORM">
                        <p id="username">Username :</p>
                        <input id="TextBoxUsername" type="text" name="UsernameForm"/>
                        <p id="password">Password :</p>
                        <input id="TextBoxPassword" type="text" name="PassForm"/>
                        <input id="SendButton" type="submit" name="SendButton" value="LOGIN" /> 
                    </form>
                    
                    <%
                    if(request.getAttribute("KeyErrMess")!=null){
                        out.println("<div id=\"errorMsgContainer\">"
                        +    "<div id=\"errorMsg\">"
                        +       request.getAttribute("KeyErrMess")
                        +    "</div>"
                        +"</div>");
                    }
                    %>
                
            </div>
        </div>
    </body>
</html>
