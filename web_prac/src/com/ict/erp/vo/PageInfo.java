package com.ict.erp.vo;

public class PageInfo {
	private int page;
	
	private int firstPage;
	private int lastPage;
	
	private int firstData;
	private int lastData;
	
	private int dataCnt;
	private int pageCnt;
	
	private int totalCnt;
	private int totalPage;
	private int totalBlock;
	
	private String sch;
	private String op;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getFirstData() {
		return firstData;
	}
	public void setFirstData(int firstData) {
		this.firstData = firstData;
	}
	public int getLastData() {
		return lastData;
	}
	public void setLastData(int lastData) {
		this.lastData = lastData;
	}
	public int getDataCnt() {
		return dataCnt;
	}
	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	
	
	
	public String getSch() {
		return sch;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", firstData="
				+ firstData + ", lastData=" + lastData + ", dataCnt=" + dataCnt + ", pageCnt=" + pageCnt + ", totalCnt="
				+ totalCnt + ", totalPage=" + totalPage + ", totalBlock=" + totalBlock + "]";
	}
	

	public void paging(int totalCnt, int pageCnt, int dataCnt) {
		this.totalCnt = totalCnt;
		this.pageCnt = pageCnt;
		this.dataCnt = dataCnt;
		
		this.totalPage = (int)Math.ceil((double)this.totalCnt / this.pageCnt);
		this.totalBlock = (int)Math.ceil((double)this.totalPage / this.dataCnt);
		
		this.firstPage = (this.page-1)/this.pageCnt * this.pageCnt+1;
		this.lastPage = this.firstPage + this.pageCnt -1;
		
		this.firstData = (this.page-1)*this.dataCnt+1;
		this.lastData = this.page * this.dataCnt;
		
		if(this.lastPage > this.totalPage) {
			this.lastPage = this.totalPage;
		}
		
		
		System.out.println(this);
		
	}
	
	
	
	
	
	
	
}
