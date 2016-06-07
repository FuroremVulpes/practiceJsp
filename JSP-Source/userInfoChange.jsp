<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<style type="text/css">

table,td,th{
	border-style: solid;
	border-width:1px ;
}

input[type=text]{
	width:250px;
}
input[type=email]{
	width:250px;
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報修正</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div align="center">

	<h2>ユーザー情報修正</h2>

	<form action="/employeeManagement/UserInfoChange" method="post">
	<table>
		<tr><th style="text-align:left">職番</th><td>${ loginUser.id }</td></tr>
		<tr>
			<th style="text-align:left">名前</th>
			<td><input type="text" name="name" value="${loginUser.name}"></td>
		</tr>
		<tr>
			<th style="text-align:left">振り仮名</th>
			<td><input type="text" name="hurigana" value="${loginUser.hurigana}"></td>
		</tr>
		<tr>
			<th style="text-align:left;width:150px">E-mail</th>
			<td style="width:250px"><input type="email" name="email" value="${loginUser.email}"></td>
		</tr>
		<tr>
			<th style="text-align:left">連絡先</th>
			<td><input type="text" name="phoneNumber" value="${loginUser.phoneNumber}"></td>
		</tr>
		<tr>
			<th style="text-align:left">住所</th>
			<td><input type="text" name="address" value="${loginUser.address}"></td>
		</tr>

		<tr>
			<th style="text-align:left">業務開始時間</th>
			<td><input type="text" name="startTime" value="${loginUser.startTime}"></td>
		</tr>
		<tr>
			<th style="text-align:left">業務終了時間</th>
			<td><input type="text" name="finishTime" value="${loginUser.finishTime}"></td>
		</tr>
		<tr>
			<th style="text-align:left">昼休憩時間</th>
			<td><input type="text" name="breakTime" value="${loginUser.breakTime}"></td>
		</tr>
	</table>
		<br>
		<input type="submit" value="送信" />&nbsp;&nbsp;&nbsp;
		<input type="button" value="取消" onClick="location.href='/employeeManagement/UserInfo'">
	</form>
	</div>
</body>
</html>