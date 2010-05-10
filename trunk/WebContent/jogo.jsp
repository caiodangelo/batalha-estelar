<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.HtmlTools,logica.Game"
    %>
<%
Game game = (Game) application.getAttribute("game");
String nome = (String) session.getAttribute("login");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
if(!game.isPlayersTurn(nome))
{
%>
<meta http-equiv="Refresh" CONTENT="10;" />  
<%
}
%>
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
<div class="info">
<%
out.println("<b>"+HtmlTools.getErrors((String)request.getAttribute("error"))+"</b>");
HtmlTools.getMessage((String) request.getAttribute("msg"));
%>
</div>
<div class="tabuleiros">
<% 
HtmlTools.generateHtmlTable(game.getPlayerBoard(nome),game.getBoardSize());
HtmlTools.generateHtmlTable(game.getOpponentBoard(nome),game.getBoardSize());
%>
</div>
<div class="options">
<%
if(game.isPlayersTurn(nome)){
%>
<form action="RealizaAtaque" method="post">
Posição x:<input type="text" name="posx" /><br />
Posição y:<input type="text" name="posy" /><br />
<input type="submit" value="Envia" />
</form>
<%	
}
%>
</div>
<div class="options">
<% 
%>
</div>
</body>
</html>