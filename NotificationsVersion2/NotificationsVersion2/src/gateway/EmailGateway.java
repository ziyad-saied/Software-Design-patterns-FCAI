package src.gateway;

import src.Messages.DailyNewsEmailMessage;
import src.Messages.GradesAnnouncementEmailMessage;
import src.Messages.TaskAddedEmailMessage;


public class EmailGateway {

	private static EmailGateway instance;
	public static EmailGateway getInstance(){
		if (instance==null){
			instance=new EmailGateway();
		}
		return instance;
	}


	public void sendMessage(Object message, String user) {
		String[] placeHolders = new String[] {}; // set some place holders here 
		
		if(message instanceof DailyNewsEmailMessage) {
			DailyNewsEmailMessage dailyNewsEmailMessage = (DailyNewsEmailMessage) message;
			
			dailyNewsEmailMessage.prepareMessage(placeHolders);
			
			// some code to send message
		}
		
		else if(message instanceof GradesAnnouncementEmailMessage) {
			GradesAnnouncementEmailMessage announcementEmailMessage = (GradesAnnouncementEmailMessage) message;
			
			announcementEmailMessage.prepareMessage(placeHolders);
			
			// some code to send message
		}
		
		else if(message instanceof TaskAddedEmailMessage) {
			TaskAddedEmailMessage addedEmailMessage = (TaskAddedEmailMessage) message;
			
			addedEmailMessage.prepareMessage(placeHolders);
			
			// some code to send message by email to user
		}
		
	}
}
