<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <script type="text/javascript" src="_Javascript/contact-us-js.js"></script>     
        <link rel = "stylesheet" href="_css/style-pages.css"/>
        <link rel = "stylesheet" href="_css/style-pattern-pages.css"/>
    </head>
    <body class="block-principal">
        <div id="conteiner-header">
            <div id="logo">
                <img src="_imagens/logo.png">
            </div>
            <div id="name-site">
                <h1>VamoL�Ver</h1>
            </div>
            <div id="redes-sociais">
                <img src="_imagens/redes-sociais.png">
            </div>
            <nav>
                <ul>
                    <li class="only">
                        <a href="home-page.html">Home</a>
                    </li>
                    <li class="only">
                        <a href="contact-us.html">Quem Somos?</a>
                    </li>
                    <li class="only">
                        <a href="pontos-turisticos.html">Pontos Turisticos</a>
                    </li>
                    <li class="only">
                        <a href="custon-search-page.html">Busca Personalizada</a>
                    </li>
                    <li class="only">
                        <a href="#">Meus Eventos</a>
                        <ul>
                            <table id="drop-down">
                                <tr>
                                    <td>
                                        <img alt="novo" height="20px" width="20px" src="_imagens/add-png-black.png">
                                    </td>
                                    <td>
                                        <a href="new-event.html">Cadastrar Futuro evento</a>
                                    </td>
                                </tr>
                                    <tr>
                                        <td>
                                            <img alt="favorito" height="20px" width="20px" src="_imagens/star-favorite-black-png.png">
                                        </td>
                                        <td>
                                            <a href="favorite-events.html">Meus Eventos Favoritos</a>
                                        </td>
                                    </tr>
                                <tr>
                                    <td>
                                        <img alt="lista" height="20px" width="20px" src="_imagens/list-icon-png-black.png">
                                    </td>
                                    <td>
                                        <a href="edit-my-events.html">Modificar evento j� cadastrado</a>
                                    </td>
                                </tr>
                            </table> 
                        </ul>
                    </li>
                    <li>
                        <div class="search-box">
                            <input type="text" id="txt-search-box" placeholder="...Buscar..." size="20px;"/>
                            <div id="pesquisar">
                                <a href="search-result.html">
                                    <img id="img-a" src="_imagens/pesquisar.png">
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class="only">
                        <a id="a-model-login" onclick="gomodellogin()">
                            LOGIN
                        </a>
                    </li>
                    <li class="only">
                        <a href="sing-in.html">
                            SING IN
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="container-content">
            <div class="div-c">
                <%
                List<String> erros = (ArrayList<String>) request.getAttribute("erros");	

                for(String s: erros){
                    out.println("<h1>"+s+"</h1>");
                }
                %>
            </div>
        </div>
        <footer id="rodape">
            <p>Copyright &copy; 2017 -Andr�,Lucas,Nereida,Rafael</p>
        </footer>
        <div id="modal-login" class="modal">
            <div class="modal-content-login">
                <div class="modal-header">
                    <span class="closel">&times;</span>
                    <h3>Login</h3>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form name="login">
                            <label for="login-username-email">Email/Usu�rio</label>
                            <input type="text" class="txts" id="login-username-email" size="30">
                            <label for="login-user-password">Senha</label>
                            <input type="password" class="txts" id="login-user-password" size="30">
                            <input type="submit" class="submit-b" id="btn-login-entrar" value="Entrar">
                            <a href="remember-password.html">esqueceu a senha?</a>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </body>
</html>