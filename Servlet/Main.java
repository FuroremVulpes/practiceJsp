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


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		String url = null;

		if (loginUser == null){
			response.sendRedirect("/employeeManagement/");
		} else {

			switch (loginUser.getUserType()){
			case "0":
				url = ("/WEB-INF/jsp/adminMain.jsp");
				break;
			case "1":
				url = ("/WEB-INF/jsp/main.jsp");
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(url);
			d.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

	}

}
