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
import model.LoginLogic;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String url = null;

		LoginLogic loginLogic = new LoginLogic();
		User loginUser = loginLogic.excute(id, pass);

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);

		//セッションにユーザー情報格納(認証TRUE時)
		if (loginUser == null){

			url = "/WEB-INF/jsp/login.jsp";
			//request.setAttribute("msg", "IDまたはパスワードが正しくありません");
			request.setAttribute("msg", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{

			url = "/employeeManagement/Main";
			response.sendRedirect(url);

		}

	}

}
