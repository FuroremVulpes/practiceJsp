<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  //RequestDispatcher d = request.getRequestDispatcher("/Login");
		//d.forward(request, response);
		response.sendRedirect("/employeeManagement/Login");
	%>
</body>
</html>