package src.Messages;

public class GradesAnnouncementEmailMessage implements Ihandel {
	Ihandel ihandel;

	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		return "";
	}
	
	public boolean verifyGrades() {
		// code to verify Grades before announcement
		
		return true;
	}

	@Override
	public void nextHandel(Ihandel ihandel) {
		this.ihandel =ihandel;

	}

	@Override
	public void handelMessage(Object message) {
		if(message instanceof GradesAnnouncementEmailMessage){
			System.out.println("i can handel it ");
		}
		else {
			System.out.println("I will Pass it to another gate");
			ihandel.handelMessage(message);
		}
	}
}
