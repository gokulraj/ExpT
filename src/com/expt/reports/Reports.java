//$Id$
package com.expt.reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.expt.db.Connect;

public class Reports {

	public HashMap getReports() throws Exception{

		Connect c = new Connect();
		Statement stmt = null;
		Connection con = c.getCon();
		HashMap reportMap = new HashMap();

		try{

			String query = "select * from reports";
			stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery(query);
			//reportMap.put("none", "None");
			while(rs.next()){
				reportMap.put(rs.getInt("reportid"), rs.getString("reportname"));
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

	public String createReport(String reportname) throws Exception{

		Connect c = new Connect();
		PreparedStatement stmt = null;
		Connection con = c.getCon();
		String reportid = null;
		try{
			String query = "insert into reports(reportname) values(?)";
			con.setAutoCommit(false);
			stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, reportname);

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				reportid = rs.getString(1);
			}

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

		return reportid;
	}
}
