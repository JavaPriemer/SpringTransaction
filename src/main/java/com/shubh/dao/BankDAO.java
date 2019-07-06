package com.shubh.dao;

public interface BankDAO {
	public int withDraw(int srcNo,int amt);
	public int deposite(int desNo,int amt);

}
