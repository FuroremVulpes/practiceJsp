package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.User;

public class UserInfoDAO {

	public boolean updateInfo(User user){
		String sql = "update employees set user_name=?, hurigana=?, password=? ,e_mail=?, phone_number=? ,address=?,"
				+ "start_time=?, finish_time=?, break_time=? where id = ?";
		UserDatabase userDatabase = new UserDatabase();

		try(Connection conn = userDatabase.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getHurigana());
			pstmt.setString(3, user.getPass());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getStartTime());
			pstmt.setString(8, user.getFinishTime());
			pstmt.setString(9, user.getBreakTime());
			pstmt.setString(10, user.getId());

			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	return true;
	}
}
