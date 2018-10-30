package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student 
{
	private int sid, backlog,status;
	private String password,sname,branch,instituteName,email;
	private int yop;
	private long phone;
	private float ssc,hsc,beaggregate;

	
	
	//parameterized constructor 
		public Student(int sid, int backlog, int status, 
				String password, String sname, String branch, String instituteName,
				String email, long phone, int yop, float ssc, float hsc, float beaggregate) 
		{
			super();
			this.sid = sid;
			this.backlog = backlog;
			this.status = status;
			this.password = password;
			this.sname = sname;
			this.branch = branch;
			this.instituteName = instituteName;
			this.email = email;
			this.phone = phone;
			this.yop = yop;
			this.ssc = ssc;
			this.hsc = hsc;
			this.beaggregate = beaggregate;
		}
		
		
		//empty constructor
		public Student() {
			super();
		}
		
	
	//getters and setters
		
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getBacklog() {
		return backlog;
	}
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}

	

	
	

	public float getSsc() {
		return ssc;
	}


	public void setSsc(float ssc) {
		this.ssc = ssc;
	}


	public float getHsc() {
		return hsc;
	}


	public void setHsc(float hsc) {
		this.hsc = hsc;
	}


	public float getBeaggregate() {
		return beaggregate;
	}


	public void setBeaggregate(float beaggregate) {
		this.beaggregate = beaggregate;
	}


	//To String
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", backlog=" + backlog + ", status=" + status + ", password=" + password
				+ ", sname=" + sname + ", branch=" + branch + ", instituteName=" + instituteName + ", email=" + email
				+ ", yop=" + yop + ", phone=" + phone + ", ssc=" + ssc + ", hsc=" + hsc + ", beaggregate=" + beaggregate
				+ "]";
	}

	
	
	}
	
	
	
	
	

