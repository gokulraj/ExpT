//$Id$
package com.expt.actions;

import org.apache.struts2.util.ServletContextAware;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.HashMap;

import com.expt.reports.Reports;
import com.opensymphony.xwork2.ActionSupport;

public class Home extends ActionSupport implements ServletContextAware  {

	ServletContext context;
	HashMap reportmap;
	String defaultReport = "none";
	
	public String getDefaultReport() {
		return defaultReport;
	}

	public void setDefaultReport(String defaultReport) {
		this.defaultReport = defaultReport;
	}

	public HashMap getReportmap() {
		return reportmap;
	}

	public void setReportmap(HashMap reportmap) {
		this.reportmap = reportmap;
	}

	public String execute(){

		Reports r = new Reports();
		try {
			setDefaultReport("Test");
			setReportmap(r.getReports());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}
}
