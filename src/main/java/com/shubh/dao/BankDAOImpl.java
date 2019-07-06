package com.shubh.dao;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("bankDao")
public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANK_ACC SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANK_ACC SET BALANCE=BALANCE+? WHERE ACCNO=?";


	JdbcTemplate jt;
	
	@Autowired
	public BankDAOImpl(JdbcTemplate jt) {
	
		this.jt = jt;
	}

	public int withDraw(int accno, int amt) {
		int count=0;
		//System.out.println("accno"+accno);
		//System.out.println("amt"+);
		count=jt.update(WITHDRAW_QUERY, amt,accno);
		return count;
	}

	public int deposite(int accno, int amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY, amt,accno);
		
		return count;
	}

}
