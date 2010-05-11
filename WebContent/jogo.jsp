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
<link rel="stylesheet" href="default.css" />
<%
if(!game.isPlayersTurn(nome))
{
%>
<meta http-equiv="Refresh" CONTENT="10;" />  
<%
}
%>
<title>Jogo em andamento - Batalha Espacial - Caio e Vitor</title>

</head>
<body>
<div id="seutabuleiro">
	<% 
	out.println(HtmlTools.generateHtmlTable(game.getPlayerBoard(nome),game.getBoardSize()));
	%>
</div>
<div id="tabuleiroinimigo">
	<%
	out.println(HtmlTools.generateHtmlTable(game.getOpponentBoard(nome),game.getBoardSize()));
	%>
</div>
<div class="clear"></div>
<div class="info">
	<p id="msgErro">
	<%
	out.println(HtmlTools.getErrors((String)request.getAttribute("error")));
	%>
	</p>
	<p id="roundResult">
	<%
	out.println(HtmlTools.getMessage((String) request.getAttribute("msg")));
	%>
	</p>
</div>
<div id="actions">
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
<div id="endgame">
	<form action="FinalizaJogo" method="post">
	<input type="submit" value="Encerrar partida" />
</form>
<% 
%>
</div>
</body>
</html>