<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%
for(int i=0; i<15; i++){
	System.out.println("<tr>");
	for(int j =0; j<15; j++){
		out.println("<td>x</td>");
	}
	out.println("</tr>");
}
%>
</table>
</body>
</html>