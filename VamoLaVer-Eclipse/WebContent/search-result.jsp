<%@page import="java.util.ArrayList"%>
<%@page import="bdConnect_e_DAOs.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<title>Sua pesquisa</title>
<script type="text/javascript" src="_Javascript/contact-us-js.js"></script>
<link rel="stylesheet" href="_css/style-pages.css" />
<link rel="stylesheet" href="_css/style-pattern-pages.css" />
</head>
<body class="block-principal">
	
	<div id="conteiner-header">
		<div id="logo">
			<img src="_imagens/logo.png">
		</div>
		<div id="name-site">
			<h1>VamoLáVer</h1>
		</div>
		<div id="redes-sociais">
			<img src="_imagens/redes-sociais.png">
		</div>
		<nav>
		<ul>
			<li class="only"><a href="home-page.html">Home</a></li>
			<li class="only"><a href="contact-us.html">Quem Somos?</a></li>
			<li class="only"><a href="pontos-turisticos.html">Pontos
					Turisticos</a></li>
			<li class="only"><a href="custon-search-page.html">Busca
					Personalizada</a></li>
			<li class="only"><a href="#">Meus Eventos</a>
				<ul>
					<table id="drop-down">
						<tr>
							<td><img alt="novo" height="20px" width="20px"
								src="_imagens/add-png-black.png"></td>
							<td><a href="new-event.html">Adicionar um Novo evento</a></td>
						</tr>
						<tr>
							<td><img alt="lista" height="20px" width="20px"
								src="_imagens/list-icon-png-black.png"></td>
							<td><a href="my-events-list.html"
								title="Lista com seus eventos e favoritos">Listar meus
									Eventos</a></td>
						</tr>
					</table>
				</ul></li>
			<li>
				<div class="search-box">
					<form name="form-search-simple" method="get" action="search-result.jsp">
                                <input type="text" id="txt-search-box" name="campo-search" placeholder="...Buscar..." size="20px;"/>
                                <div id="pesquisar">
                                    <button type="submit" class="submit-c" >
                                        <img id="img-a" src="_imagens/pesquisar.png">
                                    </button>
                                </div>
                            </form>
				</div>
			</li>
			<li class="only"><a id="a-model-login" onclick="gomodellogin()">
					LOGIN </a></li>
			<li class="only"><a href="sing-in.html"> SING IN </a></li>
		</ul>
		</nav>
	</div>
	<div class="side-nav-op">
		<a href="#" id="btn-sidenav-options" onfocus="gomodeloptions()">Opções
			de organização</a>
	</div>
	<div class="container-content">
		<article class="presentation">
		<h1>Resultados da pesquisa</h1>
		<%@page import='java.sql.*'%> <%
 		ResultSet rs;
 	Statement st;
 	Connection con;
 	String pesquisa = request.getParameter("campo-search");

 	try {

 		Class.forName("com.mysql.jdbc.Driver");
 		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto1bim2017", "root", "t00r");
 		st = con.createStatement();
 		rs = st.executeQuery("select * from evento");
 		while (rs.next()) {
 			String nomeEvento = rs.getString("evNome");

 			if (nomeEvento.contains(pesquisa)) {
 				
 				String idEvento = rs.getString("evId");
 				String emailElab = rs.getString("evElaboradorEmail");
 				out.println("<div>");
 				out.println("Id: " + idEvento + "<br>");
 				out.println("Nome: " + nomeEvento + "<br>");
 				out.println("Email do Elaborador: " + emailElab);
 				out.println("<br><br>");
 				out.println("</div>");
 			}

 		}

 	} catch (ClassNotFoundException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
 %>
		<div id="container-link-event">
			<div id="link-edit-this-event"></div>
			<div id="link-favorite-or-not"></div>
			<div id="link-name-of-this-event">
				
			</div>
			<div id="delete-this-event"></div>
		</div>
		</article>
	</div>
	<footer id="rodape">
	<p>Copyright &copy; 2017 -André,Lucas,Nereida,Rafael</p>
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
						<label for="login-username-email">Email/UsuÃ¡rio</label> <input
							type="email" required class="txts" id="login-username-email"
							size="30"> <label for="login-user-password">Senha</label>
						<input type="password" required class="txts"
							id="login-user-password" size="30"> <input type="submit"
							class="submit-b" id="btn-login-entrar" value="Entrar"> <a
							href="remember-password.html">esqueceu a senha?</a>
					</form>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
	<div id="modal-options" class="modal">
		<div class="modal-content-login">
			<div class="modal-header">
				<span class="closeop">&times;</span>
				<h3>Opções de exibição</h3>
			</div>
			<div class="modal-body">
				<div class="div-c">
					<form id="form-options-search-result" class="form-options">
						<table>
							<tr>
								<td class="titles" colspan="2">Ordem Alfabética do Eventos
								</td>
							</tr>
							<tr>
								<td><label for="radio-oa-az">A-Z</label> <input
									type="radio" id="radio-oa-az" /></td>
								<td><label for="radio-oa-za">Z-A</label> <input
									type="radio" id="radio-oa-za" /></td>
							</tr>
							<tr>
								<td class="titles" colspan="2">Data Prevista Para Eventos</td>
							</tr>
							<tr>
								<td><label for="radio-dtpev-cres">Crescente</label> <input
									type="radio" id="radio-dtpev-cre" /></td>
								<td><label for="radio-dtpev-dec">Decrescente</label> <input
									type="radio" id="radio-dtpev-dec" /></td>
							</tr>
							<tr>
								<td class="titles" colspan="2">Qtd. prevista de visitantes
								</td>
							</tr>
							<tr>
								<td><label for="radio-qtd-cre">Crescente</label> <input
									type="radio" id="radio-qtd-cre" /></td>
								<td><label for="radio-qtd-dec">Decrescente</label> <input
									type="radio" id="radio-qtd-dec" /></td>
							</tr>
							<tr>
								<td class="titles" colspan="2">Mais opções</td>
							</tr>
							<tr>
								<td><label for="check-only-my">Somente meus Eventos</label>
								</td>
								<td><input type="checkbox" id="check-only-my"
									title="NÃ£o mostrarÃ¡ os eventos favoritos" /></td>
							</tr>
						</table>
						<input type="submit" class="submit-b" id="btn-op-ok" value="OK">
						<input type="reset" class="reset-b" id="btn-op-eraser"
							value="limpar">
					</form>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</body>
</html>