package com.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.POJO.UserPojo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserDao
{
	String url="jdbc:mysql://localhost:3306/batch5";
	String user="root";
	String password="password";
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertData(UserPojo userpojo) throws Exception
	{
		 Connection conn = connect();
		 String query = "insert into Crudtable(Id, Name, Designation) values(?,?,?)";
		 PreparedStatement pst = conn.prepareStatement(query);
		 pst.setInt(1,userpojo.getId());
		 pst.setString(2, userpojo.getName());
		 pst.setString(3, userpojo.getDesignation());
		 int rows = pst.executeUpdate();
		 if(rows>0)
		 {
			 System.out.println("Data inserted succesfully");
		 }
	}
	
	public List<UserPojo> selectAllData() throws Exception
	{
		List<UserPojo> user = new ArrayList();
		Connection conn = connect();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Crudtable");
		while(rs.next())
		{
			UserPojo userpojo = new UserPojo();
			userpojo.setId(rs.getInt("id"));
			userpojo.setName(rs.getString("name"));
			userpojo.setDesignation(rs.getString("designation"));
			user.add(userpojo);
		}
		return user;
	}
	
	public void deleteData(int id) throws Exception
	{
		String sql="delete from Crudtable where id=?";
		Connection conn = connect();
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		int row = pst.executeUpdate();
		if(row>=0)
		{
			System.out.println("data is deleted");
		}
		else	
		{
			System.out.println("data is not deleted");
		}

	}
	
	public UserPojo selectUser(int id) throws Exception 
	{
	    UserPojo user = new UserPojo();
	    Connection conn = connect();
	    String sql = "SELECT * FROM Crudtable WHERE id = ?";
	    PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setInt(1, id);
	    ResultSet rs = pst.executeQuery();

	    if (rs.next()) 
	    {
	        user.setId(rs.getInt("id"));
	        user.setName(rs.getString("name"));
	        user.setDesignation(rs.getString("designation"));
	    }
	    return user;
	}
	
	public void updateUser(UserPojo userpojo) throws Exception 
	{
	    String sql = "UPDATE Crudtable SET name = ?, designation = ? WHERE id = ?";
	    Connection conn = connect();
	    PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1, userpojo.getName());
	    pst.setString(2, userpojo.getDesignation());
	    pst.setInt(3, userpojo.getId());

	    int rows = pst.executeUpdate();
	    if (rows > 0) 
	    {
	        System.out.println("Data updated successfully");
	    }
	}	
}
