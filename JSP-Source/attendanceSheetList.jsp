<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//String top = (String) request.getAttribute("top");
	//String left = (String) request.getAttribute("left");
	String[] weekJa = { "日", "月", "火", "水","木", "金", "土"  };
	                    //0,    1,    2,    3,    4,    5,    6
	request.setAttribute("weekJa", weekJa);

%>
<c:set var="w" value="${dayOfWeek}" />
<c:if test="${listAttendance != null }">
	<c:set var="index" value="0" />
	<c:set var="workDay" value="${listAttendance[0].workedDay.substring(8,10)}" />

	<c:if test="${workDay.substring(0, 1) == '0' }">
		<c:set var="workDay" value="${Integer.parseInt(workDay.substring(1, 2))}" />
	</c:if>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>勤務表の確認</title>

<style type="text/css">
input[type=text]{
	text-align:center;
}
th,td{
text-align:center;
height:30px;
}

</style>

<script type="text/javascript">
function savePosToNextPage() {
    document.form2.left.value = document.documentElement.scrollLeft || document.body.scrollLeft;
    document.form2.top.value = document.documentElement.scrollTop || document.body.scrollTop;
}
</script>

</head>
<body>

<script type="text/javascript">
		window.onload = function(){
			window.scroll("${left}", "${top}");
		}
</script>

<jsp:include page="/WEB-INF/jsp/header.jsp" />

<h2 align="center">勤務表の確認</h2>

	<div align="center">

		<form action="/employeeManagement/AttendanceServlet?command=attendanceSheet_list" method="post" name="form1">

			<select name="year">
				<c:forEach var="i" begin="${currentYear-2}" end="${currentYear+2}" step="1">
					<c:choose>
						<c:when test="${year == i}">
							<option value="${i}" selected> ${i} </option>
						</c:when>
						<c:otherwise>
							<option value="${i}"> ${i} </option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>年

			<select name="month">
				<c:forEach var="i" begin="1" end="12" step="1">
					<c:choose>
						<c:when test="${month == i}">
							<option value="${i}" selected> ${i} </option>
						</c:when>
						<c:otherwise>
							<option value="${i}"> ${i} </option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>月
			<input type="submit" value="表示"></input>
			<input type="hidden" name="view" value="otherMonth" ></input>
		</form>
		<br>

	<form action="/employeeManagement/AttendanceServlet?command=attendanceSheet_form" method="post" name="form2">

		<input type="hidden" name="year" value="${year}" ></input>
		<input type="hidden" name="month" value="${month}" ></input>
		<input type="hidden" name="action" value="update" ></input>
		<input type="hidden" name="top" value=""></input>
		<input type="hidden" name="left" value=""></input>
		<input type="hidden" name="lastDay" value="${lastDay}" ></input>
		<input type="hidden" name="dayOfWeek" value="${dayOfWeek}" ></input>
		<input type="hidden" name="currentYear" value="${currentYear}" ></input>


	<table border=1 style="width:50%">
		<tr>
			<th width="70">日付</th>
			<th>開始</th>
			<th>終了</th>
			<th>休憩</th>
			<th width="100">勤務形態</th>
			<th width="60">修正</th>
		</tr>

			<c:forEach var="i" begin="1" end="${lastDay}" step="1">
				<tr>
				<c:choose>
					<c:when test="${w==6}">
						<td style="color:blue"> ${i}(${weekJa[w]}) </td> <!-- 土曜日 -->
					</c:when>
					<c:when test="${w==0}">
						<td style="color:red"> ${i}(${weekJa[w]}) </td> <!-- 日曜日 -->
					</c:when>
					<c:otherwise>
						<td> ${i}(${weekJa[w]}) </td>
					</c:otherwise>
				</c:choose>

				<!-- dbからのデータ展開 -->
				<c:choose>
					<c:when test="${i==workDay}">

						<td style="text-align:center">
							<output name="startTime" >
								<c:if test="${listAttendance[index].startTime != null }"> ${listAttendance[index].startTime} </c:if>
							</output>
						</td>
						<td style="text-align:center">
							<output name="finishTime" >
								<c:if test="${listAttendance[index].finishTime != null }"> ${listAttendance[index].finishTime} </c:if>
							</output>
						</td>
						<td style="text-align:center">
							<output name="breakTime" >
								<c:if test="${listAttendance[index].breakTime != null }"> ${listAttendance[index].breakTime} </c:if>
							</output>
						</td>
						<td style="text-align:center"><output name="type"> ${listAttendance[index].workTypeString} </output></td>
						<td style="text-align:center">
							<input type="radio" name="day" value="${i}" onclick="savePosToNextPage();form2.submit()"></input>
						</td>

						<!--listAttendance参照のためのindexなど変数加算 -->
						<c:set var="index" value="${index+1}"/>
						<c:set var="workDay" value="${listAttendance[index].workedDay.substring(8,10)}" />
						<c:if test="${workDay.substring(0, 1) == '0' }">
							<c:set var="workDay" value="${Integer.parseInt(workDay.substring(1, 2))}" />
						</c:if>

					</c:when>

					<c:otherwise>

						<td><output></output></td>
						<td><output></output></td>
						<td><output></output></td>
						<td><output></output></td>
						<td style="text-align:center">
							<input type="radio" name="day" value="${i}" onclick="savePosToNextPage();form2.submit()"></input>
						</td>

					</c:otherwise>
				</c:choose>
				</tr>

				<!-- 曜日表示のための変数加算(dayOfWeek) -->
				<c:set var="w" value="${w+1}" />
				<c:if test="${w==7}"> <c:set var="w" value="0" /> </c:if>
			</c:forEach>
	</table>

	</form>
</div>
</body>
</html>