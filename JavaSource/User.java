package dto;

import java.io.Serializable;

public class User implements Serializable {

	private String id;
	private String userType;
	private String name;
	private String hurigana;
	private String pass;
	private String email;
	private String phoneNumber;
	private String address;
	private int paidHoliday;
	private String startTime;
	private String finishTime;
	private String breakTime;

	public User(){}
	public User(String id, String userType, String name, String hurigana, String pass,
				String email, String phoneNumber, String address, int paidHoliday,
				String startTime, String finishTime, String breakTime){

		this.id = id;
		this.userType = userType;
		this.name = name;
		this.hurigana = hurigana;
		this.pass = pass;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.paidHoliday = paidHoliday;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.breakTime = breakTime;
	}

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getUserType() {
	    return userType;
	}

	public void setUserType(String userType) {
	    this.userType = userType;
	}


	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getHurigana() {
	    return hurigana;
	}

	public void setHurigana(String hurigana) {
	    this.hurigana = hurigana;
	}

	public String getPass() {
	    return pass;
	}

	public void setPass(String pass) {
	    this.pass = pass;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getPhoneNumber() {
	    return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public int getPaidHoliday() {
	    return paidHoliday;
	}

	public void setPaidHoliday(int paidHoliday) {
	    this.paidHoliday = paidHoliday;
	}

	public String getStartTime() {
	    return startTime;
	}

	public void setStartTime(String startTime) {
	    this.startTime = startTime;
	}

	public String getFinishTime() {
	    return finishTime;
	}

	public void setFinishTime(String finishTime) {
	    this.finishTime = finishTime;
	}

	public String getBreakTime() {
	    return breakTime;
	}

	public void setBreakTime(String breakTime) {
	    this.breakTime = breakTime;
	}

}
