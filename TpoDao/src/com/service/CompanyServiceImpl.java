package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.CompanyExistsException;
import com.model.Company;

public class CompanyServiceImpl implements CompanyService{
	CompanyDao companyDao=new CompanyDaoImpl();
	@Override
	public void addCompanyService(Company company) {
		try {
			companyDao.addCompany(company);
		} catch (CompanyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Company> getAllCompanyService() {
		// TODO Auto-generated method stub
		return companyDao.getAllCompanies();
	}
	@Override
	public List<Company> getCompanyByYear(int year) {
		List<Company> companyByYearList=new ArrayList<Company>();
		List<Company> allCompanyList = getAllCompanyService();
		for(Company company:allCompanyList)
		{
			int yearOfCampus = company.getDate_of_campus().getYear();
			yearOfCampus=yearOfCampus+1900; // by default 1900 will be subtracted
			if(yearOfCampus==year)
			{
				companyByYearList.add(company);
			}
		}
		return companyByYearList;
		
	
	}

}
