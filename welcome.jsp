<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<%
session=request.getSession(false);
if(session.getAttribute("userid")==null){
	response.sendRedirect("login.jsp");
}
else{
String userid=(String)session.getAttribute("userid");


%>
<h>Welcome...... <%=userid %></h>
<form action="logout.jsp" method="post">
<button name="logout">
logout</button>
</form>
</body>
<%	response.setHeader("Cache-control", "no-cache, no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "-1"); %>
<%} %>
</html>