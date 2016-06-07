package model;

import dao.LoginDAO;
import dto.User;

public class LoginLogic {
	public User excute(String id, String pass){
		LoginDAO dao = new LoginDAO();
		User loginUser = dao.excute(id);

		String userId = loginUser.getId();
		String password = loginUser.getPass();

		if (password != null && userId.equals(id) && password.equals(pass)){
			return loginUser;
		}
		return null;
	}
}
