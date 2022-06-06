package src;
import java.util.ArrayList;

import src.Messages.*;
import src.gateway.EmailGateway;
import src.gateway.SMSGateway;
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
		TaskAddedMobileMessage msg2 = new TaskAddedMobileMessage();
		DailyNewsEmailMessage msg3 = new DailyNewsEmailMessage();
		DailyNewsMobileMessage msg4 = new DailyNewsMobileMessage();
		GradesAnnouncementEmailMessage msg5 = new GradesAnnouncementEmailMessage();
		GradesAnnouncementMobileMessage msg6 = new GradesAnnouncementMobileMessage();



		String notification = msg.prepareMessage(placeholders);
		String notification2 = msg2.prepareMessage(placeholders);
		String notification3 = msg3.prepareMessage(placeholders);
		String notification4 = msg4.prepareMessage(placeholders);
		String notification5 = msg5.prepareMessage(placeholders);
		String notification6 = msg6.prepareMessage(placeholders);

		// open connection for Email gateway and do some configurations to the object

		EmailGateway emailGateway = EmailGateway.getInstance();
		SMSGateway smsGateway =  SMSGateway.getInstance();


		for (CourseObserver observer : ObserverForEmailNotification) {
			observer.notify(notification);
			observer.notify(notification2);
			observer.notify(notification3);
			observer.notify(notification4);
			observer.notify(notification5);
			observer.notify(notification6);
			emailGateway.sendMessage(notification, observer.getEmail());
			emailGateway.sendMessage(notification2, observer.getPhone());
			emailGateway.sendMessage(notification3, observer.getPhone());
			emailGateway.sendMessage(notification4, observer.getEmail());
			emailGateway.sendMessage(notification5, observer.getEmail());
			emailGateway.sendMessage(notification6, observer.getEmail());
		}
		for (CourseObserver observer : ObserverForSMSNotification) {
			observer.notify(notification);
			observer.notify(notification2);
			observer.notify(notification3);
			observer.notify(notification4);
			observer.notify(notification5);
			observer.notify(notification6);
			smsGateway.sendMessage(notification, observer.getEmail());
			smsGateway.sendMessage(notification2, observer.getEmail());
			smsGateway.sendMessage(notification3, observer.getEmail());
			smsGateway.sendMessage(notification4, observer.getEmail());
			smsGateway.sendMessage(notification5, observer.getEmail());
			smsGateway.sendMessage(notification6, observer.getEmail());

		}

	}


}