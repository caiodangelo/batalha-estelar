<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.Game"
    %>
    <%
    Game game = (Game) application.getAttribute("game");
    if(game!=null){
    	if(game.getGameState()==GameState.Ended){
        	application.setAttribute("game",null);
        }
    }    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="logica.GameState"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css" />
<title>Batalha Espacial - Caio e Vitor</title>
</head>
<body>
<h1>Bem vindo ao jogo de batalha espacial</h1>
<div id="loginFieldSet">
<fieldset><legend>Escolha seu nick</legend>
<form action="Login" method="post">
<input type="text" name="nick" /><br />
<input type="submit" value="Entrar" />
</form>
</fieldset>
</div>
</body>
</html>