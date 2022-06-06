package src.Users;

import src.CourseObserver;

public class Student implements CourseObserver {
	String name;
	int Id;
	String email;
	String phoneNumber;

	public Student(String name, int id, String email, String phoneNumber) {
		super();
		this.name = name;
		Id = id;
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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
