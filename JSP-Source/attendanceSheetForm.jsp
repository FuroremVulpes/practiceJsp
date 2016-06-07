<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String[] weekJa = { "日", "月", "火", "水","木", "金", "土"  };
	                    //0,    1,    2,    3,    4,    5,    6
	request.setAttribute("weekJa", weekJa);
%>

<!DOCTYPE html">
<html>
<head>

<script type="text/javascript" src="myjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>勤務表の入力</title>

<style type="text/css">

select.type{
	width:50px;
	height:20px;
	text-align:center;
}

input[type=text]{
	width:65px;
	height:30px;
	text-align:center;
}

th,td{
	text-align:center;
	height:30px;
}


</style>

</head>
<body>

	<script type="text/javascript">
		window.onload = function(){
			window.scroll("${left}", "${top}");
		}
	</script>

<jsp:include page="/WEB-INF/jsp/header.jsp" />

<h2 align="center">勤務表の入力</h2>

<div align="center">

		<form action="/employeeManagement/AttendanceServlet?command=attendanceSheet_list" method="post" name="form2">

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


	<form action="/employeeManagement/AttendanceServlet" method="post" name="form1">

		<input type="hidden" name="year" value="${year}" ></input>
		<input type="hidden" name="month" value="${month}" ></input>
		<input type="hidden" name="alreadySend" value="no" ></input>
		<input type="hidden" name="top" value="${top}" ></input>
		<input type="hidden" name="left" value="${left}" ></input>
		<input type="hidden" name="lastDay" value="${lastDay}" ></input>
		<input type="hidden" name="dayOfWeek" value="${dayOfWeek}" ></input>
		<input type="hidden" name="s" value="${loginUser.startTime}" ></input>
		<input type="hidden" name="f" value="${loginUser.finishTime}" ></input>
		<input type="hidden" name="b" value="${loginUser.breakTime}" ></input>
		<input type="hidden" name="currentYear" value="${currentYear}" ></input>

	<table border=1 style="width:50%" >
		<tr>
			<th width="70">日付</th>
			<th>開始</th>
			<th>終了</th>
			<th>休憩</th>
			<th width="100">勤務形態</th>
			<th width="60">修正</th>
		</tr>

			<c:set var="w" value="${dayOfWeek}" />
			<c:if test="${listAttendance != null }">
			<c:set var="index" value="0" />
			<c:set var="workDay" value="${listAttendance[0].workedDay.substring(8,10)}" />

			<c:if test="${workDay.substring(0, 1) == '0' }">
					<c:set var="workDay" value="${Integer.parseInt(workDay.substring(1, 2))}" />
				</c:if>
			</c:if>

			<c:forEach var="i" begin="1" end="${lastDay}" step="1">
				<tr>
				<c:choose>
					<c:when test="${w==6}">
						<td style="color:blue"> ${i}(${weekJa[w]}) </td> <%-- 土曜日 --%>
					</c:when>
					<c:when test="${w==0}">
						<td style="color:red"> ${i}(${weekJa[w]}) </td> <%-- 日曜日 --%>
					</c:when>
					<c:otherwise>
						<td> ${i}(${weekJa[w]}) </td>
					</c:otherwise>
				</c:choose>

				<%-- dbからのデータ展開 --%>

				<c:choose>
					<%-- データが入力されてる場合 --%>
					<c:when test="${i==workDay}">

						<%-- 修正チェックされた場合 --%>
						<c:choose>
							<c:when test="${i == day}">
								<td>
									<input type="text" name="startTime" value="<c:if test="${listAttendance[index].startTime != null }"> ${listAttendance[index].startTime} </c:if>"></input>
								</td>
								<td>
									<input type="text" name="finishTime" value="<c:if test="${listAttendance[index].finishTime != null }"> ${listAttendance[index].finishTime} </c:if>"></input>
								</td>
								<td>
									<input type="text" name="breakTime" value="<c:if test="${listAttendance[index].breakTime != null }"> ${listAttendance[index].breakTime} </c:if>"></input>
								</td>

								<td style="text-align:center">
									<select name="workType">
									<c:if test="${listAttendance[index].workType == 1}">
										<option value="1" selected></option>
										<option value="2">有給</option>
										<option value="3">半有給</option>
										<option value="4">休日出勤</option>
									</c:if>
									<c:if test="${listAttendance[index].workType == 2}">
										<option value="1" ></option>
										<option value="2" selected>有給</option>
										<option value="3">半有給</option>
										<option value="4">休日出勤</option>
									</c:if>
									<c:if test="${listAttendance[index].workType == 3}">
										<option value="1" ></option>
										<option value="2">有給</option>
										<option value="3" selected>半有給</option>
										<option value="4">休日出勤</option>
									</c:if>
									<c:if test="${listAttendance[index].workType == 4}">
										<option value="1" ></option>
										<option value="2">有給</option>
										<option value="3">半有給</option>
										<option value="4" selected>休日出勤</option>
									</c:if>
									</select>
								</td>

								<td style="text-align:center">
									<input type="button" value="簡単" onclick="EasyInput()"></input><br>
									<input type="button" value="送信" onclick="Add(${listAttendance[index].id})"></input><br>
									<input type="button" value="削除" onclick="Delete(${listAttendance[index].id})"></input><br>
									<input type="button" value="取消" onClick="location.href='/employeeManagement/AttendanceServlet?command=attendanceSheet_list'"></input>
									<input type="hidden" name="num" value="${listAttendance[index].id}" ></input>
									<input type="hidden" name="day" value="${day}" ></input>
									<input type="hidden" name="command" value="" ></input>
								</td>

							</c:when>
							<%-- 入力されてる && 修正チェックされてない場合 --%>
							<c:otherwise>
								<td style="text-align:center">
									<output>
									<c:if test="${listAttendance[index].startTime != null }"> ${listAttendance[index].startTime} </c:if>
									</output>
								</td>
								<td style="text-align:center">
									<output>
									<c:if test="${listAttendance[index].finishTime != null }"> ${listAttendance[index].finishTime} </c:if>
									</output>
								</td>
								<td style="text-align:center">
									<output>
									<c:if test="${listAttendance[index].breakTime != null }"> ${listAttendance[index].breakTime} </c:if>
									</output>
								</td>

								<td style="text-align:center">
									<output name="type"> ${listAttendance[index].workTypeString} </output>
								</td>

								<td><output></output></td>

							</c:otherwise>
						</c:choose>

						<%-- listAttendance参照のためのindexなど変数加算 --%>
						<c:set var="index" value="${index+1}"/>
						<c:set var="workDay" value="${listAttendance[index].workedDay.substring(8,10)}" />
						<c:if test="${workDay.substring(0, 1) == '0' }">
							<c:set var="workDay" value="${Integer.parseInt(workDay.substring(1, 2))}" />
						</c:if>
					</c:when>

					<%-- データ入力されてない場合 --%>
					<c:otherwise>


						<c:choose>
							<%-- 修正チェックされた場合 --%>
							<c:when test="${i == day}">
								<td>
									<input type="text" name="startTime" value=""></input>
								</td>
								<td>
									<input type="text" name="finishTime" value=""></input>
								</td>
								<td>
									<input type="text" name="breakTime" value=""></input>
								</td>

								<td style="text-align:center">
									<select name="workType">
										<option value="1" selected></option>
										<option value="2">有給</option>
										<option value="3">半有給</option>
										<option value="4">休日出勤</option>
									</select>
								</td>

								<td style="text-align:center">
									<input type="button" value="簡単" onclick="EasyInput()"></input><br>
									<input type="button" value="送信" onclick="Add(0)"></input><br>
									<input type="button" value="削除" onclick="Delete(0)"></input><br>
									<input type="button" value="取消" onClick="location.href='/employeeManagement/AttendanceServlet?command=attendanceSheet_list'"></input>
									<input type="hidden" name="num" value="0" ></input>
									<input type="hidden" name="day" value="${day}" ></input>
									<input type="hidden" name="command" value="" ></input>
								</td>

							</c:when>

							<%-- その他：枠だけ作る --%>
							<c:otherwise>
								<td><output></output></td>
								<td><output></output></td>
								<td><output></output></td>
								<td><output></output></td>
								<td><output></output></td>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>

				</tr>

				<%--  曜日表示のための変数加算(dayOfWeek) --%>
				<c:set var="w" value="${w+1}" />
				<c:if test="${w==7}"> <c:set var="w" value="0" /> </c:if>
			</c:forEach>
	</table>

	</form>
</div>
</body>
</html>