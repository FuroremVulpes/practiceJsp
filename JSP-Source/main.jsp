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
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div align="center">

	<h2>勤怠管理システム</h2>
	<p>
	<a href="/employeeManagement/UserInfo">ユーザー情報</a><br>
	<a href="/employeeManagement/PasswordChange">パスワードの変更</a><br>

	<a href="/employeeManagement/AttendanceServlet?command=attendanceSheet_list">勤務表の確認･入力</a><br>
	</p>
</div>
</body>
</html>