<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table,td,th{
	border-style: solid;
	border-width:1px ;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div align="center">
	<h2>ユーザー情報確認</h2>
	<table border=1 style="border-style:solid">

		<tr><th style="text-align:left">職番</th><td>${ loginUser.id }</td></tr>

		<tr><th style="text-align:left">名前</th><td>${ loginUser.name }</td></tr>

		<tr><th style="text-align:left">振り仮名</th><td>${ loginUser.hurigana }</td></tr>

		<tr><th style="text-align:left;width:150px">E-mail</th><td style="width:250px">${ loginUser.email }</td></tr>

		<tr><th style="text-align:left">連絡先</th><td>${ loginUser.phoneNumber }</td></tr>

		<tr><th style="text-align:left">住所</th><td>${ loginUser.address }</td></tr>

		<tr><th style="text-align:left">業務開始時間</th><td>${ loginUser.startTime }</td></tr>

		<tr><th style="text-align:left">業務終了時間</th><td>${ loginUser.finishTime }</td></tr>

		<tr><th style="text-align:left">昼休憩時間</th><td>${ loginUser.breakTime }</td></tr>

	</table>
	<form action="/employeeManagement/UserInfoChange" method="get"><br>
		<input type="submit" value="修正">
	</form>
</div>
</body>
</html>