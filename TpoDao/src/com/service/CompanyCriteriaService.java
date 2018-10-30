package com.service;

import java.util.List;

import com.model.CompanyCriteria;

public interface CompanyCriteriaService {
public List<CompanyCriteria> getCompanyCriteriaService(int cid);

public void addCompanyCriteriaService(CompanyCriteria companyCriteria);
}
