package com.shubh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shubh.dao.BankDAOImpl;

@Component("service")
public class BankServiceImpl implements BankService {
	
	private BankDAOImpl dao;
	
	@Autowired
	public BankServiceImpl(BankDAOImpl dao) {

		this.dao = dao;
	}

//service method
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean transferMoney(int srcNo, int desNo, int amt) {
		int result1=0,result2=0;
		//System.out.println("srcno"+srcNo);
		result1=dao.withDraw(srcNo, amt);
		result2=dao.deposite(desNo, amt);
		//System.out.println("result1::"+result1);
		//System.out.println("result2::"+result2);

		if(result1==0||result2==0) 
			throw new RuntimeException("Money is not transfered(Trans RollBank)");
		
			else
				System.out.println("Money Transfer(Trans Commited)");
				
				return true;
	
		
		
	}

}
