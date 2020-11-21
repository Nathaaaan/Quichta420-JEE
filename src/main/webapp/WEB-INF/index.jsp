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
                                <input type="text" name="PassForm"/>
                            </div>
                        </div>
                        <div class="buttonContainer">
                            <%
                            if(request.getAttribute("KeyErrMess")!=null){
                                out.println("<div id=\"errorMsgContainer\">"
                                +       "<div id=\"errorMsg\">"
                                +       request.getAttribute("KeyErrMess")
                                +       "</div>"
                                +   "</div>");
                            }
                            else{
                                out.println("<div></div>");
                            }
                            %>
                            <input id="SendButton" type="submit" name="SendButton" value="LOGIN" /> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
