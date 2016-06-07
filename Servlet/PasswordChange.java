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


@WebServlet("/PasswordChange")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null){

			response.sendRedirect("/employeeManagement/");

		} else {

			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/passChange.jsp");
			d.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		request.setCharacterEncoding("utf-8");

		//オブジェクトのパスワードの設定
		loginUser.setPass(request.getParameter("newPass1"));

		UserInfoLogic uif = new UserInfoLogic();
	 	boolean isResult = uif.updateInfo(loginUser);

	 	if (isResult){
	 		session.setAttribute("loginUsr", loginUser);
	 	} //else {
	 		//request.setAttribute("isResult", true);
	 	//}

	 	request.setAttribute("isResult", isResult);
 		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/passChangeResult.jsp");
 		d.forward(request, response);
	}

}
