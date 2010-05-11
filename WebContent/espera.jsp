<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.Game"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Refresh" CONTENT="2;url=espera.jsp">  
<link rel="stylesheet" href="default.css" />
<title>Aguarde o seu adversário...</title>
</head>
<body>
<div class="aguarde">
<p>Aguarde enquanto o seu adversário termina de preencher o tabuleiro dele...</p>
<%
Game game = (Game) application.getAttribute("game");
if(game.startGame())
{
	request.getRequestDispatcher("jogo.jsp").forward(request, response);
}
%>
</div>
</body>
</html>