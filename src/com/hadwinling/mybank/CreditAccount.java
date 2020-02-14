package com.hadwinling.mybank;

import java.text.SimpleDateFormat;

/**

* 创建时间：2020年2月13日 下午7:19:03

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：CreditAccount.java

*/
public class CreditAccount extends Account{
	protected double ceiling;//透支金额
	
	public double getCeiling() {
		return ceiling;
	}
	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}
	/**
	 * 
	 */
	public CreditAccount() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param password
	 * @param name
	 */
	public CreditAccount(String password, String name,double ceiling) {
		super(password, name);
		// TODO Auto-generated constructor stub
		this.ceiling =ceiling;
	}
	public void withdraw(double money) {
		if(balance+ceiling <money) {
			System.out.println("余额不足，取款失败");
		}else if(balance>=money) {
			balance -=money;
			System.out.println("取款成功");
		}else {
			//透支了多少
			ceiling -=(money-balance);
			//余额清零
			balance = 0;
			System.out.println("取款成功");
		}
	}
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:dd ");
		return "账号："+id+" ，姓名："+name +" ,开户日期："+simpleDateFormat.format(open) +" ,账户余额："+balance+
				" ,透支余额："+ceiling;
	}
	
}
