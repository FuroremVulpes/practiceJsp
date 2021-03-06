package attendance.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDAO;
import dto.Attendance;
import dto.User;

/**
 * Servlet implementation class AttendanceSheetListAction
 */

public class AttendanceAddAction implements Action {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day")); //チェックされた日
		int lastDay = Integer.parseInt(request.getParameter("lastDay"));
		int dayOfWeek = Integer.parseInt(request.getParameter("dayOfWeek"));
		int currentYear = Integer.parseInt(request.getParameter("currentYear"));
		String top = request.getParameter("top");
		String left = request.getParameter("left");

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		String url = "/WEB-INF/attendance/attendanceSheetList.jsp";


		//勤務表内容セット
		String startTime = request.getParameter("startTime");
		String finishTime = request.getParameter("finishTime");
		String breakTime = request.getParameter("breakTime");
		int workType = Integer.parseInt(request.getParameter("workType"));

		Attendance attendance = new Attendance();
		AttendanceDAO dao = new AttendanceDAO();
		if((startTime != "" && finishTime != "" && breakTime != "") || workType > 1){
			//勤務表内容セット後、DBへADD処理
			attendance.setId(Integer.parseInt(request.getParameter("num")));
			attendance.setWorkedDay(year +"-"+ month +"-"+ day );
			attendance.setUserId(loginUser.getId());
			attendance.setStartTime(startTime);
			attendance.setFinishTime(finishTime);
			attendance.setBreakTime(breakTime);
			attendance.setWorkType(workType);
			dao.addAttendance(attendance);
		}

		//勤務表の取得
		List<Attendance> listAttendance = new ArrayList<>();
		listAttendance = dao.getAttendance(loginUser.getId(), year, month);
		request.setAttribute("listAttendance", listAttendance);


		//パラメータ設定後フォワード
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("dayOfWeek", dayOfWeek);
		request.setAttribute("currentYear", currentYear);
		request.setAttribute("left", left);
		request.setAttribute("top", top);
		//request.setAttribute("command", "attendanceSheet_list");
		request.setAttribute("view", "otherMonth");

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}

