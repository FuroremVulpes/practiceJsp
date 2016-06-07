package model;

import dao.UserInfoDAO;
import dto.User;

public class UserInfoLogic {

	public boolean updateInfo(User user){

		UserInfoDAO dao = new UserInfoDAO();
		boolean isResult = dao.updateInfo(user);

		if (isResult){
			return true;
		}
		return false;
	}

}
