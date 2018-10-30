package com.main;
import com.dao.CompanyExistsException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.model.Company;

public class CompanyMain 
{

	public static void main(String[] args) throws CompanyExistsException
	{
		CompanyDao companyDao = new CompanyDaoImpl();
		Scanner s=new Scanner(System.in);
		int ch;
		System.out.println("Enter Choice : \n1.Get Company\n2.Get all companies\n3.Add Company\n4.Update Company\n5.Delete Company");
		do
		{
			System.out.println("Enter choice");
			ch=s.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter cid ");
			int cid = s.nextInt();
			Company company = companyDao.getCompany(cid);
			System.out.println(company);
			break;
		case 2:
			List<Company> allCompanies = companyDao.getAllCompanies();
			for(Company comp : allCompanies)
				System.out.println(comp);
			break;
		case 3:
			System.out.println("Enter cid :");
			int cid1 = s.nextInt();
			System.out.println("Enter back criteria :");
			int back = s.nextInt();
			System.out.println("Enter no of students required :");
			int num = s.nextInt();
			System.out.println("Is it pool campus? :");
			int pool = s.nextInt();
			System.out.println("Enter company name :");
			String cname = s.next();
			System.out.println("Enter designation :");
			String design = s.next();
			System.out.println("Enter location :");
			String loc = s.next();
			System.out.println("Enter salary :");
			float sal = s.nextFloat();
			System.out.println("Enter ssc marks :");
			float ssc = s.nextFloat();
			System.out.println("Enter hsc marks :");
			float hsc = s.nextFloat();
			System.out.println("Enter beaggregate required :");
			float beagg = s.nextFloat();
			System.out.println("Enter the date of campus drive :");
			String dateString = s.next();
			
			Date date = Date.valueOf(dateString);
			
			Company companyOb = new Company(cid1,back,num,pool,cname,design,loc,sal,ssc,hsc,beagg,date);
			companyDao.addCompany(companyOb);
			break;
		case 4:
			System.out.println("Enter cid to update :");
			int cid2 = s.nextInt();
			System.out.println("Enter back criteria :");
			int back1 = s.nextInt();
			System.out.println("Enter no of students required :");
			int num1 = s.nextInt();
			System.out.println("Is it pool campus? :");
			int pool1 = s.nextInt();
			System.out.println("Enter company name :");
			String cname1 = s.next();
			System.out.println("Enter designation :");
			String design1 = s.next();
			System.out.println("Enter location :");
			String loc1 = s.next();
			System.out.println("Enter salary :");
			float sal1 = s.nextFloat();
			System.out.println("Enter ssc marks :");
			float ssc1 = s.nextFloat();
			System.out.println("Enter hsc marks :");
			float hsc1 = s.nextFloat();
			System.out.println("Enter beaggregate required :");
			float beagg1 = s.nextFloat();
			System.out.println("Enter the date of campus drive :");
			String dateString1 = s.next();
			
			Date date1 = Date.valueOf(dateString1);
			
			Company companyOb1 = new Company(cid2,back1,num1,pool1,cname1,design1,loc1,sal1,ssc1,hsc1,beagg1,date1);
			companyDao.updateCompany(companyOb1);
			
			Company updateCompany =companyDao.getCompany(cid2);
			System.out.println(updateCompany);
			break;
		case 5:
			System.out.println("Enter cid to delete : ");
			int cid_to_delete = s.nextInt();
			Company comp = companyDao.getCompany(cid_to_delete);
			companyDao.deleteCompany(comp);
			
			Company deleteCompany = companyDao.getCompany(cid_to_delete);
			System.out.println(deleteCompany);
			break;
		}
		}while(ch!=6);
	}

}
