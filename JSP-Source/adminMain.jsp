<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Calendar cal = Calendar.getInstance();
	request.setAttribute("view", "currenMonth");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員管理システム</title>
</head>
<body>
	<h2>社員管理システム管理者</h2>

	ユーザー名: ${loginUser.name}<jsp:include page="header.jsp" />

	<p>
	<a href="/employeeManagement/UserInfo">ユーザー情報</a><br>
	<a href="/employeeManagement/PasswordChange">パスワードの変更</a><br>

	<a href="/employeeManagement/AttendanceServlet?command=attendanceSheet_list">勤務表の確認･入力</a><br>
	</p>

</body>
</html>