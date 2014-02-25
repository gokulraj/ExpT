//$Id$
package com.expt.reports;

import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;
import com.expt.reports.Reports;
public class CreatReport extends ActionSupport {

	String reportname;
	HashMap reportmap;
	public HashMap getReportmap() {
		return reportmap;
	}

	public void setReportmap(HashMap reportmap) {
		this.reportmap = reportmap;
	}

	public String getDefaultReport() {
		return defaultReport;
	}

	public void setDefaultReport(String defaultReport) {
		this.defaultReport = defaultReport;
	}

	String defaultReport = "none";
	
	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public String execute(){
		Reports r = new Reports();
		try {
			r.createReport(this.reportname);
			setDefaultReport("None");
			System.out.println( this.defaultReport );
			setReportmap(r.getReports());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
