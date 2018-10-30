package com.model;

import java.sql.Date;

public class Company 
{
	private int cid,backlog,numrequired,poolcampus;
	private String cname,designation,location;
	private float salary,ssc,hsc,beaggregate;
	private Date date_of_campus;
	
	//parameterized constructor
		public Company(int cid, int backlog, int numrequired, int poolcampus, String cname, String designation,
				String location, float salary, float ssc, float hsc, float beaggregate, Date date_of_campus) {
			super();
			this.cid = cid;
			this.backlog = backlog;
			this.numrequired = numrequired;
			this.poolcampus = poolcampus;
			this.cname = cname;
			this.designation = designation;
			this.location = location;
			this.salary = salary;
			this.ssc = ssc;
			this.hsc = hsc;
			this.beaggregate = beaggregate;
			this.date_of_campus = date_of_campus;
			
		}
		
		

		//default constructor
		public Company() {
			super();
		}
	
	//getters and setter
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getBacklog() {
		return backlog;
	}
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}
	public int getNumrequired() {
		return numrequired;
	}
	public void setNumrequired(int numrequired) {
		this.numrequired = numrequired;
	}
	public int getPoolcampus() {
		return poolcampus;
	}
	public void setPoolcampus(int poolcampus) {
		this.poolcampus = poolcampus;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
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
	public Date getDate_of_campus() {
		return date_of_campus;
	}

	public void setDate_of_campus(Date date_of_campus) {
		this.date_of_campus = date_of_campus;
	}



	@Override
	public String toString() {
		return "Company [cid=" + cid + ", backlog=" + backlog + ", numrequired=" + numrequired + ", poolcampus="
				+ poolcampus + ", cname=" + cname + ", designation=" + designation + ", location=" + location
				+ ", salary=" + salary + ", ssc=" + ssc + ", hsc=" + hsc + ", beaggregate=" + beaggregate
				+ ", date_of_campus=" + date_of_campus + "]";
	}
	
	//toString method
	
}
