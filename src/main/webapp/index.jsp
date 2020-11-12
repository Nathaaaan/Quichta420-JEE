<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet">
    </head>
    
    
    <body>
        <div id="FramePanel"> 
            <div id="FrameBorder">
                    <p id="LoginMenuText">Login Menu</p>
                    
                    <form name="FormIndex" action="LoginController" method="POST">
                        <input id="TextBoxUsername" type="text" name="UsernameForm"/><br/>
                        <input id="TextBoxPassword" type="text" name="PassForm"/><br/>
                        <input id="SendButton" type="submit" name="SendButton" value="Login" /> 
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
