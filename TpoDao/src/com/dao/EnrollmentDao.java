package com.dao;

import java.util.List;

import com.model.Company;
import com.model.Enrollment;
import com.model.Student;

public interface EnrollmentDao 
{
	String TABLEenrollment="Enrollment",
			COLeid="eid",COLsid="sid",COLcid="cid";
	
	List<Enrollment> getAllEnrollments()throws EnrollmentExistsException;
	
	Enrollment getEnrollment(int eid);//
	
	Enrollment addEnrollment(Enrollment e);
	
	void updateEnrollment(Enrollment e);
	void deleteEnrollment(Enrollment e);

	public List<Student> enrolledStudentInCompany(int cid);
	public List<Company> companiesEnrolledByStudent(int sid);
	
}
