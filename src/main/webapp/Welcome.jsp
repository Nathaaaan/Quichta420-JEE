<%-- 
    Document   : Welcome
    Created on : 4 nov. 2020, 15:02:55
    Author     : natha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="style_welcome.css" rel="stylesheet">

        
    </head>
    <body>
        <header>
            <div class="logo">
                <h2>LOGO HERE</h2>
            </div>
            
            <nav>
                <ul>
                    <li> <a href="#">Add Student</a> </li>
                    <li> <a href="#">M. Nom</a> </li>
                    <li> <a href="#">Logout</a></li>
                </ul>
            </nav>
        </header>
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
                    
                    <tr>
                        <td>1</td>
                        <td>M2</td>
                        <td>Nom</td>
                        <td>Prenom</td  >
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox" checked="true"/></td>
                        <td><input type="checkbox" checked/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td>ENTR</td>
                        <td>MdS</td>
                        <td>Adresse</td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                    </tr>
                    
                    <tr>
                        <td>2</td>
                        <td>M2</td>
                        <td>Nom</td>
                        <td>Prenom</td  >
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox" checked="true"/></td>
                        <td><input type="checkbox" checked/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td>ENTR</td>
                        <td>MdS</td>
                        <td>Adresse</td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                    </tr>
                    
                    <tr>
                        <td>3</td>
                        <td>M1</td>
                        <td>Nom</td>
                        <td>Prenom</td  >
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox" checked="true"/></td>
                        <td><input type="checkbox" checked/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                        <td>ENTR</td>
                        <td>MdS</td>
                        <td>Adresse</td>
                        <td><input type="checkbox"/></td>
                        <td><input type="checkbox"/></td>
                    </tr>
                    
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
