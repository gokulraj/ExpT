//$Id$
package com.expt.actions;


import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.expt.reports.Reports;
import com.expt.utils.DateTimeFormat;
import com.expt.utils.Expense;

import com.opensymphony.xwork2.ActionSupport;

public class ExpenseAct extends ActionSupport implements ServletRequestAware {

	String amount;
	String action;
	String selectreport;
	HashMap reportmap;
	HashMap expenseMap;
	
	public HashMap getExpenseMap() {
		return expenseMap;
	}
	public void setExpenseMap(HashMap expenseMap) {
		this.expenseMap = expenseMap;
	}
	public String getSelectreport() {
		return selectreport;
	}
	public void setSelectreport(String selectreport) {
		this.selectreport = selectreport;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public HashMap getReportmap() {
		return reportmap;
	}

	public void setReportmap(HashMap reportmap) {
		this.reportmap = reportmap;
	}

	HttpServletRequest request;
	

	public String execute(){
		
		System.out.println( " select 2 " + this.action );
		System.out.println( " select 1 " + this.selectreport );
		System.out.println( " select 1 " + this.amount );
		
		Expense e = new Expense();
		if ( "elist".equals(this.action) ){
			
			Reports r = new Reports();
			try {
				setReportmap(r.getReports());
				setExpenseMap(e.getResult(this.selectreport));
				System.out.println( " select 2 " + this.expenseMap );
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		else{
			setExptmap(null);
		
			try {
				//e.addExpense(this.exptmap);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
			
		 return SUCCESS;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getExpenserid() {
		return expenserid;
	}
	public void setExpenserid(Long expenserid) {
		this.expenserid = expenserid;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	public String getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}
	
	
	HashMap<String, String> exptmap; 
		
	public HashMap<String, String> getExptmap() {
		return exptmap;
	}
	public void setExptmap(HashMap<String, String> expenseMap) {
		System.out.println(" this.amount = " + this.amount);
		if(exptmap == null){
			expenseMap = new HashMap<String, String>();
			expenseMap.put("amount", this.amount.toString());
			expenseMap.put("notes", this.notes);
			expenseMap.put("category",this.category);
			expenseMap.put("expenserid","1001");
			expenseMap.put("currency", this.currency);
			DateTimeFormat df = new DateTimeFormat(DateTimeFormat.DB_DATETIEM_FORMAT);
			expenseMap.put("createdtime", df.getCurrentTimeInGMT());
			expenseMap.put("modifiedtime", df.getCurrentTimeInGMT());
			expenseMap.put("createdby" , "1001");
			expenseMap.put("modiefiedby", "1001");
			df.setFormat(DateTimeFormat.DB_FORMAT);
			expenseMap.put("expensedate" , this.expensedate );
		}
		this.exptmap = expenseMap;
	}


	String notes;
	String category;
	Long expenserid;
	String currency;
	String createdtime;
	String modifiedtime;
	String createdby;
	String modifiedby;
	String expensedate;


	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
