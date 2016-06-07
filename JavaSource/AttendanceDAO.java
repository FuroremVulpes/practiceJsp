package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Attendance;

public class AttendanceDAO {

	public List<Attendance> getAttendance(String userId, int year, int month){

		String sql = "select attendance.id, worked_day, start_time, finish_time, break_time,"+
					 "attendance.work_type, worktype.work_type as work_typeString "+
					 "from attendance "+
					 "join worktype "+
					 "on attendance.work_type = worktype.id "+
					 "where user_id = ? and worked_day >= ? and worked_day < ? "+
					 "order by worked_day";

		UserDatabase userDatabase = new UserDatabase();
		//User loginUser = new User();
		List<Attendance > listAttendance = new ArrayList<>();


		try(Connection conn = userDatabase.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, year + "-" + month + "-01");
			pstmt.setString(3, year + "-" + (month + 1) + "-01");

			try(ResultSet rs = pstmt.executeQuery()){

				while(rs.next()){

					Attendance attendance = new Attendance();

					attendance.setId(rs.getInt("id"));
					attendance.setWorkedDay(rs.getString("worked_day"));

					String startTime = rs.getString("start_time");
					if (startTime != null) attendance.setStartTime(startTime.substring(0,5));

					String finishTime = rs.getString("finish_time");
					if (finishTime != null) attendance.setFinishTime(finishTime.substring(0,5));

					String breakTime = rs.getString("break_Time");
					if (breakTime != null) attendance.setBreakTime(breakTime.substring(0,5));

					attendance.setWorkType(rs.getInt("work_type"));
					attendance.setWorkTypeString(rs.getString("work_typeString"));

					System.out.println(attendance.getStartTime()+attendance.getFinishTime()+attendance.getBreakTime());
					listAttendance.add(attendance);

				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return listAttendance;
		//System.out.println(listAttendance.size());
	}


	public boolean addAttendance(Attendance attendance){

		UserDatabase userDatabase = new UserDatabase();
		String sql = "insert into attendance (worked_day, start_time, finish_time, break_time, user_id, work_type) values(?, ?, ?, ?, ?, ?)";

		try(Connection conn = userDatabase.getConnection()){

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, attendance.getWorkedDay());

			//time形nullで入れるための処理
			if (attendance.getStartTime().length() == 0) {
				pstmt.setTime(2, null);
			}else {
				pstmt.setString(2, attendance.getStartTime());
			}
			if (attendance.getFinishTime().length() == 0) {
				pstmt.setTime(3, null);
			}else {
				pstmt.setString(3, attendance.getFinishTime());
			}
			if (attendance.getBreakTime().length() == 0) {
				pstmt.setTime(4, null);
			}else {
				pstmt.setString(4, attendance.getBreakTime());
			}
			pstmt.setString(5, attendance.getUserId());
			pstmt.setInt(6, attendance.getWorkType());

			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateAttendance(Attendance attendance){
		UserDatabase userDatabase = new UserDatabase();
		String sql = "update attendance set start_time=?, finish_time=?, break_time=?, work_type=? where id=?";

		//"update attendance set break_time= '01:00:00' where worked_day='2016-05-29' and user_id= '62';"

		try(Connection conn = userDatabase.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//time形nullで入れるための処理
			if (attendance.getStartTime().length() == 0) {
				pstmt.setTime(1, null);
			}else {
				pstmt.setString(1, attendance.getStartTime());
			}
			if (attendance.getFinishTime().length() == 0) {
				pstmt.setTime(2, null);
			}else {
				pstmt.setString(2, attendance.getFinishTime());
			}
			if (attendance.getBreakTime().length() == 0) {
				pstmt.setTime(3, null);
			}else {
				pstmt.setString(3, attendance.getBreakTime());
			}

			pstmt.setInt(4, attendance.getWorkType());
			pstmt.setInt(5, attendance.getId());

			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteAttendance(Attendance attendance){
		UserDatabase userDatabase = new UserDatabase();
		String sql = "delete from attendance where id=? and worked_day=? and user_id=?";

		try(Connection conn = userDatabase.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, attendance.getId());
			pstmt.setString(2, attendance.getWorkedDay());
			pstmt.setString(3, attendance.getUserId());
			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
