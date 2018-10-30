package com.dao;

import java.util.List;

import com.model.Company;

public interface CompanyDao 
{
	String TABLEcompany = "Company", COLcid = "cid", COLcname = "cname",
		   COLbacklog = "backlog", COLnumrequired = "numrequired",
		   COLpoolcampus = "poolcampus", COLdesignation="designation",
		   COLlocation="location", COLsalary = "salary",
		   COLssc="ssc", COLhsc="hsc", COLbeaggregate="beaggregate", COLdate_of_campus="date_of_campus";
		
	Company getCompany(int cid);
	List<Company> getAllCompanies();
	void addCompany(Company c) throws CompanyExistsException;
	void updateCompany(Company c) throws CompanyExistsException;
	void deleteCompany(Company c) throws CompanyExistsException;
}
