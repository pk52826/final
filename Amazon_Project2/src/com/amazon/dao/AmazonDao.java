package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.amazon.entity.Amazon1Customer;

public class AmazonDao implements AmazonDaoInterface{
	private AmazonDao(){}
public static AmazonDaoInterface createDaoObject() {
		
		return new AmazonDao();
	}

	public int createProfileDao(Amazon1Customer ac) {
		
		int i=0;
		try{
			
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:/finaltest_DS");
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into amazone values(?,?,?,?)");
			ps.setString(1, ac.getName());
			ps.setString(2, ac.getPass());
			ps.setString(3, ac.getEmail());
			ps.setString(4, ac.getAdddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

}
