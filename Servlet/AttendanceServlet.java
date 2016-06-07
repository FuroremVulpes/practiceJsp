package attendance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attendance.controller.action.Action;
import attendance.controller.action.ActionFactory;
import dto.User;


@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AttendanceServlet(){
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null){
			String command = request.getParameter("command");

			ActionFactory af = ActionFactory.getInstance();
			Action action = af.getAction(command);

			if(action != null){
				action.excute(request, response);
			}

			System.out.println("AttendanceSheetServletでリクエストされたことを確認 : "+command);
		}else {
			RequestDispatcher d = request.getRequestDispatcher("/Main");
			d.forward(request, response);

		}

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		doGet(request, response);

	}
}
