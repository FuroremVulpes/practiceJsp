<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Integer msg = (Integer) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<style>
input,td{

  /*
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  */
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員管理システムログイン</title>
</head>
<body>


	<form action="Login" method="post" name="loginForm">
	<div align="center">
		<table>
			<tr>
				<td style="text-align:left">Username</td>
			</tr>

			<tr>
				<td><input type="text" name="id" style="width:100%"></input></td>
			</tr>

			<tr>
				<td style="text-align:left">Password</td>
			</tr>

			<tr>
				<td><input  type="password" name="pass" style="width:100%"></input></td>
			</tr>

			<tr>
				<td><input type="submit" value="ログイン" style="width:100%"></input></td>
			</tr>
		</table>
	</div>
	</form>

<% if(msg != null){ %>
	<script type="text/javascript">
		alert("IDまたはパスワードが間違っています。")
	</script>
<% } %>


</body>
</html>