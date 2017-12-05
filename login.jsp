<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
</head>
<body>
<%! static int x; %>
<%! int counter; // Instance Variable %>
Current Date is <%=new Date() %>

<%
counter++;
request.getSession(true);
String userid=request.getParameter("userid");
String pwd=request.getParameter("pwd");
if(userid!=null&&pwd!=null)
{
	
if(userid.equals(pwd)&&(userid!=""&&pwd!=""))
{
session.setAttribute("userid", userid);

	response.sendRedirect("welcome.jsp");
}

else{
	

%>
<h2>invalid userid or pswrd</h2>
<%}} %>
<jsp:include page="header.jsp"></jsp:include>
<form action="login.jsp" method="post">
<table>
		<tr>
			<td><label for="">Userid</label></td>
			<td><input name="userid" type="text"></td>
		</tr>
		<tr>
			<td><label for="">Password</label></td>
			<td><input name="pwd" type="password"></td>
		</tr>
		<tr>
			<td><button>Login</button></td>
			<td><button>Reset</button></td>
		</tr>
	</table>
</form>	
number of times pages visited<%=counter %>
</body>
</html>