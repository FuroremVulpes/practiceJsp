package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import model.UserInfoLogic;


@WebServlet("/UserInfoChange")
public class UserInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userInfoChange.jsp");
		d.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		request.setCharacterEncoding("utf-8");
		loginUser.setName(request.getParameter("name"));
		loginUser.setHurigana(request.getParameter("hurigana"));
		loginUser.setEmail(request.getParameter("email"));
		loginUser.setPhoneNumber(request.getParameter("phoneNumber"));
		loginUser.setAddress(request.getParameter("address"));
		loginUser.setStartTime(request.getParameter("startTime"));
		loginUser.setFinishTime(request.getParameter("finishTime"));
		loginUser.setBreakTime(request.getParameter("breakTime"));


		UserInfoLogic uif = new UserInfoLogic();
		uif.updateInfo(loginUser);

		session.setAttribute("loginUser", loginUser);

		//RequestDispatcher d = request.getRequestDispatcher("/emlpoyeeManagement/UserInfo");
		//d.forward(request, response);
		response.sendRedirect("/employeeManagement/UserInfo");
	}

}
