package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Student;

public class StudentDaoImpl implements StudentDao
{
	private static List<Student> allStudentList=new ArrayList<Student>();
	
	@Override
	public Student getStudent(int sid) {
		try{
		//	Student dummy=new Student(sid,"","");
			  Student dummy=new Student();
			dummy.setSid(sid);
			//find student in list only
			if(allStudentList.contains(dummy))
			{
				int index=allStudentList.indexOf(dummy);
				return allStudentList.get(index);
			}
			//if student not found in list than get it from database
			else{
				
			
				
		Connection connection=DBConnection.getConnection();
		String sqlquery="select * from "+TABLEStudent+" where "+COLsid+"="+"?";
		PreparedStatement pst=connection.prepareStatement(sqlquery);
		pst.setInt(1, sid);
		pst.executeQuery();
		ResultSet rs=pst.getResultSet();
		if(rs.next()==false)
			return null;
			
			
				int backlog=rs.getInt(COLbacklog);
				int status=rs.getInt(COLstatus);
				String password=rs.getString(COLpassword);
				String name=rs.getString(COLsname);
				String branch=rs.getString(COLbranch);
				String institute=rs.getString(COLinstituteName);
				String email=rs.getString(COLemail);
				int phoneno=rs.getInt(COLphone);
				int yearOfPassing=rs.getInt(COLyearOfPassing);
//				double ssc=rs.getDouble(COLssc);
//				double hsc=rs.getDouble(COLhsc);
//				double BEaggregate=rs.getDouble(COLbeaggregate);
			
				float ssc=rs.getFloat(COLssc);
				float hsc=rs.getFloat(COLhsc);
				float BEaggregate=rs.getFloat(COLbeaggregate);

			Student student=new Student(sid, backlog,status,password,name, branch, institute,email,phoneno,yearOfPassing,ssc,hsc,BEaggregate);
			allStudentList.add(student);
			return student;
			}		
		}
		
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		allStudentList=new ArrayList<Student>();
	//	List <Student> list_of_students=new ArrayList<Student>();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="select * from "+TABLEStudent+";";
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
		
			while(rs.next())
			{
				int sid=rs.getInt(COLsid);
				int backlog=rs.getInt(COLbacklog);
				int status=rs.getInt(COLstatus);
				String password=rs.getString(COLpassword);
				String name=rs.getString(COLsname);
				String branch=rs.getString(COLbranch);
				String institute=rs.getString(COLinstituteName);
				String email=rs.getString(COLemail);
				int phoneno=rs.getInt(COLphone);
				int yearOfPassing=rs.getInt(COLyearOfPassing);
//				double ssc=rs.getDouble(COLssc);
//				double hsc=rs.getDouble(COLhsc);
//				double BEaggregate=rs.getDouble(COLbeaggregate);

				float ssc=rs.getFloat(COLssc);
				float hsc=rs.getFloat(COLhsc);
				float BEaggregate=rs.getFloat(COLbeaggregate);

				
			Student student=new Student(sid, backlog,status,password,name, branch, institute,email,phoneno,yearOfPassing,ssc,hsc,BEaggregate);
				allStudentList.add(student);
			}
			return allStudentList;
		}
			catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e);
			}

		return allStudentList;
	}
	
	

	@Override
	public void addStudent(Student s) throws StudentExistsException 
	{
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlquery="insert into "+TABLEStudent+" values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			
//			pst.setInt(1, s.getSid());
//			pst.setInt(2, s.getBacklog());
//			pst.setInt(3, s.getStatus());
//			pst.setString(4, s.getPassword());
//			pst.setString(5, s.getSname());
//			pst.setString(6, s.getBranch());
//			pst.setString(7,s.getInstituteName());
//			pst.setString(8, s.getEmail());
//			pst.setLong(9, s.getPhone());
//			pst.setInt(10, s.getYop());
////			pst.setDouble(11, s.getSsc());
////			pst.setDouble(12, s.getHsc());
////			pst.setDouble(13, s.getBeaggregate());
//
//			pst.setFloat(11, s.getSsc());
//			pst.setFloat(12, s.getHsc());
//			pst.setFloat(13, s.getBeaggregate());

			pst.setInt(1, s.getSid());
			pst.setString(2, s.getPassword());
			pst.setString(3, s.getSname());
			pst.setString(4, s.getBranch());
			pst.setFloat(5, s.getSsc());
			pst.setFloat(6, s.getHsc());
			pst.setFloat(7, s.getBeaggregate());
			pst.setInt(8, s.getYop());

			pst.setInt(9, s.getBacklog());
			pst.setInt(10, s.getStatus());
			pst.setString(11,s.getInstituteName());
			pst.setLong(12, s.getPhone());

			pst.setString(13, s.getEmail());
//			pst.setDouble(11, s.getSsc());
//			pst.setDouble(12, s.getHsc());
//			pst.setDouble(13, s.getBeaggregate());

			
			
			
			int result=pst.executeUpdate();
			allStudentList.add(s);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	@Override
	public void updateStudent(Student s) 
	{
		
		int sid=s.getSid();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="update "+TABLEStudent+" set "+COLsid+"=?, "+COLbacklog+"=?, "+COLstatus+"=?,"+COLpassword+"=?,"+COLsname+"=?,"+COLbranch+"=?, "+COLinstituteName+"=?, "+COLemail+"=?, "+COLphone+"=?, "+COLyearOfPassing+"=?, "+COLssc+"=?, "+COLhsc+"=?, "+COLbeaggregate+"=?  where sid="+sid+";";
			
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			
			pst.setInt(1,s.getSid());
			pst.setInt(2,s.getBacklog());
			pst.setInt(3,s.getStatus());
			pst.setString(4, s.getPassword());
			pst.setString(5, s.getSname());
			pst.setString(6, s.getBranch());
			pst.setString(7, s.getInstituteName());
			pst.setString(8, s.getEmail());
			pst.setLong(9, s.getPhone());
			pst.setInt(10,s.getYop());
			pst.setDouble(11, s.getSsc());
			pst.setDouble(12, s.getHsc());
			pst.setDouble(13, s.getBeaggregate());
			
			
			int result=pst.executeUpdate();
			
			for(Student st:allStudentList)
			{
				if(st.getSid()==s.getSid())
				{
					st.setSname(s.getSname());
					st.setInstituteName(s.getInstituteName());		
				}
			}

			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}

	@Override
	public void deleteStudent(Student s) 
	{
		int sid=s.getSid();
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlquery="delete from "+TABLEStudent+" where sid="+sid+";";
						
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			
			int result=pst.executeUpdate();
			 Student dummy=new Student();
				dummy.setSid(sid);
				//find student in list only
				if(allStudentList.contains(dummy))
				{
					//int index=allStudentList.indexOf(dummy);
					allStudentList.remove(dummy);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		
	}

	
	
	
}
