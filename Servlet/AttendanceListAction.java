package attendance.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

public class AttendanceListAction implements Action {

	@Override
	public void excute(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int year = 0;
		int month = 0;
		int currentYear = 0;

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		String view = request.getParameter("view");

		Calendar cal = Calendar.getInstance();
		currentYear = cal.get(Calendar.YEAR);
		if (view != null){
			if(view.equals("otherMonth")) {
				year = Integer.parseInt(request.getParameter("year"));
				month = Integer.parseInt(request.getParameter("month"));
			}else{
				//現在の年月
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
		} else {
			//現在の年月
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
		}
		//int	day = 1;


		String url = "/WEB-INF/attendance/attendanceSheetList.jsp";

		//勤務表の取得
		List<Attendance> listAttendance = new ArrayList<>();
		AttendanceDAO dao = new AttendanceDAO();
		listAttendance = dao.getAttendance(loginUser.getId(), year, month);
		request.setAttribute("listAttendance", listAttendance);

		int lastDay = getLastDay(year, month);
		int dayOfWeek = getDayOfWeek(year, month);

		//パラメータ設定後フォワード
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		//request.setAttribute("day", day);
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("dayOfWeek", dayOfWeek);
		request.setAttribute("currentYear", currentYear);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	public int getLastDay(int year, int month){

		int day = 0;

		switch (month) {

			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
			case 2:
				if(((year%4 == 0) && !(year%100 ==0)) || (year%400 == 0)){
					day = 29;
				}else{
					day = 28;
				}
				break;
		}
		return day;
	}

	public int getDayOfWeek(int year, int month){

	/*日,月,火,水,木,金,土
	 * 0, 1, 2, 3, 4, 5, 6
	 */

		Calendar cal = new GregorianCalendar(year, month - 1, 1); //なぜ月を-1??

	    switch (cal.get(Calendar.DAY_OF_WEEK)) {
        	case Calendar.SUNDAY: return 0;
        	case Calendar.MONDAY: return 1;
        	case Calendar.TUESDAY: return 2;
        	case Calendar.WEDNESDAY: return 3;
        	case Calendar.THURSDAY: return 4;
        	case Calendar.FRIDAY: return 5;
        	case Calendar.SATURDAY: return 6;
	    }
    throw new IllegalStateException();

	}

}
