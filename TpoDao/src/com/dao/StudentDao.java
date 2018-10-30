package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao 
{
	String TABLEStudent="Student",
			COLsid="sid",COLbacklog="backlog",
			COLstatus="status",COLpassword="password",COLsname="sname",
			COLbranch="branch",COLinstituteName="instituteName",COLemail="email",
			COLphone="phone",COLyearOfPassing="yop",COLssc="ssc",COLhsc="hsc",
			COLbeaggregate="beaggregate";

	Student getStudent(int sid);
	List<Student> getAllStudents();
	
	void addStudent(Student s) throws StudentExistsException;
	void updateStudent(Student s);
	void deleteStudent(Student s);
}
