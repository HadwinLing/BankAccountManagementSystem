package com.hadwinling.mybank;

import java.text.SimpleDateFormat;

/**

* 创建时间：2020年2月13日 下午9:21:14

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：LoanCreditAccount.java

*/
public class LoanCreditAccount extends CreditAccount implements LoanAccount{

	private double Loan = 10000;

	/**
	 * @param password
	 * @param name
	 * @param ceiling
	 */
	public LoanCreditAccount(String password, String name, double ceiling,double Loan) {
		super(password, name, ceiling);
		// TODO Auto-generated constructor stub
		this.Loan = Loan ;
	}

	/* (non-Javadoc)
	 * @see com.hadwinling.day02.mybank.LoanAccount#requestLoan(double)
	 */
	@Override
	public void requestLoan(double money) {
		// TODO Auto-generated method stub
		if (Loan<money) {
			System.out.println("贷款失败");
		}else {
			Loan -=money;
			System.out.println("贷款成功");
		}
		
	}

	/* (non-Javadoc)
	 * @see com.hadwinling.day02.mybank.LoanAccount#payLoan(double)
	 */
	@Override
	public void payLoan(double money) {
		// TODO Auto-generated method stub
		if (balance>=money) {
			Loan +=money;
			balance-=money;
		}else {
			System.out.println("余额不足，还款失败");
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.hadwinling.day02.mybank.LoanAccount#getLoan(double)
	 */
	@Override
	public double getLoan() {
		// TODO Auto-generated method stub
		return this.Loan;
	}
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:dd ");
		return "账号："+id+" ，姓名："+name +" ,开户日期："+simpleDateFormat.format(open) +" ,账户余额："+balance+
				" ,透支余额："+ceiling+",剩余贷款额度："+Loan;
	}

}
