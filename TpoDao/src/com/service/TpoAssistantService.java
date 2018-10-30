package com.service;

import java.util.List;

import com.model.Student;

public interface TpoAssistantService {
	public boolean checkEligibilityOfStudentForCompany(int sid,int cid);
	public boolean checkEligibilityOfStudentForDreamStatus(int sid);
	public List<Student>getStudentEligibleForDreamStatus();
}
