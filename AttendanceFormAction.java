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

public class AttendanceFormAction implements Action {

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
		int top = Integer.parseInt(request.getParameter("top"));
		int left = Integer.parseInt(request.getParameter("left"));

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		String url = "/WEB-INF/attendance/attendanceSheetForm.jsp";


		//勤務表の取得
		List<Attendance> listAttendance = new ArrayList<>();
		AttendanceDAO dao = new AttendanceDAO();
		listAttendance = dao.getAttendance(loginUser.getId(), year, month);
		request.setAttribute("listAttendance", listAttendance);

		//AttendanceSheetLogic asl = new AttendanceSheetLogic();
		//int lastDay = asl.getLastDay(year, month);
		//int dayOfWeek = asl.getDayOfWeek(year, month);

		//パラメータ設定後フォワード
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("dayOfWeek", dayOfWeek);
		request.setAttribute("currentYear", currentYear);
		request.setAttribute("left", left);
		request.setAttribute("top", top);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}

