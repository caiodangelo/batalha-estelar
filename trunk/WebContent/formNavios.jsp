<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="logica.HtmlTools"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="default.css" />
<title>Batalha Espacial - Caio e Vitor</title>
</head>
<body>
<%
	out.println("<b>"+HtmlTools.getErrors((String)request.getAttribute("error"))+"</b>");
%>
<div class="formTable">
<%
	out.println(HtmlTools.generateHtmlTable(15,15,true));
%>
</div>
<form class="shipForm" action="RecebeNavios" method="post">
<%
	out.println(HtmlTools.generateHtmlShipsForm(5,3,3));
%>
<div class="clear"></div>
<br />
<input type="submit" value="Envia" />
</form>
</body>
</html>