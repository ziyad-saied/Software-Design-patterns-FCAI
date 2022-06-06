package src.gateway;

import src.Messages.DailyNewsMobileMessage;
import src.Messages.GradesAnnouncementMobileMessage;
import src.Messages.TaskAddedMobileMessage;

public class SMSGateway {


	private static SMSGateway instance;
	public static SMSGateway getInstance(){
		if (instance==null){
			instance=new SMSGateway();
		}
		return instance;
	}

	public void sendMessage(Object message, String user) {
		String[] placeHolders = new String[] {}; // set some place holders here 
		
		if(message instanceof DailyNewsMobileMessage) {
			DailyNewsMobileMessage msg = (DailyNewsMobileMessage) message;
			
			msg.prepareMessage(placeHolders);
			
			// some code to send message
		}
		
		else if(message instanceof GradesAnnouncementMobileMessage) {
			GradesAnnouncementMobileMessage msg = (GradesAnnouncementMobileMessage) message;
			
			msg.prepareMessage(placeHolders);
			
			// some code to send message
		}
		
		else if(message instanceof TaskAddedMobileMessage) {
			TaskAddedMobileMessage msg = (TaskAddedMobileMessage) message;
			
			msg.prepareMessage(placeHolders);
			
			// some code to send message to user
		}
		
	}
}
