package com.ict.erp.vo;

public class DepartInfo {
	private int diNum;
	private String diCode;
	private String diName;
	private String diDesc;
	private PageInfo PageInfo;
	
	public DepartInfo() {}
	
	
	public DepartInfo(int diNum, String diCode, String diName, String diDesc) {
		this.diNum = diNum;
		this.diCode = diCode;
		this.diName = diName;
		this.diDesc = diDesc;
	}
	
	public int getDiNum() {
		return diNum;
	}
	public void setDiNum(int diNum) {
		this.diNum = diNum;
	}
	public String getDiCode() {
		return diCode;
	}
	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	public String getDiName() {
		return diName;
	}
	public void setDiName(String diName) {
		this.diName = diName;
	}
	public String getDiDesc() {
		return diDesc;
	}
	public void setDiDesc(String diDesc) {
		this.diDesc = diDesc;
	}
	
	
	public PageInfo getPageInfo() {
		return PageInfo;
	}


	public void setPageInfo(PageInfo pageInfo) {
		PageInfo = pageInfo;
	}
	



	@Override
	public String toString() {
		return "DepartInfo [diNum=" + diNum + ", diCode=" + diCode + ", diName=" + diName + ", diDesc=" + diDesc + "]";
	}
	
	
	
	

}
