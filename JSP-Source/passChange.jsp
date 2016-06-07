<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="myjs.js"> </script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>パスワードの変更</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div align="center">
	<h2>パスワードの変更</h2>
	<form action="PasswordChange" method="post" name="form1">
		<table>
			<tr>
				<th style="text-align:left">現在のパスワード：</th>
				<td><input type="password" name="pass"></input></td>
			</tr>
			<tr>
				<th style="text-align:left">新しいパスワード：</th>
				<td><input type="password" name="newPass1"></input></td>
			</tr>
			<tr>
				<th style="text-align:left">パスワード再度入力：</th>
				<td><input type="password" name="newPass2"></input></td>
			</tr>
		</table>
			<br>
			<input type="button" value="送信" name="sub" onclick="PassCheck('${loginUser.pass}');"></input>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset" name="reset"></input>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消" name="cancel" onclick="location.href='/employeeManagement/Main'">
	</form>
</div>
</body>
</html>