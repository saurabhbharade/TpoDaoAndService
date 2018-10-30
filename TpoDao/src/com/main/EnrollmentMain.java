package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.CompanyDaoImpl;
import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.dao.EnrollmentExistsException;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.Company;
import com.model.Enrollment;
import com.model.Student;

public class EnrollmentMain 
{
	public static void main(String[] args) throws EnrollmentExistsException
	{
		EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do
		{
			System.out.println("1] Show details of an enrollment");
			System.out.println("2] Show all enrollments");
			
			
			System.out.println("3] Add an enrollment");
			System.out.println("4] Update an enrollment");
			System.out.println("5]Delete an enrollment");
			System.out.println("6] Get companies in which a student has enrolled in");
			System.out.println("7] Get students enrolled in a company");
			System.out.println("8]Exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					//SHOW DETAILS OF AN ENROLLMENT
					System.out.println("Enter eid ");
					int eid = sc.nextInt();
					
					Enrollment enrollment=enrollmentDao.getEnrollment(eid);
					System.out.println(enrollment);
					break;
				case 2:
					//DISPLAY ALL ENROLLMENTS
					List<Enrollment> allEnrollment=enrollmentDao.getAllEnrollments();
					for(Enrollment enroll:allEnrollment)
						System.out.println(enroll);
					break;
				case 3:
					//ADD
					System.out.println("Enter eid :");
					int eid1 = sc.nextInt();
					System.out.println("Enter sid ");
					int sid = sc.nextInt();
					System.out.println("Enter cid ");
					int cid = sc.nextInt();
					
					Enrollment enrollment1 = new Enrollment(eid1,new StudentDaoImpl().getStudent(sid),new CompanyDaoImpl().getCompany(cid));
					enrollmentDao.addEnrollment(enrollment1);
					break;

					
				case 4: 
					//UPDATE ENROLLMENT
					
					System.out.println("Enter eid to update ");
					int eid11=sc.nextInt();
					System.out.println("Enter sid");
					int sid1=sc.nextInt();
					System.out.println("Enter cid");
					int cid1=sc.nextInt();
					Enrollment en=new Enrollment(eid11,new StudentDaoImpl().getStudent(sid1),new CompanyDaoImpl().getCompany(cid1));
					enrollmentDao.updateEnrollment(en);
					break;
					
				case 5:
					//DELETE ENROLLMENT
					System.out.println("Enter Eid to delete");
					int eid3=sc.nextInt();
					Enrollment enrollment2=enrollmentDao.getEnrollment(eid3);
					enrollmentDao.deleteEnrollment(enrollment2);
					
					
					
					break;
				
				case 6:
					//COMPANIES ENROLLED BY A STUDENT
					System.out.println(" Companies enrollend by a student: ");
					System.out.println("enter sid");
					int sid3=sc.nextInt();
//					System.out.println("Enter cid ");
//					int cid=sc.nextInt();
					List<Company> companiesEnrolledByStudent = enrollmentDao.companiesEnrolledByStudent(sid3);
					for(Company companylist:companiesEnrolledByStudent)
					{
						System.out.println(companylist);
					}
					break;
					
				case 7:
					System.out.println("Enter cid to find list of students : ");
					int cid3=sc.nextInt();
					List<Student> studentEnrolledInCourse=enrollmentDao.enrolledStudentInCompany(cid3);
					for(Student s:studentEnrolledInCourse)
						System.out.println(s);
					
					break;

			}
			
		}while(choice!=8);
		
	}
}
