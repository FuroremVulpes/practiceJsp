package attendance.controller.action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory(){
		super();
	}

	public static ActionFactory getInstance(){
		return instance;
	}

	public Action getAction(String command){
		Action action = null;
		System.out.println("ActionFactory :"+command);

		if(command.equals("attendanceSheet_list")){
			action = new AttendanceListAction();
		}else if(command.equals("attendanceSheet_form")){
			action = new AttendanceFormAction();
		}else if(command.equals("attendanceSheet_add")){
			action = new AttendanceAddAction();
		}else if(command.equals("attendanceSheet_delete")){
			action = new AttendanceDeleteAction();
		}else if(command.equals("attendanceSheet_update")){
			action = new AttendanceUpdateAction();
		}

		return action;
	}

}
