package com.service;

import java.util.List;

import com.model.Company;

public interface CompanyService {
public void addCompanyService(Company company);
public List<Company>getAllCompanyService();
public List<Company> getCompanyByYear(int year);
}
