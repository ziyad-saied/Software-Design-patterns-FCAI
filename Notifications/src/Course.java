package src;
import java.util.ArrayList;

import src.gateway.EmailGateway;
import src.gateway.SMSGateway;
import Messages.TaskAddedEmailMessage;
import src.Users.Professor;
import src.Users.Student;
import src.Users.TA;

public class Course  implements subject{

	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;
	
	ArrayList<CourseObserver> ObserverForEmailNotification;
	ArrayList<CourseObserver> ObserverForSMSNotification;



	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
		
		announcements = new ArrayList<String>();
		exams = new ArrayList<String>();
		grades = new ArrayList<String>();
		
		ObserverForEmailNotification = new ArrayList<CourseObserver>();
		ObserverForSMSNotification = new ArrayList<CourseObserver>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	
	
	public void AddAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here 

		notifyAllUsers(placeholders);
	}



	@Override
	public void subscribeObserverForEmailNotification(CourseObserver observer) {
		ObserverForEmailNotification.add(observer);

	}

	@Override
	public void subscribeObserverForSMSNotification(CourseObserver observer) {
		ObserverForSMSNotification.add(observer);

	}

	@Override
	public void notifyAllUsers(String [] placeholders) {
		// notify users by email
		TaskAddedEmailMessage msg = new TaskAddedEmailMessage();
		String notification = msg.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object

		EmailGateway emailGateway = EmailGateway.getInstance();
		SMSGateway smsGateway =  SMSGateway.getInstance();


		for (CourseObserver observer : ObserverForEmailNotification) {
			observer.notify(notification);
			emailGateway.sendMessage(notification, observer.getEmail());
		}
		for (CourseObserver observer : ObserverForSMSNotification) {
			observer.notify(notification);
			smsGateway.sendMessage(notification, observer.getEmail());

		}

	}


}

	// AddExam, PostGrades, PostAnnouncement  will be the same