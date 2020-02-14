package com.hadwinling.mybank;

import java.util.Scanner;





/**

* 创建时间：2020年2月13日 下午7:29:54

* 项目名称：HadwingLing

* @author HadwinLing

* @version 1.0

* @since JDK 1.6.0_21

* 文件名称：Bank.java

*/
public class Bank {
	public final int MAX_ACCOUNTS = 100000;
	private Account []accounts = 	new Account[MAX_ACCOUNTS];
	private int curAccounts=0;
	//1.用户开户：开户类型：1.储蓄账户 2.信用账户 ，
	//输入密码,密码确认,姓名,自动获得电脑日期作为开户日期，
	//返回新创建的Account对象,
	/**
	 * 单例模式
	
	* <p>Title: creatAccount<／p>
	
	* <p>Description: <／p>
	
	* @param password
	* @param name
	* @return
	 */
	private static Bank bank;
	public static Bank getBank() {
		if (bank ==null) {
			bank = new Bank();
		}
		return bank;
	}
	
	//1.开户
	public Account creatAccount(String password,String name) {
		System.out.println("开户类型：1.存储账户  2.信用卡账户  3.存储贷款账户  4.信用卡贷款账户");
		Scanner input = new Scanner(System.in);
		System.out.print("请输入类型：  ");
		int choice =input.nextInt();
		switch (choice) {
		case 1:
			SavingAccount savingAccount = new SavingAccount(password,name);
			accounts[curAccounts++] = savingAccount;//??????
			System.out.println("开户成功");
			//打印开户信息，系统自动调用toString方法
			System.out.println(savingAccount);
			return savingAccount;
		case 2:
			//？？？？为什么这里要先输入一个10000
			CreditAccount creditAccount = new CreditAccount(password,name,10000);
			accounts[curAccounts++] = creditAccount;
			System.out.println("开户成功");
			//打印开户信息
			System.out.println(creditAccount);
			return creditAccount;
		case 3:
			//？？？？为什么这里要先输入一个10000
			LoanSavingAccount loanSavingAccount = new LoanSavingAccount(password,name,10000);
			accounts[curAccounts++] = loanSavingAccount;
			System.out.println("开户成功");
			//打印开户信息
			System.out.println(loanSavingAccount);
			return loanSavingAccount;
		case 4:
			//？？？？为什么这里要先输入一个10000
			LoanCreditAccount loanCreditAccount= new LoanCreditAccount(password,name,10000,10000);
			accounts[curAccounts++] = loanCreditAccount;
			System.out.println("开户成功");
			//打印开户信息
			System.out.println(loanCreditAccount);
			return loanCreditAccount;
		default:
			System.out.println("开户失败");
			return null;
		}
	}
	//2.登录
	public Account login(long id ,String password) {
		for(int i =0 ;i<curAccounts;i++) {
			if((accounts[i].id ==id)&&(accounts[i].password .equals(password))) {
//				System.out.println("登录成功");
				return accounts[i];
			}else {				
				System.out.println("登录失败");
			}
		}
		return null;
	}
	//3.统计银行所有账户余额总数
	public double allAccounts() {
		double sum =0;
		for(int i=0;i<curAccounts;i++) {
			sum +=accounts[i].getBalance();//只能通过getBalance()才能得到，？？？
		}
		return sum;
	}
	/**
	 * 
	 *instanceof 是 Java 的一个二元操作符，类似于 ==，>，< 等操作符。
	 *instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。
	 *以下实例创建了 displayObjectClass() 方法来演示 Java instanceof 关键字用法：
	 */
	//4.统计所有信用账户透支额度总数
	public double allCeiling() {
		double sum =0;
		for (int i = 0; i < curAccounts; i++) {
			if (accounts[i] instanceof CreditAccount) {
				//将account[i]强制类型转换为CreditAccount
				//如果没有强制类型转换的话，无法使用getCeiling()
				//因为accouts[i]是Account类的，该类中没有getCeiling()方法
				//强制类型转换：(CreditAccount)accounts[i]
				sum += ((CreditAccount)accounts[i]).getCeiling();
			}
		}
		return sum;
	}
	//5.用户存款
	public Account deposit(long id,double money) {
		for (int i = 0; i < curAccounts; i++) {
			if(accounts[i].id ==id) {
				accounts[i].deposit(money);
				System.out.println("存款成功");
				//打印信息
				System.out.println(accounts[i]);
				return accounts[i];
			}
		}
//		System.out.println("存款失败");
		return null ;
	} 
	//6.用户取款
	public Account withdraw(long id,double money) {
		for (int i = 0; i < curAccounts; i++) {
			if(accounts[i].id ==id) {
				accounts[i].withdraw(money);
				System.out.println("取款成功");
				//打印信息
				System.out.println(accounts[i]);
				return accounts[i];
			}
		}
//		System.out.println("存款失败");
		return null ;
	}
	//7.修改透支额度
	public Account changeCeiling(long id,double ceiling) {//ceiling为新的额度
		for (int i = 0; i < curAccounts; i++) {
			//将account[i]强制类型转换为CreditAccount
			//如果没有强制类型转换的话，无法使用getCeiling()
			//因为accouts[i]是Account类的，该类中没有getCeiling()方法
			//强制类型转换：(CreditAccount)accounts[i]
			if (accounts[i].id == id) {
				if (accounts[i] instanceof CreditAccount) {
					((CreditAccount)accounts[i]).setCeiling(ceiling);
					System.out.println(accounts[i]);
					return accounts[i];
				}
			}
		}
		System.out.println("修改额度失败");
		return null;
	}

	//8.贷款
	public Account requestLoan(long id ,double money) {
		for (int i = 0; i < curAccounts; i++) {
			if (accounts[i] instanceof LoanAccount) {
				((LoanAccount)accounts[i]).requestLoan(money);
				System.out.println("贷款成功");
				System.out.println(accounts[i]);
				return accounts[i];
			}
		}
		System.out.println("贷款失败");
		return null;
	}
	//9还贷
	public Account payLoan(long id ,double money) {
		for (int i = 0; i < curAccounts; i++) {
			if (accounts[i] instanceof LoanAccount) {
				((LoanAccount)accounts[i]).payLoan(money);
				System.out.println("还贷成功");
				System.out.println(accounts[i]);
				return accounts[i];
			}
		}
		System.out.println("还贷失败");
		return null;
	}
	//10.统计某一账户的所有贷款的总数
	public double getAllCeiling(long id) {
		double sum  =0 ;
		for (int i = 0; i < curAccounts; i++) {
			if (accounts[i].id ==id) {
				if (accounts[i] instanceof LoanAccount) {
					sum +=((LoanAccount)accounts[i]).getLoan();
				}
			}
		}
		return sum;
	}


	

}
