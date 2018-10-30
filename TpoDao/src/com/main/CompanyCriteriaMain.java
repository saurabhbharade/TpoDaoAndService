package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.CompanyCriteriaDao;
import com.dao.CompanyCriteriaDaoImpl;
import com.dao.CompanyDaoImpl;
import com.model.Company;
import com.model.CompanyCriteria;

public class CompanyCriteriaMain {

	public static void main(String[] args) {
	
		CompanyCriteriaDao companyCriteriaDao = new CompanyCriteriaDaoImpl();
		
		Scanner s=new Scanner(System.in);
		int ch;
		System.out.println("Enter Choice : \n1.Get CompanyCriteria\n2.Get all CompaniesCriteria\n3.Add CompanyCriteria\n4.Update CompanyCriteria\n5.Delete CompanyCriterai");
		do
		{
			System.out.println("Enter choice");
			ch=s.nextInt();
		switch(ch)
		{
		case 1:
		System.out.println("Enter the company cid whose criteria is to be recieved : ");
		int cid = s.nextInt();
		List<CompanyCriteria> companyCriteria = companyCriteriaDao.getCompanyCriteria(cid);
		for(CompanyCriteria cc : companyCriteria)
			System.out.println(cc);
			break;
		case 2:
		//getting all criteria
			System.out.println("Printing all Criterias");
			List<CompanyCriteria> allCompaniesCriteriaList = companyCriteriaDao.getAllCompanyCriteria();
			for(CompanyCriteria compCriteriaList : allCompaniesCriteriaList)
				System.out.println(compCriteriaList);
			break;
			
		case 3:
			System.out.println("Enter critid :");
			int critid = s.nextInt();
			System.out.println("Enter cid :");
			int cid1 = s.nextInt();
			System.out.println("Enter year of passing : ");
			int yop = s.nextInt();
			System.out.println("Enter the branch : ");
			String branch = s.next();
			
			CompanyCriteria companyCriteriaOb = new CompanyCriteria(critid,new CompanyDaoImpl().getCompany(cid1),yop,branch);
			companyCriteriaDao.addCompanyCriteria(companyCriteriaOb);
			break;
		case 4:
			System.out.println("Enter critid to be updated :");
			int critid1 = s.nextInt();
			System.out.println("Enter cid to be updated :");
			int cid2 = s.nextInt();
			System.out.println("Enter new year of passing : ");
			int yop1 = s.nextInt();
			System.out.println("Enter new the branch : ");
			String branch2 = s.next();
			
			CompanyCriteria companyCriteriaOb2 = new CompanyCriteria(critid1,new CompanyDaoImpl().getCompany(cid2),yop1,branch2);
			companyCriteriaDao.updateCompanyCriteria(companyCriteriaOb2);
			break;
			
		case 5:
			System.out.println("Enter cid to delete : ");
			int cid_to_delete = s.nextInt();
			List<CompanyCriteria> companyCriteria2 = companyCriteriaDao.getCompanyCriteria(cid_to_delete);
			companyCriteriaDao.deleteCompanyCriteria(companyCriteria2.get(0));
		}
	}while(ch!=6);
	}
}
