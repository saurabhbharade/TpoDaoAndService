package com.service;

import java.util.List;

import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.dao.EnrollmentExistsException;
import com.model.Company;
import com.model.CompanyCriteria;
import com.model.Enrollment;
import com.model.Student;

public class EnrollmentServiceImpl implements EnrollmentService{
EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
	@Override
	public List<Company> companiesEnrolledByStudentService(int sid) {
	return enrollmentDao.companiesEnrolledByStudent(sid);
	
	}
	@Override
	public boolean addEnrollmentService(Student student,Company company) {
//		Student student=enroll.getStudent();
//		Company company=enroll.getCompany();
		
		try {
			
		if(student.getSsc()<company.getSsc())
			return false;
		if(student.getHsc()<company.getHsc())
			return false;
		if(student.getBeaggregate()<company.getBeaggregate())
			return false;
		if(student.getBacklog()>company.getBacklog())
			return false;
		if(student.getHsc()<company.getHsc())
			return false;
		int flag=0;
		List<CompanyCriteria> companyCriteriaList = new CompanyCriteriaServiceImpl().getCompanyCriteriaService(company.getCid());
		for(CompanyCriteria companyCriteria:companyCriteriaList)
		{
			flag=0;
			if(companyCriteria.getYop()==student.getYop())
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
			return false;
		
		for(CompanyCriteria companyCriteria:companyCriteriaList)
		{
			flag=0;
			if(companyCriteria.getBranch().equalsIgnoreCase(student.getBranch()))
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
			return false;
		List<Enrollment> allEnrollmentList = new EnrollmentDaoImpl().getAllEnrollments();
		int size = allEnrollmentList.size()-1;
		int lasteid = allEnrollmentList.get(size).getEid();
		Enrollment enroll=new Enrollment(lasteid++, student, company);
		new EnrollmentDaoImpl().addEnrollment(enroll);
		return true;
		
			
		} catch (EnrollmentExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
