//$Id$
package com.expt.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javassist.expr.NewArray;

import com.expt.db.Connect;

public class Expense {

	public String getQuery(){
		String query = "insert into expense(amount,notes,category, expenserid, currency,createdtime,modifiedtime, createdby,modiefiedby,expensedate)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return query;
	}
	
	public void addExpense(HashMap<String, String> expenseMap) throws Exception{

		Connect c = new Connect();
		PreparedStatement stmt = null;
		Connection con = c.getCon();
		try{

			con.setAutoCommit(false);
			stmt = con.prepareStatement(getQuery());
			stmt.setDouble(1, Double.parseDouble(expenseMap.get("amount")));
			stmt.setString(2, expenseMap.get("notes"));
			stmt.setString(3, expenseMap.get("category"));
			stmt.setString(4, expenseMap.get("expenserid"));
			stmt.setString(5, expenseMap.get("currency"));
			stmt.setString(6, expenseMap.get("createdtime"));
			stmt.setString(7, expenseMap.get("modifiedtime"));
			stmt.setInt(8, Integer.parseInt(expenseMap.get("createdby")));
			stmt.setInt(9, Integer.parseInt(expenseMap.get("modiefiedby")));
			stmt.setString(10, expenseMap.get("expensedate"));

			stmt.executeUpdate();
			con.commit();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

	}
	
	public HashMap<String, HashMap<String, String>> getResult(String reportid){

		Connect c = new Connect();
		PreparedStatement stmt = null;
		Connection con = c.getCon();
		HashMap expenseMap = null;
		HashMap reportMap = new HashMap();

		try{

			String query = "select * from expense where reportid= ? ";
			stmt = con.prepareStatement(query);
			stmt.setString(1, reportid);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()){
				expenseMap = new HashMap<String, String>();
				expenseMap.put("amount", Double.valueOf(rs.getDouble("amount")).toString());
				expenseMap.put("users", rs.getString("users"));
				expenseMap.put("expensedate", rs.getString("expensedate"));
				expenseMap.put("category", rs.getString("category"));
				expenseMap.put("currency", rs.getString("currency"));
				expenseMap.put("notes", rs.getString("notes"));
				reportMap.put( "row" + rs.getRow() , expenseMap );
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		return reportMap;
	}
	
}
