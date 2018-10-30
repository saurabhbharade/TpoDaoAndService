package com.model;

public class Enrollment 
{
	int eid;
	Student student;
	Company company;
	
	
		//empty constructor
		public Enrollment() {
			super();
		}
		
		//parameterized constructor
		public Enrollment(int eid, Student student, Company company) {
		super();
		this.eid = eid;
		this.student = student;
		this.company = company;
	}
		
    //For CRUD operations		
	public Enrollment(Student student, Company company) {
			// TODO Auto-generated constructor stub
		}

	//getters and setters
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	//to String
	@Override
	public String toString() {
		return "Enrollment [eid=" + eid + ", student=" + student + ", company=" + company + "]";
	}

	
	
}
