package src.Users;

import src.CourseObserver;

public class TA implements CourseObserver {
	String name;
	String department;
	String email;
	String phoneNumber;
	
	

	public TA(String name, String department, String email, String phoneNumber) {
		super();
		this.name = name;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

	@Override
	public void notify(String message) {
		System.out.println(this.name+message);
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPhone() {
		return phoneNumber;
	}
}
