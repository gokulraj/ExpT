//$Id$
package com.expt.db;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class DBAction extends ActionSupport implements ServletContextAware {

	private String info = "Nothing";
	ServletContext context;
	
	public String getInfo(){
		return this.info;
	}
	
	public void setInfo(String info){
		this.info=info;
	}
	
	public void setServletContext(ServletContext context){
		this.context = context;
	}
	
	public String execute(){
		DBUtil db = new DBUtil();
		try{
			db.createTables(context.getRealPath("/conf/db.xml"));
			this.setInfo( " tables created ");
		}catch (Exception e) {
			this.setInfo("Check Logs");
		}

		return SUCCESS;
	}
}
