<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Key word</title>
        <link rel="stylesheet" href="style_keyword.css"/>
    </head>
    <body>
        <%@include file="Header.jspf"%>
        <div class="containerTitre">
            <h1>Mot clés</h1>
        </div>
        <div class="containerPage">
            <div class="page">
                <div class="containerKeyWords">
                    <div>
                        <h2>Mots clés du stage de ${requestScope.assign.intern.firstName} ${requestScope.assign.intern.lastName}</h2>
                        <ul>
                        <c:forEach var="keyWord" items="${requestScope.myKey}">
                            <li>
                                <div class="line">
                                    <div>${keyWord}</div>
                                    <a href="ManageKeyWords?key_word=${keyWord}&internship_id=${requestScope.assign.excel.internshipId}&action=1">
                                        <img src="images/iconeCroix.png"/>
                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                        </ul>
                    </div>
                    <div>
                        <h2>Autres mots clés</h2>
                        <ul>
                        <c:forEach var="keyWord" items="${requestScope.otherKey}">
                            <li>
                                <div class="line">
                                    <div>${keyWord}</div>
                                    <a href="ManageKeyWords?key_word=${keyWord}&internship_id=${requestScope.assign.excel.internshipId}&action=2">
                                        <img src="images/iconeAdd.png"/>
                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                            <li>
                                <form method="POST" action="ManageKeyWords">
                                    <input type="text" name="newKeyWord"/>
                                    <input type="hidden" name="internshipId" value="${requestScope.assign.excel.internshipId}"/>
                                    <input type="submit" value="+"/>
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="containerBtn">
                    <a href="WelcomeController">Valider</a>
                </div>
            </div>
        </div>
    </body>
</html>
