package com.hadwinling.mybank;

import java.util.Date;

/**

* 创建时间：2020年2月13日 下午6:47:23

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：Account.java

*/
public abstract class Account {
	protected long id;
	private static long sid = 10000;
	protected String password ;
	protected String name;
	protected Date open;
	protected double balance;
	Account(){
		super();
	}
	Account(String password,String name){
		this.id = ++sid;
		this.password = password;
		this.name = name;
		this.open = new Date();
		this.balance = 0;
		
	}
	public long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOpen() {
		return open;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//存款方法只有一种
	public final void deposit(double money) {
		this.balance +=money;
	}
	//将取款方法设置为抽象：因为有多个取款方式
	public abstract void withdraw(double money); 
	
	
	
	
	

}
