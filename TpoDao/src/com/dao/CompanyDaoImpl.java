package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Company;

public class CompanyDaoImpl implements CompanyDao
{
	private static List<Company> allCompaniesList = new ArrayList<Company>();

	@Override
	public Company getCompany(int cid) 
	{
		try {
			Company dummy = new Company();
			dummy.setCid(cid);
			
			if(allCompaniesList.contains(dummy))
			{
				int index = allCompaniesList.indexOf(dummy);
				return allCompaniesList.get(index);
			} //checking if the Company exists in the list 
			
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "select * from "+ TABLEcompany + " where "+ COLcid + "="+ "?";
			
				PreparedStatement pst = connection.prepareStatement(sqlQuery);
				pst.setInt(1, cid);
				pst.executeQuery();
				ResultSet rs = pst.getResultSet();
				if(rs.next() == false) 
					return null;
				
				int backlog = rs.getInt(COLbacklog);
				int numrequired = rs.getInt(COLnumrequired);
				int poolcampus = rs.getInt(COLpoolcampus);
				String cname = rs.getString(COLcname);
				String designation = rs.getString(COLdesignation);
				String location = rs.getString(COLlocation);
				float salary = rs.getFloat(COLsalary);
				float ssc = rs.getFloat(COLssc);
				float hsc = rs.getFloat(COLhsc);
				float beaggregate = rs.getFloat(COLbeaggregate);
				Date date_of_campus = rs.getDate(COLdate_of_campus);
				
				Company company = new Company(cid, backlog, numrequired, poolcampus, cname, designation, location, salary, ssc, hsc, beaggregate,date_of_campus);
				allCompaniesList.add(company);
				return company;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Company> getAllCompanies() {
		
		allCompaniesList = new ArrayList<Company>();
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "select * from " + TABLEcompany;
			
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			
			while(rs.next())
			{
				int cid = rs.getInt(COLcid);
				int backlog = rs.getInt(COLbacklog);
				int numrequired = rs.getInt(COLnumrequired);
				int poolcampus = rs.getInt(COLpoolcampus);
				String cname = rs.getString(COLcname);
				String designation = rs.getString(COLdesignation);
				String location = rs.getString(COLlocation);
				float salary = rs.getFloat(COLsalary);
				float ssc = rs.getFloat(COLssc);
				float hsc = rs.getFloat(COLhsc);
				float beaggregate = rs.getFloat(COLbeaggregate);
				Date date_of_campus = rs.getDate(COLdate_of_campus);
				
				Company company1 = new Company(cid, backlog, numrequired, poolcampus, cname, designation, location, salary, ssc, hsc, beaggregate,date_of_campus);
				allCompaniesList.add(company1);
			}
			return allCompaniesList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return allCompaniesList;
		
	}
	

	@Override
	public void addCompany(Company c) throws CompanyExistsException {
		
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "insert into " + TABLEcompany + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			
			
			pst.setInt(1, c.getCid());
			pst.setString(2, c.getCname());
			pst.setFloat(3, c.getSalary());
			pst.setString(4, c.getDesignation());
			pst.setString(5, c.getLocation());
			pst.setFloat(6, c.getSsc());
			pst.setFloat(7, c.getHsc());
			pst.setFloat(8, c.getBeaggregate());
			pst.setInt(9, c.getBacklog());
			pst.setInt(10, c.getNumrequired());
			pst.setInt(11, c.getPoolcampus());
			pst.setDate(12, c.getDate_of_campus());
			
			pst.executeUpdate();
			allCompaniesList.add(c);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCompany(Company c) throws CompanyExistsException {
		
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "update " + TABLEcompany + " set " + COLbacklog + "=?, "+ COLnumrequired + "=?, "+ COLpoolcampus + "=?, "+ COLcname + "=?, "+ COLdesignation + "=?, "+ COLlocation +"=?, "+ COLsalary +"=?, "+ COLssc +"=?, "+ COLhsc +"=?, "+ COLbeaggregate +"=? ,"+COLdate_of_campus+"=? where cid = " + c.getCid() + ";";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1, c.getBacklog());
			pst.setInt(2, c.getNumrequired());
			pst.setInt(3, c.getPoolcampus());
			pst.setString(4, c.getCname());
			pst.setString(5, c.getDesignation());
			pst.setString(6, c.getLocation());
			pst.setFloat(7, c.getSalary());
			pst.setFloat(8, c.getSsc());
			pst.setFloat(9, c.getHsc());
			pst.setFloat(10, c.getBeaggregate());
			pst.setDate(11, c.getDate_of_campus());
			
			pst.executeUpdate();
			for(Company ct: allCompaniesList)
			{
				if(ct.getCid()==c.getCid())
				{
					ct.setBacklog(c.getBacklog());
					ct.setNumrequired(c.getNumrequired());
					ct.setPoolcampus(c.getPoolcampus());
					ct.setCname(c.getCname());
					ct.setDesignation(c.getDesignation());
					ct.setLocation(c.getLocation());
					ct.setSalary(c.getSalary());
					ct.setSsc(c.getSsc());
					ct.setHsc(c.getHsc());
					ct.setBeaggregate(c.getBeaggregate());
					ct.setDate_of_campus(c.getDate_of_campus());
				}
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}

	@Override
	public void deleteCompany(Company c) throws CompanyExistsException {
		int cid = c.getCid();
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "delete from "+ TABLEcompany + " where cid ="+cid+";";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			
			int result = pst.executeUpdate();
			Company dummy= new Company();
			dummy.setCid(cid);
			if(allCompaniesList.contains(dummy))
			{
				allCompaniesList.remove(dummy);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	

}
