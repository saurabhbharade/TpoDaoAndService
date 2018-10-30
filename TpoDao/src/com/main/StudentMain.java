package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.StudentExistsException;
import com.model.Student;

public class StudentMain 
{

	public static void main(String[] args) throws StudentExistsException
	{
		StudentDao studentDao=new StudentDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do
		{
			System.out.println("1] Show details of a student");
			System.out.println("2] Show all students");
			System.out.println("3] Add a student");
			System.out.println("4] Update a student");
			System.out.println("5]Delete a student");
			System.out.println("6]Exit");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
					//DISPLAYING DETAILS OF ONE STUDENT
					System.out.println("Printing Information of student");
					System.out.println("Enter sid : ");
					int sid=sc.nextInt();
					Student student=studentDao.getStudent(sid);
					System.out.println(student);
					break;
				
					
				case 2: 
					//DISPLAYING DETAILS OF ALL STUDENTS
							
					List<Student> allStudents=studentDao.getAllStudents();
					for(Student st: allStudents)
					{
						System.out.println(st);
					}
					break;
				case 3:
					
					//ADD A STUDENT
					System.out.println("Enter sid of student : ");
					int sid1=sc.nextInt();
					System.out.println("How many backlogs?");
					int backlog=sc.nextInt();
					System.out.println("Status of being placed");
					int status=sc.nextInt();
					System.out.println("Enter password");
					String password=sc.next();
					System.out.println("Enter Name");
					String name=sc.next();
					System.out.println("Enter branch");
					String branch=sc.next();
					System.out.println("Enter institute name");
					String instName=sc.next();
					System.out.println("Enter email");
					String email=sc.next();
					System.out.println("Enter phone number ");
					long phno=sc.nextLong();
					System.out.println("Enter year of passing ");
					int yop=sc.nextInt();
					System.out.println("Enter SSC marks ");
					float ssc=sc.nextFloat();
					System.out.println("Enter HSC marks ");
					float hsc=sc.nextFloat();
					System.out.println("Enter BE marks ");
					float be=sc.nextFloat();
							
					Student student1=new Student(sid1,backlog,status,password,name,branch,instName,email,phno,yop,ssc,hsc,be);
					try {
						studentDao.addStudent(student1);
					} catch (StudentExistsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(student1);
					break;
					
				case 4:
					//UPDATE A STUDENT
					System.out.println("Enter Sid to update");
					int sid2=sc.nextInt();
					System.out.println("How many backlogs?");
					int backlog1=sc.nextInt();
					System.out.println("Status of being placed");
					int status1=sc.nextInt();
					System.out.println("Enter password");
					String password1=sc.next();
					System.out.println("Enter Name");
					String name1=sc.next();
					System.out.println("Enter branch");
					String branch1=sc.next();
					System.out.println("Enter institute name");
					String instName1=sc.next();
					System.out.println("Enter email");
					String email1=sc.next();
					System.out.println("Enter phone number ");
					long phno1=sc.nextLong();
					System.out.println("Enter year of passing ");
					int yop1=sc.nextInt();
//					System.out.println("Enter SSC marks ");
//					Double ssc1=sc.nextDouble();
//					System.out.println("Enter HSC marks ");
//					Double hsc1=sc.nextDouble();
//					System.out.println("Enter BE marks ");
//					Double be1=sc.nextDouble();

					System.out.println("Enter SSC marks ");
					float ssc1=sc.nextFloat();
					System.out.println("Enter HSC marks ");
					float hsc1=sc.nextFloat();
					System.out.println("Enter BE marks ");
					float be1=sc.nextFloat();

					
					Student student2=new Student(sid2,backlog1,status1,password1,name1,branch1,instName1,email1,phno1,yop1,ssc1,hsc1,be1);
					studentDao.updateStudent(student2);
					
					Student updateStudent= studentDao.getStudent(sid2);
					System.out.println(updateStudent);
					break;
					
				case 5:
					//DELETE A STUDENT
					System.out.println("Enter Sid to delete");
					int sid3=sc.nextInt();
					Student student5=studentDao.getStudent(sid3);
					studentDao.deleteStudent(student5);
					
					Student deleteStudent= studentDao.getStudent(sid3);
					System.out.println(deleteStudent);
			}
		}while(choice!=6);
	}

}
