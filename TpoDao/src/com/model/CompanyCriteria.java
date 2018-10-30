package com.model;

public class CompanyCriteria
{
	int critid;
	Company company;
	int yop;
	String branch;
	
	//parameterized constructor
	public CompanyCriteria(int critid, Company company, int yop, String branch) {
		super();
		this.critid=critid;
		this.company = company;
		this.yop = yop;
		this.branch = branch;
	}

	//default constructor
	public CompanyCriteria() {
		super();
	}

	

	/*public CompanyCriteria(Company company2, int int1, String string) {
		// TODO Auto-generated constructor stub
	}*/

	/*public CompanyCriteria(Company company2) {
		this.company=company2;
		// TODO Auto-generated constructor stub
	}*/

	//getters and setters
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	

	public int getCritid() {
		return critid;
	}

	public void setCritid(int critid) {
		this.critid = critid;
	}

	

//toString
	
	@Override
	public String toString() {
		return "CompanyCriteria [critid=" + critid + ", company=" + company + ", yop=" + yop + ", branch=" + branch
				+ "]";
	}

	
	
	
	
}
