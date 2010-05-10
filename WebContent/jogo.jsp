<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.HtmlTools,logica.Game"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.hit{
background-color:red;
}
.ship{
background-color:red;
}
.free{
background-color:blue;
}
</style>
</head>
<body>
<%
Game game = (Game) application.getAttribute("game");
String nome = (String) session.getAttribute("login");
%>
<div class="info"><% %></div>
<div class="tabuleiros">
<% 
HtmlTools.generateHtmlTable(game.getPlayerBoard(nome),game.getBoardSize());
HtmlTools.generateHtmlTable(game.getOpponentBoard(nome),game.getBoardSize());
%>
</div>
<div class="options"><% %></div>
</body>
</html>