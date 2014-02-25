//$Id$
package com.expt.db;

import java.sql.*;

public class Connect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/expense";

	static final String USER = "root";
	static final String PASS = "";
	Connection con = null;
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	Statement state = null;
	
	public Connect(){
		try{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(SQLException e ){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws Exception{

		Connect c = new Connect();
		
		try{

			c.state = c.con.createStatement();
			String sql = "Select * from test";
			ResultSet rs = c.state.executeQuery(sql);

			while(rs.next()){
				//Retrieve by column name
				String id  = rs.getString("id");
				String name = rs.getString("name");
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name );

			}

			rs.close();
			c.state.close();
			c.con.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(c.state!=null)
					c.state.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(c.con!=null)
					c.con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}	
