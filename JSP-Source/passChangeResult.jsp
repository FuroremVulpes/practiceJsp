<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワードの変更</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div align="center">
	<h2>パスワードの変更</h2>

<c:choose>
	<c:when test="${isResult == true}">
		パスワードが正常に変更されました。
	</c:when>
	<c:otherwise>
		パスワードが正常に変更されていません。再度変更してください。
		<a href="/employeeManagement/PasswordChange">パスワード変更へ戻る</a>
	</c:otherwise>
</c:choose>

</div>
</body>
</html>