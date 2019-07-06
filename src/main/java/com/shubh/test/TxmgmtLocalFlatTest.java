package com.shubh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shubh.service.BankService;

public class TxmgmtLocalFlatTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		BankService proxy=null;
		ctx=new ClassPathXmlApplicationContext("com/shubh/cfgs/applicationContext.xml");
		
		proxy=ctx.getBean("service",BankService.class);
		try {
			
			System.out.println("Money Transfer"+proxy.transferMoney(1002, 1001, 1000));
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}

}
