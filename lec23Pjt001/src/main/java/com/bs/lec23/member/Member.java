package com.bs.lec23.member;

public class Member {
	
	private String memId;
	private String memPw;
	private String memMail;
	private int memPurchaseNum;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public int getMemPurchaseNum() {
		return memPurchaseNum;
	}
	public void setMemPurchaseNum(int memPurchaseNum) {
		this.memPurchaseNum = memPurchaseNum;
	}
}