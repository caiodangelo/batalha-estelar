<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.HtmlTools,logica.Game"
    %>
<%
Game game = (Game) application.getAttribute("game");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css" />
<title>Fim de Jogo</title>
</head>
<body>
<h1>Fim de Jogo !</h1>
<p> O jogador <%=game.getWinner() %> foi vitorioso.</p>
<a href="index.jsp">Voltar para o início</a>
</body>
</html>