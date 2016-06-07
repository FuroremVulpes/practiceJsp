package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class LoginDAO {

	public User excute(String userId){

		String sql = "select * from employees where id = ?";
		UserDatabase userDatabase = new UserDatabase();
		User loginUser = new User();

		try(Connection conn = userDatabase.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			try(ResultSet rs = pstmt.executeQuery()){

				if(rs.next()){
					String id = rs.getString("id");
					String userType = rs.getString("user_type");
					String name = rs.getString("user_name");
					String hurigana = rs.getString("hurigana");
					String pass = rs.getString("password");
					String eMail = rs.getString("e_mail");
					String phoneNumber = rs.getString("phone_number");
					String address = rs.getString("address");
					int paidHoliday = rs.getInt("paidholiday");
					String startTime = rs.getString("start_time").substring(0, 5);
					String finishTime = rs.getString("finish_time").substring(0, 5);
					String breakTime = rs.getString("break_time").substring(0, 5);
					User user = new User(id, userType, name, hurigana, pass, eMail,
						phoneNumber, address, paidHoliday, startTime, finishTime, breakTime);
					loginUser = user;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return loginUser;
	}
}
