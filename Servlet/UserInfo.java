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


@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null){

			response.sendRedirect("/employeeManagement/");

		} else {

			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userInfo.jsp");
			d.forward(request, response);

		}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/userInfoChange.jsp");
		d.forward(request, response);
	}

}
