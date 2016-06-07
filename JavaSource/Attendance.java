package dto;

import java.io.Serializable;

public class Attendance implements Serializable {

	private int id;
	private String workedDay;
	private String startTime;
	private String finishTime;
	private String breakTime;
	private String userId;
	private int workType;
	private String workTypeString;
	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id) {
	    this.id = id;
	}
	/**
	 * workedDayを取得します。
	 * @return workedDay
	 */
	public String getWorkedDay() {
	    return workedDay;
	}
	/**
	 * workedDayを設定します。
	 * @param workedDay workedDay
	 */
	public void setWorkedDay(String workedDay) {
	    this.workedDay = workedDay;
	}
	/**
	 * startTimeを取得します。
	 * @return startTime
	 */
	public String getStartTime() {
	    return startTime;
	}
	/**
	 * startTimeを設定します。
	 * @param startTime startTime
	 */
	public void setStartTime(String startTime) {
	    this.startTime = startTime;
	}
	/**
	 * finishTimeを取得します。
	 * @return finishTime
	 */
	public String getFinishTime() {
	    return finishTime;
	}
	/**
	 * finishTimeを設定します。
	 * @param finishTime finishTime
	 */
	public void setFinishTime(String finishTime) {
	    this.finishTime = finishTime;
	}
	/**
	 * breakTimeを取得します。
	 * @return breakTime
	 */
	public String getBreakTime() {
	    return breakTime;
	}
	/**
	 * breakTimeを設定します。
	 * @param breakTime breakTime
	 */
	public void setBreakTime(String breakTime) {
	    this.breakTime = breakTime;
	}
	/**
	 * userIdを取得します。
	 * @return userId
	 */
	public String getUserId() {
	    return userId;
	}
	/**
	 * userIdを設定します。
	 * @param userId userId
	 */
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	/**
	 * workTypeを取得します。
	 * @return workType
	 */
	public int getWorkType() {
	    return workType;
	}
	/**
	 * workTypeを設定します。
	 * @param workType workType
	 */
	public void setWorkType(int workType) {
	    this.workType = workType;
	}
	/**
	 * workTypeStringを取得します。
	 * @return workTypeString
	 */
	public String getWorkTypeString() {
	    return workTypeString;
	}
	/**
	 * workTypeStringを設定します。
	 * @param workTypeString workTypeString
	 */
	public void setWorkTypeString(String workTypeString) {
	    this.workTypeString = workTypeString;
	}




}
