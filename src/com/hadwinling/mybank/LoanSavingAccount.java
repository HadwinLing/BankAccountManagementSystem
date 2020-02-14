package com.hadwinling.mybank;

import java.text.SimpleDateFormat;

/**

* 创建时间：2020年2月13日 下午9:11:07

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：LoanSavingAccount.java

*/
public class LoanSavingAccount extends SavingAccount implements LoanAccount{
	private double Loan = 10000;
	/**
	 * 
	 */
	public LoanSavingAccount(String password,String name,double loan) {
		// TODO Auto-generated constructor stub
		super(password,name);
		this.Loan =loan ;
	}
	
	@Override
	public void requestLoan(double money) {//贷款
		// TODO Auto-generated method stub
		if (Loan<money) {
			System.out.println("贷款失败");
		}else {
			Loan -=money;
			System.out.println("贷款成功");
		}
		
		
	}

	@Override
	public void payLoan(double money) {//还贷
		// TODO Auto-generated method stub
		if(balance>=money) {
			balance-=money;
			System.out.println("还款成功");
		}else {
			System.out.println("余额不足，还款失败");
		}
		
	}

	@Override
	public double getLoan() {
		// TODO Auto-generated method stub
		
		return this.Loan;
	}
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:dd ");
		return "账号："+id+" ，姓名："+name +" ,开户日期："+simpleDateFormat.format(open) +" ,账户余额："+balance+
				" ,剩余贷款额度"+Loan ;
		
	}
	
}
